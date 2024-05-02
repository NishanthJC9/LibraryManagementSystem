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
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest ureq, HttpServletResponse ures) throws ServletException, IOException {
		int id = Integer.parseInt(ureq.getParameter("bookId"));
		String name = ureq.getParameter("bookName");
		String author = ureq.getParameter("author");
		PrintWriter pw = ures.getWriter();
		pw.println("Book-Id : "+id+" Book-Name : "+name+" Author : "+author);
		Library li = new Library(id, name, author);
		BookService bs = new BookService();
		String s = bs.updateBook(li);
		System.out.println(s);
		pw.println(s);
	}

}
