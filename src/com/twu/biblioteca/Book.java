package com.twu.biblioteca;

public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Integer publishYear;
    private Boolean available;

    public Book(Integer id, String bookName, String author, Integer publishYear,Boolean available) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publishYear = publishYear;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
