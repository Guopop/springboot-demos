package me.guopop.springboot.cache.repository;

import me.guopop.springboot.cache.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author guopop
 * @date 2021/9/13 14:43
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
