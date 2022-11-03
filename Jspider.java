package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jspider {

	public static void main(String[] args) {
		int id;
		String name;
		String email;
		String phno;
		String branch;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306?user=root&&password=abcd&&userSSL=false");
			Statement st = cn.createStatement();
			int v = 0;
			do {
				Scanner scn = new Scanner(System.in);
				System.out.println("enter id number :");
				id = scn.nextInt();
				System.out.println("enter student name :");
				name = scn.next();
				System.out.println("enter student email :");
				email = scn.next();
				System.out.println("enter student phone number :");
				phno = scn.next();
				System.out.println("enter student branch :");
				branch = scn.next();

				String s = "insert into institute.jspider values(" + id + ",'" + name + "','" + email + "','" + phno
						+ "','" + branch + "')";
				st.execute(s);
				System.out.println("student data inserted successfully");
				System.out.println("press 1 for inserting one more data");
				v = scn.nextInt();
			} while (v == 1);

			st.close();
			cn.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
