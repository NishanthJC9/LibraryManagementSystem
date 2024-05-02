package com.library.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.model.Reader;

public class ReaderDao {
	String url = "jdbc:mysql://localhost:3306/LIBRARYDB";
	String user = "root";
	String pass = "root";

	public String addUser(Reader r) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO READERS(READERNAME,EMAIL,MOBILENUMBER,PASSWORD) VALUES(?,?,?,?)");
			ps.setString(1, r.getReaderName());
			ps.setString(2, r.getEmail());
			ps.setLong(3, r.getMobileNumber());
			ps.setString(4, r.getPassword());
			int res = ps.executeUpdate();
			if (res > 0) {
				return "Reader Added Successfully";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "unsuccessfull";
	}

	public String login(String email, String password, HttpServletRequest request, HttpServletResponse response) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM READERS WHERE EMAIL=? AND PASSWORD =?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("Email", email);
				response.sendRedirect("Library.jsp");
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("Invalid username or password. Please try again.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login Successfull";
	}

}
