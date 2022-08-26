package com.jspider.socialmedia;

import java.util.Scanner;



public class UserChose {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		UserDriver driver = new UserDriver();
		boolean exit = true;
		while (exit) {
			System.out.println("press 1 for insert the data :");
			System.out.println("press 2 for update the data :");
			System.out.println("press 3 for delete the data :");
			System.out.println("press 4 for get particular user data :");
			System.out.println("press 5 for get all data :");
			System.out.println("press 6 for login :");
			System.out.println("press 7 for exit :");
			int choice = scn.nextInt();
			switch (choice) {
			case 1: {
				Users us = new Users();
				System.out.println("enter id number :");
				us.setId(scn.nextInt());
				System.out.println("enter user name :");
				us.setName(scn.next());
				System.out.println("enter email id :");
				us.setEmail(scn.next());
				System.out.println("enter user password :");
				us.setPassword(scn.next());
				System.out.println("enter media type :");
				us.setMediaType(scn.next());
				System.out.println("enter phone number :");
				us.setPhoneNumber(scn.next());
				driver.insertUser(us);
			}
				break;
			case 2: {
				Users us = new Users();
				System.out.println("enter user id :");
				us.setId(scn.nextInt());
				System.out.println("enter user name :");
				us.setName(scn.next());
				System.out.println("enter email id :");
				us.setEmail(scn.next());
				System.out.println("enter user password :");
				us.setPassword(scn.next());
				System.out.println("enter media type :");
				us.setMediaType(scn.next());
				System.out.println("enter phone number :");
				us.setPhoneNumber(scn.next());
				driver.updateUser(us);

			}
				break;
			case 3: {

				System.out.println("enter user id for deleting :");
				driver.deleteUser(scn.nextInt());
			}
				break;
			case 4: {

				System.out.println("enter user id for get data :");
				driver.getUser(scn.nextInt());
			}
				break;
			case 5: {
				Users us = new Users();
				driver.fetchData(us);
			}
				break;
			case 6: {
				Users us = new Users();
				System.out.println("enter user id  :");
				int m = scn.nextInt();
				System.out.println("enter the mail :");
				String s = scn.next();
				System.out.println("enter password :");
				String st = scn.next();
				driver.login(m, s, st);
			}
				break;
			case 7: {
				exit = false;
				System.out.println("exit successfully.........");
			}
				break;
			default: {
				System.out.println("invalid input.......");
				exit = false;
			}
			}
		}

	}

}
