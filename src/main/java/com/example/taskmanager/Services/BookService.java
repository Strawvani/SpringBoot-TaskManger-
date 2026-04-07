package com.example.taskmanager.Services;

import com.example.taskmanager.Models.Book;
import com.example.taskmanager.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public ArrayList<Book> getAllBooks(){
       ArrayList<Book> books = bookRepository.findAll();
       if (books.isEmpty()){
           throw new RuntimeException("No Books Found");
       }
       return books;
    }

    public Book getBookByID(int ID){
       if (ID <= 0){
           throw new IllegalArgumentException("ID cannot be less than or equal 0");
       }
       Book book = bookRepository.findByID(ID);
       if (book == null){
           throw new RuntimeException("Book with ID: " + ID +" was not found");
       }
       return book;
    }

    public String addBook(int ID, Book book){
        if (bookRepository.findByID(ID) != null){
            return "Book with ID: " + " Already Exist.";
        }
        bookRepository.add(ID,book);
        return book.getTitle() + " Successfully Added";
    }

}
