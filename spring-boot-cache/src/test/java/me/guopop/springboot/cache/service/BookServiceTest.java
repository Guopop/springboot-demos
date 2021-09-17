package me.guopop.springboot.cache.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getBookTitleByIsbn() {
        String title = bookService.getBookTitleByIsbn("123");
        System.out.println(title);
    }

    @Test
    void updateBookTitleByIsbn() {
        String title = bookService.updateBookTitleByIsbn("123", "book123123");
        System.out.println(title);
    }

    @Test
    void deleteByIsbn() {
        bookService.deleteBookByIsbn("123");
    }
}