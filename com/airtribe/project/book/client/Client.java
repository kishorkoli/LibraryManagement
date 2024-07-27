package com.airtribe.project.book.client;

import com.airtribe.project.book.Book;
import com.airtribe.project.patron.Patron;
import com.airtribe.project.service.*;

public class Client {


	public static void main(String[] args) {
		LibraryService libraryService = new LibraryService();
		BookLendingService lendingService = new BookLendingService(libraryService);

		Book book1 = new Book("Mrutyunjay", "Shivaji Sawant", "987654321", 1990);
		Book book2 = new Book("Chhawa", "Shivaji Sawant", "123456789", 1980);
		libraryService.addBook(book1);
		libraryService.addBook(book2);

		Patron patron1 = new Patron("Kishor", "Koli");
		libraryService.addPatron(patron1);

		boolean checkoutSuccess = lendingService.lendBook("987654321", "Koli");
		System.out.println("Lending successful: " + checkoutSuccess);

		boolean returnSuccess = lendingService.returnBook("123456789", "Koli");
		System.out.println("Return successful: " + returnSuccess);

		System.out.println("Books in library: " + libraryService.getBooks());
		System.out.println("Patrons: " + libraryService.getPatrons());
	}

}
