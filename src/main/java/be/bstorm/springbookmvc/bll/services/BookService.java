package be.bstorm.springbookmvc.bll.services;

import be.bstorm.springbookmvc.bll.models.BookFormBusiness;
import be.bstorm.springbookmvc.dl.entities.Book;
import jakarta.validation.Valid;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book getBookByIsbn(String isbn);
    void addBook(BookFormBusiness book);
    void updateBook(Long id,BookFormBusiness book);
    void deleteBook(Long id);
}
