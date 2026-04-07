package com.example.taskmanager.Models;

public class Book {

    private String title;
    private String publicationDate;
    private String author;
    public Book(String title, String publicationDate, String author) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getpublicationDate() {
        return publicationDate;
    }

    public String getAuthor() {
        return author;
    }
}
