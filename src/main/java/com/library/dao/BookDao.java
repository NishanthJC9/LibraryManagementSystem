package com.library.dao;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Library;

public class BookDao {
	String url = "jdbc:mysql://localhost:3306/LIBRARYDB";
	String user = "root";
	String pass = "root";
	Library l;
	public String addBook(Library li) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "INSERT INTO BOOKS(ID,BOOKNAME,AUTHOR) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, li.getBookId());
			ps.setString(2, li.getBookName());
			ps.setString(3, li.getAuthor());
			int res = ps.executeUpdate();
			if(res>0) {
				return "Book Inserted Successfully";
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Insertion failed";
	}

	public Library getBookById(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BOOKS WHERE ID="+id);
			while(rs.next()) {
				int bookId = rs.getInt("ID");
				String name = rs.getString("BOOKNAME");
				String author = rs.getString("AUTHOR");
				String available = rs.getString("AVAILABLE");
				int noOfBooks = rs.getInt("NO_OF_BOOKS");
				this.l = new Library(bookId,name,author,available,noOfBooks);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
	}

	public List<Library> getAllBooks() {
		// TODO Auto-generated method stub
		List<Library> li = new ArrayList<Library>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BOOKS");
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("BOOKNAME");
				String author = rs.getString("AUTHOR");
				String available = rs.getString("AVAILABLE");
				int noOfBooks = rs.getInt("NO_OF_BOOKS");
				li.add(new Library(id,name,author,available,noOfBooks));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	public String updateBook(Library li) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BOOKS WHERE ID="+li.getBookId());
			while(rs.next()) {
				String query = "UPDATE BOOKS SET BOOKNAME=?,AUTHOR=?,AVAILABLE=? WHERE ID=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, li.getBookName());
				ps.setString(2, li.getAuthor());
				ps.setString(3, li.getAvailable());
				ps.setInt(4, li.getBookId());
				int res = ps.executeUpdate();
				return "Update Successful";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Update unsuccessfull";
	}

	public String deleteBook(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BOOKS WHERE ID="+id);
			while(rs.next()) {
				String query = "DELETE FROM BOOKS WHERE ID=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,id);
				int r = ps.executeUpdate();
				if(r>0) {
					return "Deletion Successfull";
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Deletion Unsuccessfull";
	}
}
