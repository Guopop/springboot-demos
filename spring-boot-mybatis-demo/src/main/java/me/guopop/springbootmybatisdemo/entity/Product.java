package me.guopop.springbootmybatisdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author guopop
 * @date 2021/3/20 11:20
 */
@Getter
@Setter
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private BigDecimal price;
}
