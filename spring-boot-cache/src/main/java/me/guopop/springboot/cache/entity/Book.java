package me.guopop.springboot.cache.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author guopop
 * @date 2021/9/13 14:40
 */
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String isbn;

    private String title;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }
}
