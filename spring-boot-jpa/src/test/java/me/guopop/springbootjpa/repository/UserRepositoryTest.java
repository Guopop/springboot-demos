package me.guopop.springbootjpa.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QTuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.guopop.springbootjpa.entity.QRole;
import me.guopop.springbootjpa.entity.QUser;
import me.guopop.springbootjpa.entity.User;
import me.guopop.springbootjpa.model.NameOnly;
import me.guopop.springbootjpa.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void findByLastnameOrFirstname() {
        User user = userRepository.findByLastnameOrFirstname("Guopop333", "Guopop333");
        System.out.println(user);
    }

    @Test
    void findByLastname() {
//        List<User> users = userRepository.findByLastname("Sean");
//        System.out.println(users);
        Collection<NameOnly> s = userRepository.findByLastname("bb");
        for (NameOnly i : s) {
            System.out.println(i.getFirstname());
            System.out.println(i.getLastname());
        }
    }

    @Test
    void setFixedFirstnameFor() {
        int i = userRepository.setFixedFirstnameFor("guopop", "Sean");
        System.out.println(i);
    }

    @Test
    void deleteByUerId() {
        userRepository.deleteByUerId(2L);
    }

    @Test
    void update() {
        Collection<NameOnly> a = userRepository.findByLastname("bb", NameOnly.class);
        for (NameOnly i : a) {
            System.out.println(i.getFirstname());
            System.out.println(i.getLastname());
        }

        Collection<User> b = userRepository.findByLastname("bb", User.class);
        for (User i : b) {
            System.out.println(i.getFirstname());
            System.out.println(i.getLastname());
        }
    }

    @Test
    void specification() {
        String firstname = "aa";

        Specification<User> specification = (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("firstname"), firstname);

        List<User> all = userRepository.findAll(specification);
        all.forEach(user -> {
            System.out.println(user.getFirstname());
            System.out.println(user.getLastname());
        });
    }

    @Test
    void combinedSpecification() {
        Specification<User> s1 = (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("firstname"), "aa");

        Specification<User> s2 = (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("firstname"), "guopop");

        List<User> all = userRepository.findAll(s1.or(s2));
        all.forEach(user -> {
            System.out.println(user.getFirstname());
            System.out.println(user.getLastname());
        });
    }

    @Test
    void queryByExample() {
        User user = new User();
        user.setFirstname("Guopop");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("firstname")
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<User> example = Example.of(user, matcher);

        List<User> all = userRepository.findAll(example);

        all.forEach(user1 -> {
            System.out.println(user1.getFirstname());
            System.out.println(user1.getLastname());
        });
    }

    @Test
    void insert() {
        User user = new User();
        user.setFirstname("rrr");
        user.setLastname("kkk");
        user.setAge(23);
        userRepository.save(user);
    }

    @Test
    void update1() {
        User user = userRepository.findById(3L).orElseThrow(RuntimeException::new);
        user.setFirstname("firstname");
        userRepository.save(user);
    }

    @Test
    void insert1() {
        User user = new User();
        user.setLastname("ooo");
        user.setAge(23);
        userRepository.save(user);
    }

    @Test
    void queryDsl() {
        QUser user = QUser.user;
        BooleanExpression and = user.firstname.equalsIgnoreCase("FirstName").and(user.lastname.startsWithIgnoreCase("k"));
        Iterable<User> all = userRepository.findAll(and);
        all.forEach(u -> {

            System.out.println(u.getFirstname());
            System.out.println(u.getLastname());
        });
    }

    @Test
    void queryDsl1() {
        QUser user = QUser.user;
        QRole role = QRole.role;
        List<UserDTO> s = jpaQueryFactory
                .select(user.firstname, role.name)
                .from(user)
                .innerJoin(role)
                .on(user.roleId.eq(role.id))
                .fetch()
                .stream()
                .map(tuple -> UserDTO.builder()
                        .firstname(tuple.get(user.firstname))
                        .name(tuple.get(role.name))
                        .build())
                .collect(Collectors.toList());

        s.forEach(a -> {
            System.out.println(a.getFirstname());
            System.out.println(a.getName());
        });
    }
}