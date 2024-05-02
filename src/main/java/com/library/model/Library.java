package com.library.model;

public class Library {
	private int bookId;
	private String bookName;
	private String author;
	private String available;
	private int noOfBooks;
	
	public Library(int bookId, String bookName, String author, String available,int noOfBooks) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.available = available;
		this.noOfBooks = noOfBooks;
	}
	
	public Library(int bookId, String bookName, String author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}
	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", available="
				+ available + ", noOfBooks=" + noOfBooks + "]";
	}
	
}
