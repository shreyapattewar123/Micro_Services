package com.example.Book.service;


import com.example.Book.entity.Book;
import com.example.Book.repository.BookRepo;
import com.example.Book.response.BookResponse;
import org.hibernate.annotations.SecondaryRow;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    ModelMapper modelMapper;
    public BookResponse findBookByBookId(int bookId){
        Book book=bookRepo.findById(bookId).get();
        BookResponse bookResponse =modelMapper.map(book,BookResponse.class);
        return bookResponse;

    }

}

