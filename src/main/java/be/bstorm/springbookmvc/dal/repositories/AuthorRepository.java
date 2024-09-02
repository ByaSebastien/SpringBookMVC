package be.bstorm.springbookmvc.dal.repositories;

import be.bstorm.springbookmvc.dl.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
