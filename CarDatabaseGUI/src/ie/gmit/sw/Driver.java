package ie.gmit.sw;

import java.sql.*;

public class Driver {

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
	
}
