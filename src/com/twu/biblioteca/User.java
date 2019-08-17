package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Book> bookList;
    private String name;
    private String email;
    private String phone;

    public User(String username, String password, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.bookList = new ArrayList<>();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password, List<Book> bookList,String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.bookList = bookList;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
