package ie.gmit.sw;

import java.sql.*;

public class ListCars {					
	
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