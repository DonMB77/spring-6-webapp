package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.stereotype.Service;

public interface PublisherService {

    Iterable<Book> findAll();
}
