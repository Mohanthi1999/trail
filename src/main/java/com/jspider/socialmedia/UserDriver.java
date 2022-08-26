package com.jspider.socialmedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDriver {
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306?user=root&&password=abcd&&userSSL=false");

		return con;
	}

	public void insertUser(Users u) throws Exception {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO socialmedia.user(id,name,email,password,mediatype,phonenumber) values(?,?,?,?,?,?)");

		ps.setInt(1, u.getId());
		ps.setString(2, u.getName());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getPassword());
		ps.setString(5, u.getMediaType());
		ps.setString(6, u.getPhoneNumber());
		ps.execute();
		System.out.println("insertion data successfully....");
		ps.close();
		con.close();
	}

	public void updateUser(Users u) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"UPDATE socialmedia.user set name=?,email=?,password=?,mediatype=?,phonenumber=? where id=?");
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getMediaType());
		ps.setString(5, u.getPhoneNumber());
		ps.setInt(6, u.getId());
		ps.executeUpdate();
		System.out.println("updation successfully completed.....");
		con.close();
		ps.close();
	}

	public void deleteUser(int i) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("delete from socialmedia.user where id=?");
		ps.setInt(1, i);
		ps.execute();
		System.out.println("deletion successfully....");
		con.close();
		ps.close();
	}

	public void getUser(int i) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from socialmedia.user where id=?");
		ps.setInt(1, i);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("your details is :");
			System.out.println("id is       :" + rs.getInt(1));
			System.out.println("name is     :" + rs.getString(2));
			System.out.println("email is    :" + rs.getString(3));
			System.out.println("password is :" + rs.getString(4));
			System.out.println("phone is    :" + rs.getString(5));
		}
		ps.close();
		con.close();
	}

	public void fetchData(Users u) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from socialmedia.user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("id is       :" + rs.getInt(1));
			System.out.println("name is     :" + rs.getString(2));
			System.out.println("email is    :" + rs.getString(3));
			System.out.println("password is :" + rs.getString(4));
			System.out.println("phone is    :" + rs.getString(5));
			System.out.println("...............................");
		}

	}

	public void login(int id, String email, String password) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from socialmedia.user where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			try {
				if (rs.getString(3).equals(email) && rs.getString(4).equals(password)) {

					System.out.println("id is       :" + rs.getInt(1));
					System.out.println("name is     :" + rs.getString(2));
					System.out.println("email is    :" + rs.getString(3));
					System.out.println("password is :" + rs.getString(4));
					System.out.println("phone is    :" + rs.getString(5));
					System.out.println("...............................");

				} else {
					throw new UserNotFoundException();
				}
			} catch (UserNotFoundException e) {
				System.out.println("check email and password");
			}
		}
		ps.close();
		con.close();
	}
}
