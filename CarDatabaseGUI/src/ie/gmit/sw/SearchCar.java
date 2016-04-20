package ie.gmit.sw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Stores SQL statements for searching Database
 */
public class SearchCar {
	//Search database by Make and return result set
	public ResultSet searchMake(String make) throws SQLException{
		Driver d = new Driver();
		ResultSet myResultSet = null;
		Connection conn;
		
		conn = d.getConn();
			
		Statement stmt = conn.createStatement();
		
		String qry = "select * from car where make like '%"+make+"%'";

		myResultSet = stmt.executeQuery(qry);

		return myResultSet;
	}//end searchMake

	//Search database by Model and return result set
	public ResultSet searchModel(String model) throws SQLException {
		Driver d = new Driver();
		ResultSet myResultSet = null;	
		
		Connection conn;
		
			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
		
			String qry = "select * from car where model like '%"+model+"%'";

			myResultSet = stmt.executeQuery(qry);	

		
		return myResultSet;
	}//end searchModel
	
	//Search database by Reg and return result set
	public ResultSet searchReg(String reg) throws SQLException {
		Driver d = new Driver();
		ResultSet myResultSet = null;	
		Connection conn;

			conn = d.getConn();
			
			Statement stmt = conn.createStatement();
	
			String qry = "select * from car where reg like '%"+reg+"%'";

			myResultSet = stmt.executeQuery(qry);

		return myResultSet;
	}//end searchReg
	
	//Search database by exact reg and return result set
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
}//end searchCar