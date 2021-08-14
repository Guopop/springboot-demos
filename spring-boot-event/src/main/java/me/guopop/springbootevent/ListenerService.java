package me.guopop.springbootevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author guopop
 * @date 2021/5/20 10:27
 */
@Slf4j
@Service
public class ListenerService {

    @EventListener
    @Order(1)
    public void sendEmail(UserRegisterEvent<User> event) {
        log.info("1. 邮件服务接到通知，给{}发送邮件", ((User) event.getSource()).getName());
    }

    @EventListener
    @Order(2)
    public void sendSms(UserRegisterEvent<User> event) {
        log.info("2. 短信服务接到通知，给{}发送短信", ((User) event.getSource()).getName());
    }
}
