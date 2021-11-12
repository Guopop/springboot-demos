package me.guopop.springboot.cache.service;

import me.guopop.springboot.cache.entity.Book;
import me.guopop.springboot.cache.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guopop
 * @date 2021/9/13 14:44
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable(cacheNames = "books", key = "#isbn")
    public String getBookTitleByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElse(new Book("non book"));
        return book.getTitle();
    }

    @CachePut(cacheNames = "books", key = "#isbn")
    public String updateBookTitleByIsbn(String isbn, String title) {
        bookRepository.findByIsbn(isbn).ifPresent(book -> {
            book.setTitle(title);
            bookRepository.save(book);
        });
        return bookRepository.findByIsbn(isbn).orElse(new Book("non book")).getTitle();
    }

    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "books", key = "#isbn")
    public void deleteBookByIsbn(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }
}
