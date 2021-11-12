package me.guopop.ddd.infrastructure.util;

import java.util.UUID;

/**
 * @author guopop
 * @date 2021/10/25 11:19
 */
public class IdGenerator {

    public static String nextId(){
        return UUID.randomUUID().toString();
    }
}