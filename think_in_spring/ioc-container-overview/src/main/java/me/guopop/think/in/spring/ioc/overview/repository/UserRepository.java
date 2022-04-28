package me.guopop.think.in.spring.ioc.overview.repository;

import me.guopop.think.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author guopop
 * @date 2021/11/12 23:02
 */
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;

    public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
        return applicationContextObjectFactory;
    }

    public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
        this.applicationContextObjectFactory = applicationContextObjectFactory;
    }

    //    private ObjectFactory<User> userObjectFactory;
//
//    public ObjectFactory<User> getUserObjectFactory() {
//        return userObjectFactory;
//    }
//
//    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
//        this.userObjectFactory = userObjectFactory;
//    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
