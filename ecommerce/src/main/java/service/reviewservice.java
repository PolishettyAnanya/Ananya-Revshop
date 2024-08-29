package service;

import java.util.List;

import DAO.reviewDAOClass;
import DTO.reviewsrequest;
import DTO.reviewsresponse;


public class reviewservice {
	
	private final reviewDAOClass reviewDao;
	
	public reviewservice()
	{
		reviewDao = new reviewDAOClass();
	}
	
	public reviewsresponse getreviewsById(int productId)
	{
		try
		{
			return reviewDao.getreviewsById(productId);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean createreview(reviewsrequest reviewsrequest)
	{
	    return reviewDao.createreview(reviewsrequest);
	}
	
	public boolean updatereview(reviewsrequest reviewsrequest, int productId) 
	{
	    return reviewDao.updatereview(reviewsrequest, productId);
	}
	
	public boolean deletereviewById(int productId)
	{
	    return reviewDao.deletereviewById(productId);
	}
	public List<reviewsresponse> getAllReviews() 
	{
	    return reviewDao.getAllReviews();
	}



	
	public static void main(String[] args) {
		reviewservice r = new reviewservice();
		//System.out.println(r.getreviewsById(10));
		//System.out.println(r.getreviewsById(11));
		//System.out.println(r.createreview(new reviewsrequest(2,1,1,4,"NotGood")));
		//System.out.println(r.createreview(new reviewsrequest(3,2,1,3,"Avg")));
		//System.out.println(r.updatereview(new reviewsrequest(10,2,1,2,"notgood"), 10));
//		System.out.println(r.updatereview(new reviewsrequest(3,1,1,2,"bad"), 3));
//		System.out.println(r.deletereviewById(2));
		System.out.println(r.getAllReviews());

		
		
	}

}
