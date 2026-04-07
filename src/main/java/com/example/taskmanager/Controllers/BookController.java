package com.example.taskmanager.Controllers;


import com.example.taskmanager.Models.Book;
import com.example.taskmanager.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(required = false) Integer ID){
        if (ID != null){
            if (ID <= 0){
                return ResponseEntity.badRequest().body("Invalid ID");
            }
            return ResponseEntity.ok(bookService.getBookByID(ID));
        }
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestParam int ID, @RequestBody Book book){
        return ResponseEntity.status(201).body(bookService.addBook(ID, book));
    }

}
