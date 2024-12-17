package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author frankHerbert = new Author();
        frankHerbert.setFirstName("Frank");
        frankHerbert.setLastName("Herbert");

        Book dune = new Book();
        dune.setTitle("Dune");
        dune.setIsbn("2132455125");

        Author frankHerbertSavedEntry = authorRepository.save(frankHerbert);
        Book duneSavedEntry = bookRepository.save(dune);

        Author georgeOrwell = new Author();
        frankHerbert.setFirstName("George");
        frankHerbert.setLastName("Orwell");

        Book ninteeneightyfour = new Book();
        dune.setTitle("1984");
        dune.setIsbn("1245125");

        Author georgeOrwellSavedEntry = authorRepository.save(georgeOrwell);
        Book ninteeneightyfourSavedEntry = bookRepository.save(ninteeneightyfour);

        frankHerbertSavedEntry.getBooks().add(duneSavedEntry);
        georgeOrwellSavedEntry.getBooks().add(ninteeneightyfourSavedEntry);

        authorRepository.save(frankHerbertSavedEntry);
        authorRepository.save(georgeOrwellSavedEntry);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");

        Publisher publisherSavedEntry = publisherRepository.save(publisher);

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
