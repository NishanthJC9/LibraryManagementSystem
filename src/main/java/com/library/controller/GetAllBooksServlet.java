package com.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.model.Library;
import com.library.service.BookService;

/**
 * Servlet implementation class GetAllBooksServlet
 */
@WebServlet("/GetAllBooksServlet")
public class GetAllBooksServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest greq, HttpServletResponse gres) throws ServletException, IOException {
		BookService bs = new BookService();
		List<Library> li = bs.getAllBooks();
		greq.setAttribute("bookList", li);
		greq.getRequestDispatcher("BooksResponse.jsp").forward(greq, gres);
	}

}
