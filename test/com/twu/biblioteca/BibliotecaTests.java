package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BibliotecaTests {
    Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void should_return_welcome_message() {
        String result = biblioteca.printWelcomeMsg();
        assertThat(result, is("Welcome to Biblioteca.Your one-stop shop for buying good books in bangalore!"));
    }

    @Test
    public void should_return_book_list_when_some_book_checked_out() {
        String expected = "Java\nJavaScript\nC#\nPHP\nTDD\n";
        String bookNames = biblioteca.showBookNames();
        assertThat(bookNames, is(expected));
    }

    @Test
    public void should_return_book_list_with_more_info() {
        String expected = "Java|Tina|2019\nJavaScript|Bob|2018\nC#|Mary|2016\nPHP|XiaoMing|2017\n";
        String booksAllInfo = biblioteca.showBooksAllInfo();
        assertThat(booksAllInfo, is(expected));
    }

    @Test
    public void should_return_menu_options() {
        String expected = "0.Quit\n" +
                "1.List of book\n" +
                "2.checkout a book\n" +
                "3.return a book\n" +
                "4.List of movie\n" +
                "5.checkout a movie\n" +
                "6.login";
        String result = biblioteca.showMenuOptions();
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_invalid_message_when_chose_an_invalid_option() {
        boolean result = biblioteca.checkOption("sdaf");
        assertThat(result, is(false));
    }

    @Test
    public void should_return_success_message_when_checkout_available_book() {
        String expected = "Thank you!Enjoy the book";
        String result = biblioteca.checkoutBook("Java");
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_unsuccess_message_when_checkout_not_available_book() {
        String expected = "Sorry,that book is not available";
        String result = biblioteca.checkoutBook("TDD");
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_success_message_when_return_book_successful() {
        String expected = "Thank you for returning the book";
        String result = biblioteca.returnBook("TDD");
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_unsuccess_message_when_return_book_unsuccessful() {
        String expected = "That is not a valid book to return";
        String result = biblioteca.returnBook("Jasdf");
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_movie_list() {
        String expected = "Avengers: Endgame|2019|Anthony Russo|8.6\n" +
                "The Lion King|2019|Jon Favreau|7.1\n" +
                "Fast & Furious Presents: Hobbs & Shaw|2019|David Leitch|6.9\n" +
                "Spider-Man: Far From Home|2019|Jon Watts|7.9\n" +
                "Crawl|2019| Alexandre Aja|6.6\n";
        String result = biblioteca.showMovieList();
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_success_message_when_checkout_available_movie() {
        String expected = "Thank you!Enjoy the movie";
        String result = biblioteca.checkoutMovie("Avengers: Endgame");
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_unsuccess_message_when_checkout_not_available_movie() {
        String expected = "Sorry,that movie is not available";
        String result = biblioteca.checkoutMovie("Fast & Furious Presents: Hobbs & Shaw");
        assertThat(result, is(expected));
    }

    @Test
    public void should_customer_login_when_input_correct_username_and_password() {
        String username = "111-1234";
        String password = "123456";
        biblioteca.login(username,password);
        assertThat(biblioteca.getCurrentUser().getUsername(), is(username));
        assertThat(biblioteca.getCurrentUser().getPassword(), is(password));
    }

    @Test
    public void should_return_true_when_customer_has_login() {
        String username = "111-1234";
        String password = "123456";
        biblioteca.login(username,password);
        assertThat(biblioteca.islogin(), is(true));
    }
}
