package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Book> bookList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookList = new ArrayList<>();
    }

    public User(String username, String password, List<Book> bookList) {
        this.username = username;
        this.password = password;
        this.bookList = bookList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
