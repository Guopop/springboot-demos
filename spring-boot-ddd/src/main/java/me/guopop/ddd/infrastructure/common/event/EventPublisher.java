package me.guopop.ddd.infrastructure.common.event;

import me.guopop.ddd.domain.leave.event.LeaveEvent;
import org.springframework.stereotype.Service;

/**
 * @author guopop
 * @date 2021/10/25 11:18
 */
@Service
public class EventPublisher {
    public void publish(LeaveEvent event) {
        // send to MQ
        // mq.send(event)
    }
}