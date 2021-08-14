package me.guopop.springbootrabbitmqdemo.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.AcknowledgeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author guopop
 * @date 2021/2/2 16:14
 */
@Component
@RabbitListener(queues = AcknowledgeMessage.QUEUE)
@Slf4j
public class AcknowledgeConsumer {

    public void onMessage(String msg, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[onMessage][线程编号:{}][消息内容:{}]", Thread.currentThread().getId(), msg);
        channel.basicAck(deliveryTag, false);
    }
}
