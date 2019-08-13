package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BibliotecaTests {
    @Test
    public void should_return_welcome_message() {
        Biblioteca biblioteca = new Biblioteca();
        String result = biblioteca.printWelcomeMsg();
        assertThat(result,is("Welcome to Biblioteca.Your one-stop shop for buying good books in bangalore!"));
    }

    @Test
    public void should_return_book_list_when_some_book_checked_out() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "Java\nJavaScript\nC#\nPHP\n";
        String bookNames = biblioteca.showBookNames();
        assertThat(bookNames,is(expected));
    }

    @Test
    public void should_return_book_list_with_more_info() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "Java|Tina|2019\nJavaScript|Bob|2018\nC#|Mary|2016\nPHP|XiaoMing|2017\n";
        String booksAllInfo = biblioteca.showBooksAllInfo();
        assertThat(booksAllInfo,is(expected));
    }

    @Test
    public void should_return_menu_options() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "0.Quit\n" +
                "1.List of book\n" +
                "2.checkout a book";
        String result = biblioteca.showMenuOptions();
        assertThat(result,is(expected));
    }

    @Test
    public void should_return_invalid_message_when_chose_an_invalid_option() {
        Biblioteca biblioteca = new Biblioteca();
        boolean result = biblioteca.checkOption("asdfs");
        assertThat(result,is(false));
    }

    @Test
    public void should_return_success_message_when_checkout_available_book() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "Thank you!Enjoy the book";
        String result = biblioteca.checkoutBook("Java");
        assertThat(result,is(expected));
    }

    @Test
    public void should_return_unsuccess_message_when_checkout_not_available_book() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "Sorry,that book is not available";
        String result = biblioteca.checkoutBook("TDD");
        assertThat(result,is(expected));
    }

    @Test
    public void should_return_success_message_when_return_book_successful() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "Thank you for returning the book";
        String result = biblioteca.returnBook("TDD");
        assertThat(result,is(expected));
    }

    @Test
    public void should_return_unsuccess_message_when_return_book_unsuccessful() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "That is not a valid book to return";
        String result = biblioteca.returnBook("Jasdf");
        assertThat(result,is(expected));
    }
}
