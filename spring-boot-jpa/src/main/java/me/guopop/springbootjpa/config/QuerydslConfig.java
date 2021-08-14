package me.guopop.springbootjpa.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author guopop
 * @date 2021/5/29 10:57
 */
@Configuration
public class QuerydslConfig {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    
    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
