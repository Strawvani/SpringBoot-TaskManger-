package com.example.taskmanager.Repository;

import com.example.taskmanager.Models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {

    private HashMap<Integer, Book> books = new HashMap<>();

    public BookRepository(){
        books.put(1,new Book("The Silent Horizon", "March 12, 2015","Daniel Carter"));
        books.put(2,new Book("Echoes of Tomorrow", "July 8, 2017","Sophia Bennett"));
        books.put(3,new Book("The Last Ember", "November 21, 2018","Michael Reynolds"));
        books.put(4,new Book("Whispers in the Valley", "May 3, 2016","Olivia Hart"));
        books.put(5,new Book("Beyond the Iron Gate", "September 14, 2019","Jonathan Pierce"));
        books.put(6,new Book("Fragments of Eternity", "May 3, 2016","Isabella Clarke"));
        books.put(7,new Book("The Clockmaker’s Secret", "June 10, 2014","William Foster"));
    }

    public ArrayList<Book> findAll (){
        return new ArrayList<>(books.values());
    }

    public Book findByID (int ID){
        return books.get(ID);
    }

    public String add(int ID, Book book){
        books.put(ID, book);
        return book.getTitle() + " Successfully Added!";
    }

}
