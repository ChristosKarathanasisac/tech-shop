package dbhandlers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

import beans.CustomerBean;
import beans.ProductBean;


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
			e.printStackTrace();
			return false;
		}
	}
	private Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USERNAME , DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public  Boolean insertCustomerToDB(CustomerBean rb) 
     {
		Connection con =null;
		if(loadDriver()) 
		{
		   con =getConnection();
		}else 
		{
			return false;
		}
		
		String sql = "INSERT INTO CUSTOMERS (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ADDRESS)\r\n" + 
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
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
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
			            .prepareStatement("SELECT * FROM customers WHERE USERNAME = ?"); {
			            preparedStatement.setString(1, username);
			            ResultSet rs = preparedStatement.executeQuery();
			            while (rs.next()) {
			            	con.close();
			            	return true;
			            	 
			            }
			            return false;
			            }} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			return false;
		}
					
	}
	public CustomerBean getCustomerFromDB(String username,String password)
	{
		CustomerBean customer =null;
		Connection con =null;
		if(loadDriver()) 
		{
		   con =getConnection();
		}
		try {
			 PreparedStatement preparedStatement = con
			            .prepareStatement("SELECT * FROM customers WHERE USERNAME = ? AND PASSWORD =?"); 
			            preparedStatement.setString(1, username);
			            preparedStatement.setString(2, password);
			            ResultSet rs = preparedStatement.executeQuery();
			            while (rs.next()) {
			            	customer  =new CustomerBean();
			            	customer.setFirstName(rs.getString("FIRSTNAME"));
			            	customer.setLastName(rs.getString("LASTNAME"));
			            	customer.setAddress(rs.getString("ADDRESS"));
			            	customer.setEmail(rs.getString("EMAIL"));
			            	customer.setUsername(rs.getString("USERNAME"));
			            }
			            con.close();
			            return customer;
			            } catch (SQLException e) {
			
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		}
					
	}
	public ArrayList<ProductBean> getProductsFromDB(String category)
	{
		ProductBean product =null;
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		Connection con =null;
		if(loadDriver()) 
		{
		   con =getConnection();
		}
		try {
			 PreparedStatement preparedStatement = con
			            .prepareStatement("SELECT * FROM products WHERE CATEGORY =?"); 
			            preparedStatement.setString(1, category);
			            ResultSet rs = preparedStatement.executeQuery();
			            while (rs.next()) {
			            	product  =new ProductBean();
			            	product.setId(rs.getInt("ID"));
			            	product.setName(rs.getString("NAME"));
			            	product.setCategory(rs.getString("CATEGORY"));
			            	product.setBalance(rs.getInt("BALANCE"));
			            	product.setPrice(rs.getDouble("PRICE"));
			            	product.setPhotopath((rs.getString("PHOTOPATH")));
			            	
			            	products.add(product);
			            }
			            con.close();
			            return products;
			            } catch (SQLException e) {
			
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		}
					
	}
	public ArrayList<ProductBean> getProductsFromDB(Set<String> ids)
	{
		{
			ProductBean product =null;
			ArrayList<ProductBean> products = new ArrayList<ProductBean>();
			Connection con =null;
			if(loadDriver()) 
			{
			   con =getConnection();
			}
			try {
				String idsForSQL="";
				int counter = 1;
				if(ids.size()==0) {return products;}
				for(String s:ids) 
				{
					if(counter == ids.size()) 
					{
						idsForSQL=idsForSQL+s;
					}else 
					{
						idsForSQL=idsForSQL+s+",";
						counter++;
					}
				}
				 Statement st = con.createStatement();
				            String query = "SELECT * FROM products WHERE ID IN ("+idsForSQL+")";
				            ResultSet rs = st.executeQuery(query);
				            while (rs.next()) {
				            	product  =new ProductBean();
				            	product.setId(rs.getInt("ID"));
				            	product.setName(rs.getString("NAME"));
				            	product.setCategory(rs.getString("CATEGORY"));
				            	product.setBalance(rs.getInt("BALANCE"));
				            	product.setPrice(rs.getDouble("PRICE"));
				            	product.setPhotopath((rs.getString("PHOTOPATH")));
				            	products.add(product);
				            }
				            con.close();
				            return products;
				            } catch (SQLException e) {
				
				e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					return null;
				}
				return null;
			}
	}
	public ProductBean getProductByID(String id) 
    {
    	ProductBean product =null;
		Connection con =null;
		if(loadDriver()) 
		{
		   con =getConnection();
		}
		try {
			 PreparedStatement preparedStatement = con
			            .prepareStatement("SELECT * FROM products WHERE ID =?"); 
			            preparedStatement.setString(1, id);
			            ResultSet rs = preparedStatement.executeQuery();
			            while (rs.next()) {
			            	product  =new ProductBean();
			            	product.setId(rs.getInt("ID"));
			            	product.setName(rs.getString("NAME"));
			            	product.setCategory(rs.getString("CATEGORY"));
			            	product.setBalance(rs.getInt("BALANCE"));
			            	product.setPrice(rs.getDouble("PRICE"));
			            	product.setPhotopath((rs.getString("PHOTOPATH")));
			            	con.close();
			            	return product;
			            }
			            return product;
			            } catch (SQLException e) {
			
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
    }
}
}