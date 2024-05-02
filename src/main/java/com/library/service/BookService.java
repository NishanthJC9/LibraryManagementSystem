package com.library.service;
import com.library.model.*;

import java.util.List;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import com.library.dao.*;
import com.library.exception.InvalidIdException;
import com.library.exception.InvalidInputNameException;

public class BookService {
	
	BookDao bd = new BookDao();
	NewBookDao nb = new NewBookDao();
	public String addBook(Library add) {
		try {
			if(add.getBookId()<1) {
				throw new InvalidIdException("Id should be greater than 0");
			}
		}
		catch(InvalidIdException e) {
			return e.getMessage();
		}
		try {
			if(add.getAuthor().trim().isEmpty() ||add.getBookName().trim().isEmpty()) {
				throw new InvalidInputNameException("BookName or Author Name Should Not be empty");
			}
		}catch(InvalidInputNameException e){
			return e.getMessage();
		}
		return nb.addBook(add);
	}

	public Library getBookById(int id) {
		try {
			if(id<1) {
				throw new InvalidIdException("Id should be greater than 0");
			}
		}
		catch(InvalidIdException e) {
			System.out.println("Id should be greater than 0");
		}
		return bd.getBookById(id);
	}

	public List<Library> getAllBooks() {
		// TODO Auto-generated method stub
		return bd.getAllBooks();
	}
	
	public String updateBook(Library li) {
		try {
			if(li.getBookId()<1) {
				throw new InvalidIdException("Id should be greater than 0");
			}
		}
		catch(InvalidIdException e) {
			return e.getMessage();
		}
		return bd.updateBook(li);
	}
	
	public String deleteBook(int id) {
		try {
			if(id<1) {
				throw new InvalidIdException("Id should be greater than 0");
			}
		}
		catch(InvalidIdException e) {
			return e.getMessage();
		}
		return bd.deleteBook(id);
	}

	public String issueBook(String bookName, String author) {
		return nb.issueBook(bookName, author);	
	}
}
