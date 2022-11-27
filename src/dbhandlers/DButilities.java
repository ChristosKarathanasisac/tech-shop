package dbhandlers;

import java.sql.*;

import beans.RegistartionBean;


public  class DButilities {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/tech-shop";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";
	
	private  boolean loadDriver() {
		try {
			Class.forName(DB_DRIVER);
			return true;
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("problem in loadDriver");
			return false;
		}
	}
	private Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USERNAME , DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return con;
	}

	public  Boolean insertCustomerToDB(RegistartionBean rb) 
     {
		Connection con =null;
		if(loadDriver()) 
		{
		   con =getConnection();
		}else 
		{
			return false;
		}
		
		String sql = "INSERT INTO customer (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ADDRESS)\r\n" + 
					 "VALUES (?, ?, ?, ?, ?, ?);";	
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, rb.getUsername());
			ps.setString(2, rb.getPassword());
			ps.setString(3, rb.getFirstName());
			ps.setString(4, rb.getLastName());
			ps.setString(5, rb.getEmail());
			ps.setString(6, rb.getAddress());
			ps.executeUpdate();
			con.close();
			return true;

		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
}
	public Boolean checkIfUsnameUsed(String username) 
	{
		Connection con =null;
		if(loadDriver()) 
		{
		   con =getConnection();
		}
		try {
			 PreparedStatement preparedStatement = con
			            .prepareStatement("SELECT * FROM customer where USERNAME = ?"); {
			            preparedStatement.setString(1, username);
			            ResultSet rs = preparedStatement.executeQuery();
			            while (rs.next()) {
			            	return true;
			            	 
			            }
			            return false;
			            }} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
					
	}
}
