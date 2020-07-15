package fr.afcepf.ad1.library.repositories;

import fr.afcepf.ad1.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
