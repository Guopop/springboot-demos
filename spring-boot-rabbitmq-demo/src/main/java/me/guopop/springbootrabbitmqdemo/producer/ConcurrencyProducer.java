package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.ConcurrencyMessage;
import me.guopop.springbootrabbitmqdemo.message.DirectExchangeMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author guopop
 * @date 2020/12/26 9:17
 */
@Component
public class ConcurrencyProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(String msg) {
        rabbitTemplate.convertAndSend(ConcurrencyMessage.EXCHANGE, ConcurrencyMessage.ROUTING_KEY, msg);
    }

    public void syncSendDefault(String msg) {
        rabbitTemplate.convertAndSend(ConcurrencyMessage.QUEUE, msg);
    }

    @Async
    public ListenableFuture<Void> asyncSend(String msg) {
        try {
            this.syncSend(msg);
            return AsyncResult.forValue(null);
        } catch (Exception e) {
            return AsyncResult.forExecutionException(e);
        }
    }
}
