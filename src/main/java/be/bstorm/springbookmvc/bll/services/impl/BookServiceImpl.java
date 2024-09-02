package be.bstorm.springbookmvc.bll.services.impl;

import be.bstorm.springbookmvc.bll.models.BookFormBusiness;
import be.bstorm.springbookmvc.bll.services.BookService;
import be.bstorm.springbookmvc.dal.repositories.AuthorRepository;
import be.bstorm.springbookmvc.dal.repositories.BookRepository;
import be.bstorm.springbookmvc.dl.entities.Author;
import be.bstorm.springbookmvc.dl.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow();
    }

    @Override
    public void addBook(BookFormBusiness b) {

        if(bookRepository.existsByIsbn(b.getIsbn())){
            throw new RuntimeException("Book with ISBN " + b.getIsbn() + " already exists");
        }
        if(b.getAuthorId() != null){
            b.setAuthor(authorRepository.findById(b.getAuthorId()).orElseThrow());
        }
        bookRepository.save(b.toEntity());
    }

    @Override
    public void updateBook(Long id, BookFormBusiness b) {

        Book existingBook = bookRepository.findById(id).orElseThrow();
        if(b.getAuthorId() != null){
            Author author = authorRepository.findById(b.getAuthorId()).orElseThrow();
            b.setAuthor(author);
        }
        existingBook.setIsbn(b.getIsbn());
        existingBook.setTitle(b.getTitle());
        existingBook.setDescription(b.getDescription());
        existingBook.setPublicationDate(b.getPublishedDate());
        existingBook.setAuthor(b.getAuthor());
        bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        if(!bookRepository.existsById(id)){
            throw new RuntimeException("Book with Id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }
}
