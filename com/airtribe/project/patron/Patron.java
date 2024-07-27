package com.airtribe.project.patron;

import java.util.HashSet;
import java.util.Set;

import com.airtribe.project.book.Book;

public class Patron {
    private String name;
    private String id;
    private Set<Book> borrowedBooks;

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new HashSet<>();
    }
    
    public Set<Book> getBorrowedBooks() { return borrowedBooks; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBorrowedBooks(Set<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

    
  
}
