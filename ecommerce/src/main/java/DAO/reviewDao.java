package DAO;

import java.util.List;

import DTO.reviewsrequest;
import DTO.reviewsresponse;


public interface reviewDao {
	reviewsresponse getreviewsById(int productId);
	boolean createreview(reviewsrequest reviewsrequest);
	boolean updatereview(reviewsrequest reviewsrequest,int productId);
	boolean deletereviewById(int productId );
	public List<reviewsresponse> getAllReviews();

}
