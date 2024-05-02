package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.library.model.Library;

public class NewBookDao extends BookDao {
	@Override
	public String addBook(Library li) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BOOKS WHERE BOOKNAME=? AND AUTHOR=?");
			ps.setString(1, li.getBookName());
			ps.setString(2, li.getAuthor());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next() == false) {
				String newQuery = "INSERT INTO BOOKS(ID,BOOKNAME,AUTHOR,AVAILABLE,NO_OF_BOOKS) VALUES(?,?,?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(newQuery);
				ps2.setInt(1, li.getBookId());
				ps2.setString(2, li.getBookName());
				ps2.setString(3, li.getAuthor());
				ps2.setString(4, "Yes");
				ps2.setInt(5, 1);
				int res = ps2.executeUpdate();
				if (res > 0) {
					return "Insertion Successfull";
				}
			} else {
				int noOfBooks = rs.getInt("NO_OF_BOOKS");
				noOfBooks += 1;
				String query = "UPDATE BOOKS SET NO_OF_BOOKS=?, AVAILABLE=? WHERE BOOKNAME=? AND AUTHOR=?";
				PreparedStatement ps1 = con.prepareStatement(query);
				ps1.setInt(1, noOfBooks);
				ps1.setString(2, "Yes");
				ps1.setString(3, li.getBookName());
				ps1.setString(4, li.getAuthor());
				int res = ps1.executeUpdate();
				if (res > 0) {
					return "Insertion successfull";
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Unsuccessfull";
	}
	
	public String issueBook(String bookName, String authorName) {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement ps = con.prepareStatement("SELECT * FROM BOOKS WHERE BOOKNAME=? AND AUTHOR=?");
				ps.setString(1, bookName);
				ps.setString(2, authorName);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					int noOfBooks = rs.getInt("NO_OF_BOOKS");
					if(noOfBooks>0) {
						noOfBooks-=1;
						if(noOfBooks==0) {
							String query = "UPDATE BOOKS SET AVAILABLE=? WHERE BOOKNAME=? AND AUTHOR=?";
							PreparedStatement ps1 = con.prepareStatement(query);
							ps1.setString(1, "No");
							ps1.setString(2, bookName);
							ps1.setString(3, authorName);
							int r = ps1.executeUpdate();
						}
						String query = "UPDATE BOOKS SET NO_OF_BOOKS=? WHERE BOOKNAME=? AND AUTHOR=?";
						PreparedStatement ps1 = con.prepareStatement(query);
						ps1.setInt(1, noOfBooks);
						ps1.setString(2, bookName);
						ps1.setString(3, authorName);
						int res = ps1.executeUpdate();
						if (res > 0) {
							return "Issue successfull";
						}
					}
					else {
						return "The book is not available for a while";
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "No Book Found";
	}
}
