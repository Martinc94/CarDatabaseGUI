package ie.gmit.sw;

import java.sql.*;

public class ListCars {				
									
	public void list(){
		Driver d = new Driver();
		
		Connection conn;
		try {
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
		
			String qry = "select * from car";
			ResultSet myResultSet = stmt.executeQuery(qry);
							
			while(myResultSet.next()){
				System.out.println(myResultSet.getString("make")+" "
									+myResultSet.getString("model")+" "
									+myResultSet.getString("reg")+" "
									+myResultSet.getString("colour")+" "
									+myResultSet.getString("price")+" "
									+myResultSet.getString("description"));
			
			}//while
				
			
		} catch (SQLException e) {
			//cannot connect to database
		}
		
	}//end list
	
	public ResultSet getAllCars() throws SQLException{
		Driver d = new Driver();
		Connection conn;
		
		conn = d.getConn();
		Statement stmt = conn.createStatement();
	
		String qry = "select * from car";
		ResultSet myResultSet = stmt.executeQuery(qry);
			
		return myResultSet;
			
	}//end getAllCars

}//end listCar