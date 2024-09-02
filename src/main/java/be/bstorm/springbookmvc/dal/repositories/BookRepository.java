package be.bstorm.springbookmvc.dal.repositories;

import be.bstorm.springbookmvc.dl.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select b from Book b where b.isbn ilike :isbn")
    Optional<Book> findByIsbn(@Param("isbn") String isbn);

    @Query("select count(b) > 0 from Book b where b.isbn ilike :isbn")
    boolean existsByIsbn(@Param("isbn") String isbn);
}
