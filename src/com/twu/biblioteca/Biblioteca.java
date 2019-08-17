package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca {
    private User currentUser;
    private  List<Book> bookList = new ArrayList<Book>();
    private List<Movie> movieList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
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
        ArrayList<Book> checkedoutBooks = new ArrayList<>();
        checkedoutBooks.add(book5);
        User user1 = new User("111-1234","123456",checkedoutBooks);
        User user2 = new User("222-2345","111111");
        User user3 = new User("333-3456","222222");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
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
                "4.List of movie\n" +
                "5.checkout a movie\n" +
                "6.login\n" +
                "7.List of users who checked out books";
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
        }else if (val==5){
            chooseCheckoutMovie();
            return true;
        }else if (val==6){
            chooseLogin();
            return true;
        }else if (val==7){
            chooseShowUsersWhoCheckoutBooks();
            return true;
        }else {
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
        if (!islogin()){
            System.out.println("Please login first!");
            return;
        }
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
        if (!islogin()){
            System.out.println("Please login first!");
            return;
        }
        System.out.println("input book's name:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        System.out.println(returnBook(bookName));
    }

    public String showMovieList() {
        StringBuilder moviesInfo = new StringBuilder();
        String delimiter = "|";
        for (Movie movie : movieList) {
            String movieInfo = movie.getMovieName()+delimiter+movie.getYear()+delimiter+movie.getDirector()+delimiter+movie.getMovieRating()+"\n";
            moviesInfo.append(movieInfo);
        }
        return moviesInfo.toString();
    }

    public String checkoutMovie(String movieName) {
        for (Movie movie : movieList) {
            if (movie.getMovieName().equals(movieName)&&movie.getAvailable()==true){
                movie.setAvailable(false);
                return "Thank you!Enjoy the movie";
            }
        }
        return "Sorry,that movie is not available";
    }

    public void chooseCheckoutMovie(){
        System.out.println("input movie's name:");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        System.out.println(checkoutMovie(movieName));
    }

    public void login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
                currentUser = user;
                break;
            }
        }
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public Boolean islogin() {
        return currentUser!=null;
    }

    public void chooseLogin(){
        System.out.println("input library number:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("input your password:");
        String password = scanner.nextLine();
        login(username,password);
        if (islogin()){
            System.out.println("Login successfully");
        }else{
            System.out.println("Login failed");
        }
    }

    public String showUsersWhoCheckoutBooks() {
        StringBuilder usernameList = new StringBuilder();
        for (User user : userList) {
            if (user.getBookList().size()!=0) {
                usernameList.append(user.getUsername());
            }
        }
        return usernameList.toString();
    }

    public void chooseShowUsersWhoCheckoutBooks(){
        System.out.println(showUsersWhoCheckoutBooks());
    }
}
