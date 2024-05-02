package com.library.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.ReaderDao;
import com.library.model.Reader;

public class ReaderService {
	ReaderDao rd = new ReaderDao();

	public String addUser(Reader r) {
		if(!r.getConfirmPassword().equals(r.getPassword())) {
			return "Password didnt match";
		}
		return rd.addUser(r);
	}

	public String login(String email, String password, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return rd.login(email,password, req, resp);
	}
}
