package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca {
    private static List<Book> bookList = new ArrayList<Book>();
    static {
        Book book1 = new Book(1,"Java","Tina",2019,true);
        Book book2 = new Book(2,"JavaScript","Bob",2018,true);
        Book book3 = new Book(3,"C#","Mary",2016,true);
        Book book4 = new Book(4,"PHP","XiaoMing",2017,true);
        Book book5 = new Book(5, "TDD", "XiaoHong", 2015,false);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
    }
    public String printWelcomeMsg() {
        return "Welcome to Biblioteca.Your one-stop shop for buying good books in bangalore!";
    }

    public String showBookNames() {
        return bookList.stream().filter(Book::getAvailable).map(Book::getBookName).collect(Collectors.joining("\n","","\n"));
    }

    public String showBooksAllInfo() {
        StringBuilder booksInfo = new StringBuilder();
        String delimiter = "|";
        for (Book book : bookList) {
            if(book.getAvailable()){
                String bookInfo = book.getBookName()+delimiter+book.getAuthor()+delimiter+book.getPublishYear()+"\n";
                booksInfo.append(bookInfo);
            }
        }
        return booksInfo.toString();
    }

    public String showMenuOptions() {
        return "0.Quit\n1.List of books";
    }

    public void start(){
        System.out.println(printWelcomeMsg());
        System.out.println(showMenuOptions());
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            checkOption(option);
        }

    }

    public boolean checkOption(String option) {
        int val;
        try{
            val = Integer.parseInt(option);
        }catch (Exception e){
            return false;
        }
        if(val==0){
            System.out.println("quit");
            System.exit(0);
            return true;
        }else if (val==1){
            System.out.println(showBookNames());
            return true;
        }else{
            System.out.println("Please select a valid option");
            return false;
        }
    }

    public String checkoutBook(String bookName) {
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName)&&book.getAvailable()==true){
                book.setAvailable(false);
                return "Thank you!Enjoy the book";
            }
        }
        return "Sorry,that book is not available";
    }

}
