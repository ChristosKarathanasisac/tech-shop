package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

public class CustomerBean implements Serializable {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String address;
	private HashMap<String, Integer> shoppingCart = new HashMap<String, Integer>();
	
	public void addProductToShoppingCart(String product) 
	{
		if(this.shoppingCart.containsKey(product)) 
		{
			this.shoppingCart.replace(product, this.shoppingCart.get(product)+1);
		}else 
		{
			this.shoppingCart.put(product, 1);
		}
	}
	public void removeProductFromShoppingCart(String product) 
	{
			this.shoppingCart.remove(product);
	}
	public double calculateTotal(List<ProductBean> products)
	{
		double total=0;
		for(ProductBean p:products) 
		{
			String id = String.valueOf(p.getId());
			int quantityOfProduct = 0;
			if(this.getShoppingCart().get(id)!=null)
			{
				quantityOfProduct = (Integer)this.getShoppingCart().get(id);
			}
			if(quantityOfProduct == 0){continue;}
			total+=quantityOfProduct*p.getPrice();
		}
		return total;
	}
	
	public void removeQuantityFromProduct(String product) 
	{
		if(this.shoppingCart.containsKey(product)) 
		{
			this.shoppingCart.replace(product, this.shoppingCart.get(product)-1);
		}
		if(this.shoppingCart.get(product)==0) 
		{
			removeProductFromShoppingCart(product);
		}
	}
	
	public HashMap<String, Integer> getShoppingCart() {
		return shoppingCart;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static CustomerBean createCustomer(HttpServletRequest request) 
	{
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String address = request.getParameter("address");
		String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        String email = request.getParameter("email");
        
        CustomerBean customer = new  CustomerBean();
        
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setAddress(address);
        customer.setUsername( username);
        customer.setPassword( DigestUtils.sha256Hex(password));
        customer.setEmail(email);
        
        return customer;
	}

}
