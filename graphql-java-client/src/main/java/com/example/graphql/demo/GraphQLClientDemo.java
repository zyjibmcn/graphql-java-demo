package com.example.graphql.demo;

import com.example.graphql.demo.model.Book;
import com.example.graphql.demo.query.AllBooksQuery;
import com.example.graphql.demo.query.BookByIdQuery;
import io.aexp.nodes.graphql.*;

import java.net.MalformedURLException;

public class GraphQLClientDemo {
    public static void main(String[] args) throws MalformedURLException {
        GraphQLTemplate template = new GraphQLTemplate();
        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url("http://localhost:8000/graphql")
                .request(AllBooksQuery.class)
                .build();

        System.out.println("## request: " + requestEntity.getRequest());
        GraphQLResponseEntity responseEntity = template.execute(requestEntity, AllBooksQuery.class);
        AllBooksQuery  response = (AllBooksQuery) responseEntity.getResponse();
        System.out.println("## response: " + response);
        for(Book book : response.getBooks()) {
            System.out.println("### isbn: " + book.getIsbn() + ", title: " + book.getTitle());
        }

        requestEntity = GraphQLRequestEntity.Builder()
                .url("http://localhost:8000/graphql")
                .request(BookByIdQuery.class)
                .arguments(new Arguments("book", new Argument("isbn", "1001")))
                .build();

        System.out.println("## request: " + requestEntity.getRequest());
        responseEntity = template.execute(requestEntity, BookByIdQuery.class);
        BookByIdQuery response1 = (BookByIdQuery) responseEntity.getResponse();
        System.out.println("## response1: " + response1);
    }
}
