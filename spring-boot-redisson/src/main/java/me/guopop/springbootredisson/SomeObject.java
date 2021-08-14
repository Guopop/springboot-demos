package me.guopop.springbootredisson;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2021/7/14 14:08
 */
@Builder
@Data
public class SomeObject implements Serializable {
    private static final long serialVersionUID = -1458633041953948598L;

    private String name;

    private Integer price;
}
