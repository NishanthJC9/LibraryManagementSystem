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
 * Servlet implementation class GetBookById
 */
@WebServlet("/GetBookById")
public class GetBookById extends HttpServlet {
	@Override
	protected void service(HttpServletRequest greq, HttpServletResponse gres) throws ServletException, IOException {
		int id = Integer.parseInt(greq.getParameter("bookId"));
		BookService bs = new BookService();
		Library lis = bs.getBookById(id);
		PrintWriter pw = gres.getWriter();
		pw.println(lis);
		System.out.println(lis);
	}

}
