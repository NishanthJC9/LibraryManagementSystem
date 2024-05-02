package com.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.BookService;

/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String bookName = req.getParameter("bookName");
		String author = req.getParameter("author");
		
		BookService bs = new BookService();
		
		String s = bs.issueBook(bookName,author);
		System.out.println(s);
		PrintWriter pw = res.getWriter();
		pw.println(s);
	}

}
