package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author guopop
 * @date 2021/1/29 9:24
 */
@SpringBootTest
@Slf4j
public class ConcurrencyProducerTest {

    @Autowired
    private ConcurrencyProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            producer.syncSend("concurrency " + i);
        }

        new CountDownLatch(1).await();
    }
}
