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
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest dreq, HttpServletResponse dres) throws ServletException, IOException {
		int id = Integer.parseInt(dreq.getParameter("bookId"));
		BookService bs = new BookService();
		String s  =bs.deleteBook(id);
		System.out.println(s);
		PrintWriter pw = dres.getWriter();
		pw.println(s);
	}
}
