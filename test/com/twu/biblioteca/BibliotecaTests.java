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
}
