package DAO;

import java.util.List;

import DTO.buyerrequest;
import DTO.buyerresponse;

public interface buyerDao {
	buyerresponse getBuyerById(int buyerId);
	boolean createbuyer(buyerrequest buyerrequest);
	boolean updatebuyer(buyerrequest buyerrequest,int buyerId);
	boolean deletebuyer(int buyerId);
	List<buyerresponse> getAllBuyers();

}
