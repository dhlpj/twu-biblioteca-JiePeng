package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca {
    private  List<Book> bookList = new ArrayList<Book>();
    private List<Movie> movieList = new ArrayList<>();
    {
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
        Movie movie1 = new Movie("Avengers: Endgame",2019,"Anthony Russo",8.6f,true);
        Movie movie2 = new Movie("The Lion King",2019,"Jon Favreau",7.1f,true);
        Movie movie3 = new Movie("Fast & Furious Presents: Hobbs & Shaw",2019,"David Leitch",6.9f,false);
        Movie movie4 = new Movie("Spider-Man: Far From Home",2019,"Jon Watts",7.9f,true);
        Movie movie5 = new Movie("Crawl",2019," Alexandre Aja",6.6f,true);
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);
        movieList.add(movie5);
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
        return "0.Quit\n" +
                "1.List of book\n" +
                "2.checkout a book\n" +
                "3.return a book\n" +
                "4.List of movie";
    }

    public void start(){
        System.out.println(printWelcomeMsg());
        while(true) {
            System.out.println(showMenuOptions());
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
        }else if (val==2){
            chooseCheckoutBook();
            return true;
        }else if (val==3){
            chooseReturnBook();
            return true;
        }else if (val==4){
            System.out.println(showMovieList());
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

    public void chooseCheckoutBook(){
        System.out.println("input book's name:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        System.out.println(checkoutBook(bookName));
    }

    public String returnBook(String bookName) {
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName)&&book.getAvailable()==false){
                book.setAvailable(true);
                return "Thank you for returning the book";
            }
        }
        return "That is not a valid book to return";
    }

    public void chooseReturnBook(){
        System.out.println("input book's name:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        System.out.println(returnBook(bookName));
    }

    public String showMovieList() {
        StringBuilder moviesInfo = new StringBuilder();
        String delimiter = "|";
        for (Movie movie : movieList) {
            if (movie.getAvailable()){
                String movieInfo = movie.getMovieName()+delimiter+movie.getYear()+delimiter+movie.getDirector()+delimiter+movie.getMovieRating()+"\n";
                moviesInfo.append(movieInfo);
            }
        }
        return moviesInfo.toString();
    }
}
