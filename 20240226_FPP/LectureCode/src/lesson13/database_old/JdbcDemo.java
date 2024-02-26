package lesson13.database_old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	//queries
	String TEST_INSERT = "INSERT INTO test "+
						"(id,name,income) "+       	
						"VALUES('131','Joe',70000)"; 

	String TEST_UPDATE = "UPDATE test "+
						 "SET income = income * 1.10 "+
						 "WHERE id = '131'";

	
	String TEST_READ = "SELECT * FROM test WHERE id='131'";
	
	//
	
	
	Connection con;
	Statement stmt;
	String dburl = "jdbc:odbc:FPP0906-Sample";
	String insertStmt = "";
	String selectStmt = "";
	public static void main(String[] args) {
		JdbcDemo demo = new JdbcDemo();
		demo.insertExample();
		demo.readExample();
		demo.updateExample();
		demo.readExample();
		demo.closeConnection();
	}
	public JdbcDemo() {
		//load driver just once
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException e){
			//debug
			e.printStackTrace();
		}
		//keep connection open throughout demo
		try{
			con = DriverManager.getConnection(dburl, "", "");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	void closeConnection() {
		try {
			if(con !=null)
				con.close();
		}
		catch(SQLException ex) {
			System.out.println("Unable to close connection");
			ex.printStackTrace();
		}
		
	}
	void insertExample(){
		try {
			stmt = con.createStatement();
			
			System.out.println("insert query "+TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
			
	}
	
	
	void readExample(){
		
		
		try {
			stmt = con.createStatement();
			System.out.println("the query: "+TEST_READ);
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				double income = rs.getDouble("income");
				System.out.println("id: "+ id + " name: "+name+" income: "+income);
			}
			else {
				System.out.println("No records found");
			}
			stmt.close();
			
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		
		
		
		
	}
	void updateExample(){
		try {
			stmt = con.createStatement();
			
			System.out.println("update query "+TEST_UPDATE);
			stmt.executeUpdate(TEST_UPDATE);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
					
		
	}
}
