package ie.gmit.sw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchCar {
	
	public ResultSet searchMake(String make){
		Driver d = new Driver();
		ResultSet myResultSet = null;
		
		
		Connection conn;
		try {
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
		
			String qry = "select * from car where make like '%"+make+"%'";

			myResultSet = stmt.executeQuery(qry);

		} catch (SQLException e) {
			System.out.println("Error Getting Results set");
			//e.printStackTrace();
		}
		return myResultSet;
	
	
	}//end searchMake

	public ResultSet searchModel(String model) {
		Driver d = new Driver();
		ResultSet myResultSet = null;
		
		
		Connection conn;
		try {
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
		
			String qry = "select * from car where model like '%"+model+"%'";

			myResultSet = stmt.executeQuery(qry);	

		} catch (SQLException e) {
			System.out.println("Error Getting Results set");
		}
		return myResultSet;
	}//end searchModel
	
	public ResultSet searchReg(String reg) {
		Driver d = new Driver();
		ResultSet myResultSet = null;
		
		
		Connection conn;
		try {
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
	
			String qry = "select * from car where reg like '%"+reg+"%'";

			myResultSet = stmt.executeQuery(qry);

		} catch (SQLException e) {
			System.out.println("Error Getting Results set");	
		}
		return myResultSet;
	}//end searchReg
	
	public ResultSet searchExactReg(String reg) {
		Driver d = new Driver();
		ResultSet myResultSet = null;
		
		
		Connection conn;
		try {
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
	
			String qry = "select * from car where reg = '"+reg+"'";

			myResultSet = stmt.executeQuery(qry);

		} catch (SQLException e) {
			System.out.println("Error Getting Results set");	
		}
		return myResultSet;
	}//end searchReg
}
