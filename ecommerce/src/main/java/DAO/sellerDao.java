package DAO;

import java.util.List;
import java.util.Optional;

import DTO.sellerrequest;
import DTO.sellerresponse;

public interface sellerDao {
	
	sellerresponse getsellerById(int sellerId);
	boolean createseller(sellerrequest sellerrequest);
	boolean updateseller(sellerrequest sellerrequest,int sellerId);
	boolean deleteseller(int sellerId );
	List<Optional<sellerresponse>> getAllSellers();

}
