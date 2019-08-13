package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private static List<Book> bookList = new ArrayList<Book>();
    static {
        Book book1 = new Book(1,"Java","Tina",2019);
        Book book2 = new Book(2,"JavaScript","Bob",2018);
        Book book3 = new Book(3,"C#","Mary",2016);
        Book book4 = new Book(4,"PHP","XiaoMing",2017);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
    }
    public String printWelcomeMsg() {
        return "Welcome to Biblioteca.Your one-stop shop for buying good books in bangalore!";
    }

    public String showBookNames() {
        return bookList.stream().map(Book::getBookName).collect(Collectors.joining("\n","","\n"));
    }

    public String showBooksAllInfo() {
        StringBuilder booksInfo = new StringBuilder();
        String delimiter = "|";
        for (Book book : bookList) {
            String bookInfo = book.getBookName()+delimiter+book.getAuthor()+delimiter+book.getPublishYear()+"\n";
            booksInfo.append(bookInfo);
        }
        return booksInfo.toString();
    }
}
