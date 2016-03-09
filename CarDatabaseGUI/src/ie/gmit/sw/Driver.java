package ie.gmit.sw;

import java.io.File;
import java.sql.*;

public class Driver {
	
	  public static int id;
	  public static String reg;
	  public static String make;
	  public static String model;
	  public static String colour;
	  public static Double price;
	  public static String description;
	  public static File picture;
	
	public static void main(String[] args) {
	
		try {
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb","root","");
			Connection conn = DriverManager.getConnection("jdbc:mysql://CarDatabase.cloudapp.net:3306/cardb","Martin","Martin");
		
			Statement stmt = conn.createStatement();
				
//Select///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				
				String qry = "select * from car";
				ResultSet myResultSet = stmt.executeQuery(qry);
				
				while(myResultSet.next()){
					System.out.println(myResultSet.getString("make")+" "
							+myResultSet.getString("model")+" "
							+myResultSet.getString("reg")+" "
							+myResultSet.getString("colour")+" "
							+myResultSet.getString("price")+" "
							+myResultSet.getString("description"));
				}
				
				insert2();
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
			
			} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("Error connecting to Database");
		}	
	
	}//end Main
	
	private static void insert(){
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb","root","");
			Statement stmt = conn.createStatement();
			
			//Insert///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
					String sql = "Insert into car (id,reg,make,model,colour,price,description,picture) "
							+ "values ('0','09-C-642877','Nissan','Micra','Green','6000.00','Mint condition, One owner from new',NULL)";
							stmt.executeUpdate(sql);
							System.out.println("Insert complete.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		}
	
	private static void deleteById(){
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb","root","");
			Statement stmt = conn.createStatement();
			
			//Insert///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
					String sql = "Delete from car where id = 5";
							stmt.executeUpdate(sql);
							System.out.println("Delete complete.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		}
	
	Connection getConn() throws SQLException{
		Connection conn;
		
		conn = DriverManager.getConnection("jdbc:mysql://CarDatabase.cloudapp.net:3306/cardb","Martin","Martin");
		
		return conn;	
			
		}
	
	private static void insert2(){
		id = 0;
		reg = "12-D-654";
		make = "Toyota";
		model = "Civic";
		colour = "red";
		price = 17000.0;
		description = "Like New";
		picture = null;
	
		
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://CarDatabase.cloudapp.net:3306/cardb","Martin","Martin");
			Statement stmt = conn.createStatement();
			
			//Insert///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
					//String sql2 = "Insert into car (id,reg,make,model,colour,price,description,picture) "
					//		+ "values ('0','09-C-642877','Nissan','Micra','Green','6000.00','Mint condition, One owner from new',NULL)";
					//System.out.println(sql2);
					
					String sql = "Insert into car (id,reg,make,model,colour,price,description,picture) "+						
							"values ('"+id+ "','"+ reg+"','"+ make+"','"+ model+"','"+ colour+"','"+ price+"','"+ description+"',"+ picture+")";
							System.out.println(sql);
							stmt.executeUpdate(sql);
							System.out.println("Insert complete.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		}
	
	
}
