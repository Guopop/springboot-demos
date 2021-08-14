package me.guopop.springbootjpa.repository;

import me.guopop.springbootjpa.entity.User;
import me.guopop.springbootjpa.model.NameOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author guopop
 * @date 2021/5/24 17:39
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, QuerydslPredicateExecutor<User> {

    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
    User findByLastnameOrFirstname(@Param("lastname") String lastname,
                                   @Param("firstname") String firstname);

//    @Query("select u from #{#entityName} u where u.lastname = ?1")
//    List<User> findByLastname(String lastname);

    @Transactional
    @Modifying
    @Query("update User u set u.firstname = ?1 where u.lastname = ?2")
    int setFixedFirstnameFor(String firstname, String lastname);

    @Transactional
    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteByUerId(Long id);

    Collection<NameOnly> findByLastname(String lastname);

    <T> Collection<T> findByLastname(String lastname, Class<T> type);
}
