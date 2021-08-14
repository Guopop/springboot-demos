package me.guopop.springbootevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author guopop
 * @date 2021/5/20 10:26
 */
public class UserRegisterEvent<T> extends ApplicationEvent {
    public UserRegisterEvent(T entity) {
        super(entity);
    }
}
