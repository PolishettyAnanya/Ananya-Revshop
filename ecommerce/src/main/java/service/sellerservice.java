package service;

import DAO.sellerDAOClass;
import DTO.sellerrequest;
import DTO.sellerresponse;

public class sellerservice {

	private final sellerDAOClass sellerDao;
	public sellerservice() {
		// TODO Auto-generated constructor stub
		sellerDao=new sellerDAOClass();
	}
	

	public sellerresponse getsellerById(int sellerId)
	{
		try
		{
			return sellerDao.getsellerById(sellerId);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public boolean createseller(sellerrequest sellerrequest) 
	{
		return sellerDao.createseller(sellerrequest);
		
	}
	public static void main(String[] args) {
		sellerservice s=new sellerservice();
		System.out.println(s.createseller(new sellerrequest("Ananya","a@gmail.com","123abc",867893489,"delhi")));
	}

	}

