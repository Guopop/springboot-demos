package me.guopop.think.in.spring.ioc.overview.dependency.injection;

import me.guopop.think.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guopop
 * @date 2021/11/12 23:03
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/MATE-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

//        System.out.println(userRepository.getBeanFactory() == beanFactory);

//        System.out.println(userRepository.getUserObjectFactory().getObject());


        System.out.println(userRepository.getApplicationContextObjectFactory().getObject() == beanFactory);
    }
}
