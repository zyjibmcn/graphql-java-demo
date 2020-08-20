package com.example.graphql.demo.service;

import com.example.graphql.demo.model.Book;
import com.example.graphql.demo.repository.BookRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @GraphQLQuery
    public List<Book> allBooks() {
        return bookRepository.getBooks();
    }

    @GraphQLQuery
    public Book bookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }
}
