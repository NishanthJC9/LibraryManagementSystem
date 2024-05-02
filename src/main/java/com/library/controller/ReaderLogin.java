package com.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.ReaderService;

/**
 * Servlet implementation class ReaderLogin
 */
@WebServlet("/ReaderLogin")
public class ReaderLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("registerEmail");
		String password = req.getParameter("registerPassword");
		
		ReaderService rs = new ReaderService();
		String s = rs.login(email,password,req,resp);
		System.out.println(s);
	}

}
