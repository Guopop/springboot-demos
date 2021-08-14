package me.guopop.springbootevent;

import lombok.Builder;
import lombok.Data;

/**
 * @author guopop
 * @date 2021/5/20 10:39
 */
@Data
@Builder
public class User {
    private String name;

    private Integer age;
}
