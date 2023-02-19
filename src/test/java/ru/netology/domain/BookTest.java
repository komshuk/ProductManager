package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Alice’s Adventures in Wonderland", 228, "Lewis Carroll");
    private Smartphone smartphone = new Smartphone(3, "8.3", 49_990, "Nokia");

    @Test
    void shouldNotMatchesSearch() {
        boolean actual = book.matches(book, "");
        assertEquals(false, actual);
    }

    @Test
    void smartphoneShouldNotMatchesBook() {
        boolean actual = book.matches(smartphone, "Nokia");
        assertEquals(false, actual);
    }

    @Test
    void shouldMatchesBookByTitle() {
        boolean actual = book.matches(book, "Alice’s Adventures in Wonderland");
        assertEquals(true, actual);
    }

    @Test
    void shouldMatchesBookByAuthor() {
        boolean actual = book.matches(book, "Lewis Carroll");
        assertEquals(true, actual);
    }
}