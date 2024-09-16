package com.example.Book.controller;

import com.example.Book.response.BookResponse;
import com.example.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponse> getBookDetails(@PathVariable("id") int id) {
        BookResponse bookResponse = bookService.findBookByBookId(id);

        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }

}
