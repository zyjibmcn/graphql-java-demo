package com.example.graphql.demo.repository;

import com.example.graphql.demo.model.Author;
import com.example.graphql.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> allBooks = Arrays.asList(new Book("1001", "Book 1001", new Author("Jim", "Green")), new Book("1002", "Book 1002", new Author("Kate", "Green")));

    public List<Book> getBooks() {
        return allBooks;
    }

    public Book getBookByIsbn(String isbn) {
        return allBooks.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
    }
}
