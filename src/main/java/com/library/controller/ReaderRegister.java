package com.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.model.Reader;
import com.library.service.ReaderService;

/**
 * Servlet implementation class ReaderRegister
 */
@WebServlet("/ReaderRegister")
public class ReaderRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName= req.getParameter("registerUser");
		String registerEmail = req.getParameter("registerEmail");
		String password = req.getParameter("registerPassword");
		String confirmPassword = req.getParameter("confirm");
		long mobileNumber = Long.parseLong(req.getParameter("registerMobile"));
		
		Reader r = new Reader(userName,registerEmail,mobileNumber,password,confirmPassword);
		ReaderService rs = new ReaderService();
		String a = rs.addUser(r);
		PrintWriter pw = resp.getWriter();
		pw.println(a);
	}

}
