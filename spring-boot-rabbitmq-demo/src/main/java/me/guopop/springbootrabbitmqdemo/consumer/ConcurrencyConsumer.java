package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.ConcurrencyMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2021/1/29 9:21
 */
@Component
@RabbitListener(queues = ConcurrencyMessage.QUEUE, concurrency = "2")
@Slf4j
public class ConcurrencyConsumer {

    @RabbitHandler
    public void onMessage(String msg) {
        log.info("[consumer][thread: {}][message: {}]", Thread.currentThread().getId(), msg);
    }
}
