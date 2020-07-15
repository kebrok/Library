package fr.afcepf.ad1.library.repositories;

import fr.afcepf.ad1.library.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
