package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AcknowledgeProducerTest {

    @Autowired
    private AcknowledgeProducer acknowledgeProducer;

    @Test
    void syncSend() throws InterruptedException {
        String msg = "acknowledge";
        acknowledgeProducer.syncSend(msg);
        log.info("[producer][msg: {}][success]", msg);

        new CountDownLatch(1).await();
    }
}