package service;

import java.util.List;

import DAO.cartDAOClass;
import DTO.cartrequest;
import DTO.cartresponse;



public class cartservice {
	private final cartDAOClass cartDao;
	
	public cartservice()
	{
		cartDao = new cartDAOClass();
	}	
	
	public boolean createCart(cartrequest cartrequest) 
	{
        return cartDao.createcart(cartrequest);
    }
	
	public boolean updatecart(cartrequest cartrequest, int cartId) 
	{
        return cartDao.updatecart(cartrequest, cartId);
    }
	public boolean deletecartById(int cartId)
	{
        return cartDao.deletecartById(cartId);
    }
	 public cartresponse getcartById(int cartId)
	 {
	        return cartDao.getcartById(cartId);
	    }
	 public List<cartresponse> getAllcarts() {
	        return cartDao.getAllcarts();
	    }
	 
	 
	 public static void main(String[] args) {
		 cartservice c = new cartservice();
//		 System.out.println(c.createCart(new cartrequest()));
//		 System.out.println(c.updatecart(new cartrequest(), 0));
//		 System.out.println(c.deletecartById(1));
//		 System.out.println(c.getcartById(0));
		 System.out.println(c.getAllcarts());
	}

}
