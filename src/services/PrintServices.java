package services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.CustomerBean;
import beans.ProductBean;

public  class PrintServices {
	public static String getLogOutbtn(String path) 
	{
		String forPrint = "<li style=\"float:right;padding-right: 1rem;\">"+"\r\n"+
	            	"<button type=\"button\" style=\"font-size: 1.8rem;background-color: rgb(7, 7, 7);color: white;\">"+
	            		"<a href=\""+path+"\">"+"Logout</a>"+"\r\n"+
  				"</button>"+"\r\n"+
			"</li>";
		return forPrint;
	}
	public static String getShoppingCartbtn(String path) 
	{
		String forPrint = "<li style=\"float:right;padding-right: 1rem;\">"+"\r\n"+
	            	"<button type=\"button\" style=\"font-size: 1.8rem;background-color: rgb(7, 7, 7);color: white;\">"+
	            		"<a href="+path+"?action=goToCart>Shopping Cart</a>"+
  				"</button>"+"\r\n"+
			"</li>";
		return forPrint;
	}
	public static String getRegisterbtn(String path) 
	{
		String forPrint = "<li id=\"register\">"+"\r\n"+
	            			"<button type=\"button\" id=\"openregister\">"+
	            				"<a href=\""+path+"\">"+"Register</a>"+"\r\n"+
	            			"</button>"+"\r\n"+
	            		  "</li>";
		return forPrint;
	} 
	public static String getLogInbtn(String path) 
	{
		String forPrint = "<li id=\"logIn\">"+"\r\n"+
	            			"<button type=\"button\" id=\"openLogIn\">"+
	            				"<a href=\""+path+"\">"+"Login</a>"+"\r\n"+
	            			"</button>"+"\r\n"+
	            		"</li>";
		return forPrint;
	} 
	public static String getResultp(String result)
	{
		String forPrint = "<p>\r\n"+
				result+"\r\n"+
      		  "</p>";
		return forPrint;
	}
	public static String getAddToCartResulth5(String result)
	{
		String forPrint = "<h5 style=\"float:center;padding-left:12rem;padding-bottom:0rem;margin:0;\">"
					+result+"</div>";
		return forPrint;
	}
	public static String getProductsTable(List<ProductBean> products,HttpServletRequest request) 
	{
		int count = 1;
		String forPrint = "";
		String photopath = ""; 
		String servletPath = request.getContextPath()+"/ShoppingCartHandler";
		for(ProductBean p:products)
    	{
			photopath = request.getContextPath()+p.getPhotopath();
			if(count==1)
			{
				forPrint =forPrint+ "<tr>\r\n";
			}
			forPrint =forPrint+"<td>\r\n"+
					  	"<div class=\"card\">\r\n"+
    				  		"<img\r\n"+
					  			"src=\""+photopath+"\"\r\n"+
    				  			"alt=\""+p.getName()+"\"\r\n"+
					  			"width=\"80\"\r\n"+
    				  			"height=\"110\"\r\n"+
					  			"style=\"width: 100%\"\r\n"+
    				  		"/>\r\n"+
					  		"<h3>"+p.getName()+"</h3>\r\n"+
    				  "<p class=\"price\">$"+String.valueOf(p.getPrice())+"</p>\r\n"+
					  "<p>Some text for the computer.</p>\r\n"+
					  "<p><button ><a style=\"text-decoration: none;color:white;font-size:1.2rem;\" href="+
					  	servletPath+"?action=buy&id="+p.getId()+">Add to cart</a></button></p>\r\n"
					  +"</div>\r\n"+
    				  "</td>\r\n";     
			if(count==3)
			{
				forPrint =forPrint+"</tr>\r\n";
			}
			count++;
		}
		return forPrint;
	}
	public static String getProductsForSPTable(HttpServletRequest request) 
	{
		String forPrint="";
		int count=1;
    	List<ProductBean> products=null;
    	HttpSession session = request.getSession();
    	CustomerBean customer = (CustomerBean)session.getAttribute("customer");
		products = (List<ProductBean>)session.getAttribute("CartProducts");
		double total = customer.calculateTotal(products);
    	if(products.size()==0)
    	{
    		forPrint = forPrint+"<h4 style=\"float:center;\">No Products in the Cart.</h4>";
    	}else
    	{
    		for(ProductBean p:products)
        	{
    			String id = String.valueOf(p.getId());
    			int quantityOfProduct = 0;
    			if(customer.getShoppingCart().get(id)!=null)
    			{
    				quantityOfProduct = (Integer)customer.getShoppingCart().get(id);
    			}
    			if(quantityOfProduct == 0){continue;}
    			if(count==1)
    			{
    				forPrint = forPrint+"<tr>\r\n";
    			}
    			String photopath = request.getContextPath()+p.getPhotopath(); 
    			String servletPath = request.getContextPath()+"/ShoppingCartHandler";
    			forPrint = forPrint+"<td>\r\n"+
    					  	"<div class=\"card\">\r\n"+
        				  		"<img\r\n"+
    					  			"src=\""+photopath+"\"\r\n"+
        				  			"alt=\""+p.getName()+"\"\r\n"+
    					  			"width=\"70\"\r\n"+
        				  			"height=\"90\"\r\n"+
    					  			"style=\"width: 100%\"\r\n"+
        				  		"/>\r\n"+
    					  		"<h3>"+p.getName()+"</h3>\r\n"+
        				  "<p class=\"price\">$"+String.valueOf(p.getSumPrice(quantityOfProduct))+"</p>\r\n"+	
        				  "<p>Quantity: "+quantityOfProduct+"</p>\r\n"+
    					  "<p><button><a style=\"text-decoration: none;color:white;font-size:1.2rem;\" href="
    					  +servletPath+"?action=buyfromCart&id="+p.getId()+">+</a></button>"+
    					  "<button><a style=\"text-decoration: none;color:white;font-size:1.2rem;\" href="
            					  +servletPath+"?action=removeOneProduct&id="+p.getId()+">-</a></button>"+
            			  "<button><a style=\"text-decoration: none;color:white;font-size:1rem;\" href="
                    			  +servletPath+"?action=removeAllQ&id="+p.getId()+">Remove All</a></button>"+
    					  
    					  
    					  "</p>\r\n"+
    					  
    					  "</div>\r\n"+
        				  "</td>\r\n";     
    			if(count==8)
    			{
    				forPrint = forPrint+"</tr>\r\n";
    			}
    			count++;
    		}
    	}
    	forPrint = forPrint+"</table>";
    if(total>0)
    {
    	forPrint = forPrint+
    			"<div style=\"float:right;background-color:black;margin-top:10rem\">"+
    				"<p style=\"color:white;font-size:1.4rem;\">Total:"
    			+total +"$</p>"+
    			"<button style=\"background-color:gray;widht:100%\" >"+
    			"<a style=\"color:black;text-decoration: none;font-size:2rem;\" href="
  			 	 +""+"?action=removeAllQ&id=>Make order</a></button></div>";
    }
    return forPrint;
	}
}
