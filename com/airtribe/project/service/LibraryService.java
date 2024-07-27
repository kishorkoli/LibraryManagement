package com.airtribe.project.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.airtribe.project.book.Book;
import com.airtribe.project.patron.Patron;

public class LibraryService {
    private Map<String, Book> books;
    private Map<String, Patron> patrons;

    public LibraryService() {
        books = new HashMap<>();
        patrons = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void updateBook(String isbn, Book updatedBook) {
        if (books.containsKey(isbn)) {
            books.put(isbn, updatedBook);
        }
    }

    public Optional<Book> searchByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public Optional<Book> searchByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public Optional<Book> searchByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .findFirst();
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void updatePatron(String id, Patron updatedPatron) {
        if (patrons.containsKey(id)) {
            patrons.put(id, updatedPatron);
        }
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, Patron> getPatrons() {
        return patrons;
    }
}
