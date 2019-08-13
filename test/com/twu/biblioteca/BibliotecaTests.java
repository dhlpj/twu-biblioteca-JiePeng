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
    public void should_return_book_list() {
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
        String expected = "1.List of books";
        String result = biblioteca.showMenuOptions();
        assertThat(result,is(expected));
    }

    @Test
    public void should_return_invalid_message_when_chose_an_invalid_option() {
        Biblioteca biblioteca = new Biblioteca();
        String expected = "Please select a valid option";
        String result = biblioteca.checkOption("asdfs");
        assertThat(result,is(expected));
    }
}
