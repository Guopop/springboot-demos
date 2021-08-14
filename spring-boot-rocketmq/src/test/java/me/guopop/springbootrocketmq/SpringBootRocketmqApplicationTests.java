package me.guopop.springbootrocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringBootRocketmqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void sync() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("SYNC_GROUP");
        producer.setNamesrvAddr("39.105.47.81:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message("SYNC_TOPIC",
                    "SYNC_TAP",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.out.println(result);
        }
        producer.shutdown();
    }

    @Test
    void async() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ASYNC_GROUP");
        producer.setNamesrvAddr("39.105.47.81:9876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);

        int messageCount = 100;
        final CountDownLatch2 countDownLatch = new CountDownLatch2(messageCount);
        for (int i = 0; i < messageCount; i++) {
            final int index = i;
            Message message = new Message(
                    "ASYNC_TOPIC",
                    "ASYNC_TAG",
                    "OrderId188",
                    "Hello World".getBytes(StandardCharsets.UTF_8));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.printf("%-10d Exception %s %n", index, throwable);
                    throwable.printStackTrace();
                }
            });
        }
        countDownLatch.await(5, TimeUnit.SECONDS);
        producer.shutdown();
    }

    @Test
    void oneWay() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ONEWAY_GROUP");
        producer.setNamesrvAddr("39.105.47.81:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message(
                    "ONEWAY_TOPIC",
                    "ONEWAY_TAG",
                    ("Hello RocketMQ " + i).getBytes(StandardCharsets.UTF_8));

            producer.sendOneway(message);
        }
        producer.shutdown();
    }

}
