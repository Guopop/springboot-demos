package me.guopop.springbootevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author guopop
 * @date 2021/5/20 10:31
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void register(User user) {
        log.info("用户: {}已注册！", user.getName());
        publisher.publishEvent(new UserRegisterEvent(user));
    }
}
