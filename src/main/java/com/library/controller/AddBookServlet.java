package com.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.model.Library;
import com.library.service.BookService;

/**
 * Servlet implementation class CreateBook
 */
@WebServlet("/CreateBook")
public class AddBookServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest creq, HttpServletResponse cres) throws ServletException, IOException {
		int id = Integer.parseInt(creq.getParameter("bookId"));
		String name = creq.getParameter("bookName");
		String author = creq.getParameter("author");
		
		PrintWriter pw = cres.getWriter();
		pw.println("Book-Id : "+id+" Book-Name : "+name+" Author : "+author);
		
		Library li = new Library(id, name, author);
		BookService bs = new BookService();
		String s = bs.addBook(li);
		System.out.println(s);
		pw.println(s);
	}

}
