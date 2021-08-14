package me.guopop.springbootmybatisplusdemo.entity;

import lombok.Data;

/**
 * @author guopop
 * @date 2021/3/22 10:07
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
