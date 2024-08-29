package DAO;

import java.util.List;

import DTO.cartrequest;
import DTO.cartresponse;

public interface cartDao {
	
	boolean createcart(cartrequest cartrequest);
	boolean updatecart(cartrequest cartrequest,int cartId);
	boolean deletecartById(int cartId );
	
	public cartresponse getcartById(int cartId);
	public List<cartresponse> getAllcarts();

}
