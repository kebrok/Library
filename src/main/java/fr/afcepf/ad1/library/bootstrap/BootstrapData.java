package fr.afcepf.ad1.library.bootstrap;

import fr.afcepf.ad1.library.model.Author;
import fr.afcepf.ad1.library.model.Book;
import fr.afcepf.ad1.library.model.Publisher;
import fr.afcepf.ad1.library.repositories.AuthorRepository;
import fr.afcepf.ad1.library.repositories.BookRepository;
import fr.afcepf.ad1.library.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","123124");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "789123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher negrier = new Publisher("name", "addressLine1", "city", "state", "zipCode");
        publisherRepository.save(negrier);

        System.out.println("number of books : " + bookRepository.count());
        System.out.println("Editeur : " + negrier.getName());

    }
}
