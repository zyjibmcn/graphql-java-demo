package com.example.graphql.demo.query;

import com.example.graphql.demo.model.Book;
import io.aexp.nodes.graphql.annotations.GraphQLArgument;
import io.aexp.nodes.graphql.annotations.GraphQLProperty;
import io.aexp.nodes.graphql.annotations.GraphQLVariable;
import lombok.Data;

@Data
public class BookByIdQuery {
//    @GraphQLVariable(name = "isbn", scalar = "String")
    @GraphQLArgument(name = "isbn")
    @GraphQLProperty(name = "bookByIsbn")
    private Book book;
}
