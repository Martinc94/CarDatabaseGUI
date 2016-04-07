package ie.gmit.sw;
import java.sql.*;

public class Driver {
	String user="Martin";
	String password="Martin";
	
	//returns a connection to the database
	Connection getConn() throws SQLException{
		Connection conn;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://CarDatabase.cloudapp.net:3306/cardb",user,password);
		} catch (Exception e) {
			System.out.println("Error connecting to Azure Trying to connect to Localhost");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb","root","");
		}
		
		
		return conn;	
			
	}

}
