package com.kode19.springrestapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookService.getAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{bookid}")
    private ResponseEntity<Book> getBook(@PathVariable("bookid") int bookid) {
        Book book = bookService.getBookById(bookid);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        bookService.delete(bookid);
    }

    @PostMapping
    private void saveBook(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
    }

    @PutMapping
    private void update(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
    }
}
