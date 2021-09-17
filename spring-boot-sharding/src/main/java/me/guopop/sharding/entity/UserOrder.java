package me.guopop.sharding.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author guopop
 * @date 2021/9/17 11:01
 */
@Getter
@Setter
@Entity
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
}
