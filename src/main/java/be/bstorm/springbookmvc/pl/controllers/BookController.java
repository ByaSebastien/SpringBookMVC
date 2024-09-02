package be.bstorm.springbookmvc.pl.controllers;

import be.bstorm.springbookmvc.bll.services.AuthorService;
import be.bstorm.springbookmvc.bll.services.BookService;
import be.bstorm.springbookmvc.dl.entities.Author;
import be.bstorm.springbookmvc.dl.entities.Book;
import be.bstorm.springbookmvc.pl.models.BookDetailsDTO;
import be.bstorm.springbookmvc.pl.models.author.AuthorDTO;
import be.bstorm.springbookmvc.pl.models.author.AuthorForm;
import be.bstorm.springbookmvc.pl.models.book.BookForm;
import be.bstorm.springbookmvc.pl.models.book.BookShortDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
@SessionAttributes("id")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public String getBooks(Model model) {
        List<BookShortDTO> books = bookService.getAllBooks().stream()
                .map(BookShortDTO::fromEntity)
                .toList();
        model.addAttribute("books", books);
        return "book/index";
    }

    @GetMapping("/{isbn}")
    public String getBook(@PathVariable String isbn, Model model) {
        BookDetailsDTO dto = BookDetailsDTO.fromEntity(bookService.getBookByIsbn(isbn));
        model.addAttribute("book", dto);
        return "book/detail";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("form",new BookForm());
        List<AuthorDTO> authors = authorService.findAll().stream()
                .map(AuthorDTO::fromEntity)
                .toList();
        model.addAttribute("authors", authors);
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(@Valid @ModelAttribute("form") BookForm form,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("form",form);
            List<AuthorDTO> authors = authorService.findAll().stream()
                    .map(AuthorDTO::fromEntity)
                    .toList();
            model.addAttribute("authors", authors);
            return "book/create";
        }

        bookService.addBook(form.toBusiness());
        return "redirect:/book";
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable String id, Model model) {
        BookForm form = BookForm.fromEntity(bookService.getBookById(Long.parseLong(id)));
        model.addAttribute("form",form);
        model.addAttribute("id", id);
        List<AuthorDTO> authors = authorService.findAll().stream()
                .map(AuthorDTO::fromEntity)
                .toList();
        model.addAttribute("authors", authors);
        return "book/create";
    }

    @PostMapping("/update")
    public String updateBook(@Valid @ModelAttribute("form") BookForm form,
                             BindingResult bindingResult, Model model) {
        Long id = Long.parseLong(model.getAttribute("id").toString());
        if(bindingResult.hasErrors()) {
            model.addAttribute("form",form);
            List<AuthorDTO> authors = authorService.findAll().stream()
                    .map(AuthorDTO::fromEntity)
                    .toList();
            model.addAttribute("authors", authors);
            model.addAttribute("id", id);
            return "book/update";
        }

        bookService.updateBook(id,form.toBusiness());

        return "redirect:/book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteBook(Long.parseLong(id));
        return "redirect:/book";
    }
}
