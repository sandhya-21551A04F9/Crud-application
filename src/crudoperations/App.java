package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
	
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	
	public static final String Username = "root";
	
	public static final String Password = "root";
	
	public static final String Url = "";
	
	public static Connection conn;
	
	public static PreparedStatement pmst;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			int ch;
			
			do {
			
			display();
			
			System.out.println("Enter your choice");
		
			ch = Integer.parseInt(sc.next());
			
			switch (ch) {
			
			case 1: createdatabase();
			
					break;

			case 2: dropdatabase();
			
					break;

			case 3: createtable();
			
					break;

			case 4: droptable();
			
					break;

			case 5: insertion();
			
					break;
					
			case 6: update();
			
					break;

			case 7: delete();
			
					break;

			case 8: getall();
			
					break;

			case 9: getby();
			
					break;

			case 10: System.exit(ch);
			
			default: 
			
				System.out.println("Invalid Operation");
			}
			
		} while (ch > 0);
			
	}

	private static void getby() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter database name:");
		
		String Url = "jdbc:mysql://localhost:3306/" +sc.next();
		
		try {
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="select * from " + sc.next() + " where email = ?";
			
			pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter email: ");

			pmst.setString(1, sc.next());
			
			ResultSet rs = pmst.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("**********");
				
				System.out.println("id : " + rs.getInt("id"));
				
				System.out.println("name : " + rs.getString("name"));
				
				System.out.println("email : " + rs.getString("email"));
				
				System.out.println("**********");
			}
			
		} catch (Exception e) {
			
			 e.printStackTrace();
		 
		}
	
	}

	private static void getall() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter database name:");
		
		String Url = "jdbc:mysql://localhost:3306/" +sc.next();
		
		try {
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="select * from " + sc.next();
			
			pmst = conn.prepareStatement(sql);
			
			ResultSet rs = pmst.executeQuery();
			
			while(rs.next()) {
				System.out.println("**********");
				
				System.out.println("id : " + rs.getInt("id"));
				
				System.out.println("name : " + rs.getString("name"));
				
				System.out.println("email : " + rs.getString("email"));
				
				System.out.println("**********");
			}
			
	
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

	private static void delete() {


		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter database name:");
			
			String Url = "jdbc:mysql://localhost:3306/" +sc.next();
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="delete from " + sc.next()+ " where id = ?";
			
			pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter id");
			
			pmst.setInt(1, sc.nextInt());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("Deleted data succesfully");
				
			} else {
				System.out.println("error");

			}
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
		
	}

	private static void update() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter database name:");
			
			String Url = "jdbc:mysql://localhost:3306/" +sc.next();
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="update " + sc.next() +" set name = ?, email = ? where id = ?";
			
			pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter name");
			
			pmst.setString(1, sc.next());
			
			System.out.println("Enter email");
			
			pmst.setString(2, sc.next());
			
			System.out.println("Enter id");
			
			pmst.setInt(3, sc.nextInt());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				System.out.println("Data updated succesfully");
				
			} else {
				System.out.println("error");

			}
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

	private static void insertion() {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter database name:");
			
			String Url = "jdbc:mysql://localhost:3306/" +sc.next();
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="insert into " + sc.next()+"(id,name,email)values(?,?,?)";
			
			pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter id");
			
			pmst.setInt(1, sc.nextInt());
			
			System.out.println("Enter name");
			
			pmst.setString(2, sc.next());
			
			System.out.println("Enter email");
			
			pmst.setString(3, sc.next());
			
			int i = pmst.executeUpdate();
			
			if (i>0) {
				
				System.out.println("Data inserted succesfully");
				
			} else {
				System.out.println("error");

			}
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	
	}

	private static void droptable() {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter database name:");
			
			String Url = "jdbc:mysql://localhost:3306/" +sc.next();
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="drop table " + sc.next();
			
			pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("Table deleted succesfully");
				
			} else {
				System.out.println("error");

			}
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
	}
	
	private static void createtable() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter database name:");
			
			String Url = "jdbc:mysql://localhost:3306/" +sc.next();
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter table name:");
			
			String sql ="create table " + sc.next()+"(id int,name varchar(20),email varchar(20))";
			
			pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i==0) {
				System.out.println("Table created succesfully");
				
			} else {
				System.out.println("error");

			}
			
		} catch (Exception e) {
		 e.printStackTrace();
		 
		}
		
	}

	private static void dropdatabase() {
	
		Scanner sc = new Scanner(System.in);
		
		String Url = "jdbc:mysql://localhost:3306/";
		
		try {
			
			Class.forName(Driver);
 			
			Connection conn = DriverManager.getConnection( Url, Username, Password);
			
			System.out.println("Enter database name:");
			
			String sql ="drop database " + sc.next();
			
			pmst = conn.prepareStatement(sql);
			
			int i = pmst.executeUpdate();
			
			if (i == 0) {
				
				System.out.println("Database deleted succesfully");
				
			} else {
				System.out.println("error");

			}
			
		} catch (Exception e) {
			
		 e.printStackTrace();
		 
		}
	}

	private static void createdatabase() {
		

		String Url = "jdbc:mysql://localhost:3306/";

		Scanner sc = new Scanner(System.in);

		try {

			Class.forName(Driver);

			Connection conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter database name");

			String sql = "create database " + sc.next();

			pmst = conn.prepareStatement(sql);

			int i = pmst.executeUpdate();

			if (i > 0) {

				System.out.println("Database created successfully");
			} else {

				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void display() {
		
		System.out.println("*****************");

		System.out.println("\t1. Create Database");

		System.out.println("\t2. Drop Database");

		System.out.println("\t3. Create table");

		System.out.println("\t4. Drop table");

		System.out.println("\t5. Insert data");

		System.out.println("\t6. Update data");

		System.out.println("\t7. Delete data");

		System.out.println("\t8. Getall");

		System.out.println("\t9. Getby email");

		System.out.println("\t10. Exit");

		System.out.println("*****************");

	}


}
