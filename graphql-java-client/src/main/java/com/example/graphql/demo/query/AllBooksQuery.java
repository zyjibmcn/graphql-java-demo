package com.example.graphql.demo.query;

import com.example.graphql.demo.model.Book;
import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import lombok.Data;

import java.util.List;

@Data
public class AllBooksQuery {
    @GraphQLProperty(name = "allBooks")
    private List<Book> books;
}
