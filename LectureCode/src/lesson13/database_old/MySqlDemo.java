package lesson13.database_old;

public class MySqlDemo {
 /*
  * 
  * Connection con = null;
        	Statement stmt = null;
        	String dburl = "jdbc:mysql:///ProductsDb";
        	String insertStmt = "";
        	String selectStmt = "";
        	
        	
    		try {
    			Class.forName("org.gjt.mm.mysql.Driver");
    		}
    		catch(ClassNotFoundException e){
    			//debug
    			e.printStackTrace();
    		}
    		try{
    			con = DriverManager.getConnection(dburl, "root", "");
    		}
    		catch(SQLException e){
    			System.out.println(e.getMessage());
    			e.printStackTrace();
    		}
    		try {
    			stmt = con.createStatement();
    			ResultSet rs = stmt.executeQuery("SELECT * FROM CatalogType");
    			while(rs.next()){
    				String id = rs.getString("catalogid");
    				String name = rs.getString("catalogname");
    				System.out.println("id: "+ id + " name: "+name);
    				theData.add(new String[]{name});
    			}
    			stmt.close();
    			con.close();
    		}
    		catch(SQLException s){
    			s.printStackTrace();
    		}

  */
}
