package me.guopop.ddd.infrastructure.common.event;

import lombok.Data;

import java.util.Date;

/**
 * @author guopop
 * @date 2021/10/25 11:18
 */
@Data
public class DomainEvent {

    String id;
    Date timestamp;
    String source;
    String data;
}