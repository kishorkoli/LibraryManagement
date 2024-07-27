package com.airtribe.project.service;
import com.airtribe.project.book.Book;
import com.airtribe.project.patron.Patron;

public class BookLendingService {
    private LibraryService libraryService;

    public BookLendingService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public boolean lendBook(String isbn, String patronId) {
        Book book = libraryService.searchByIsbn(isbn).orElse(null);
        Patron patron = libraryService.getPatrons().get(patronId);

        if (book != null && patron != null && libraryService.getBooks().containsKey(isbn)) {
            patron.getBorrowedBooks().add(book);
            libraryService.getBooks().remove(isbn);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, String patronId) {
        Patron patron = libraryService.getPatrons().get(patronId);
        Book book = libraryService.searchByIsbn(isbn).orElse(null);

        if (book != null && patron != null && patron.getBorrowedBooks().remove(book)) {
            libraryService.addBook(book);
            return true;
        }
        return false;
    }
}
