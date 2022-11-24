package com.kode19.springrestapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    public void saveOrUpdate(Book books) {
        bookRepository.save(books);
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public void update(Book books, int bookid) {
        bookRepository.save(books);
    }

}
