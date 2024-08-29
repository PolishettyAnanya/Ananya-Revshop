package service;

import java.util.List;

import DAO.favoritesDAOClass;
import DTO.favoritesrequest;
import DTO.favoritesresponse;

public class favoritesservice {
private final favoritesDAOClass favoritesDao;
	
	public favoritesservice()
	{
		favoritesDao = new favoritesDAOClass();
	}	
	
	 public boolean createFavorites(favoritesrequest favoritesrequest)
	 {
	        return favoritesDao.createfavorites(favoritesrequest);
	    }
	 public boolean updatefavorites(favoritesrequest favoritesrequest, int favoritesId)
	 {
	        return favoritesDao.updatefavorites(favoritesrequest, favoritesId);
	    }
	 public boolean deleteFavoritesById(int favoritesId)
	 {
	        return favoritesDao.deletefavoritesById(favoritesId);
	    }
	 public List<favoritesresponse> getAllfavorites()
	 {
	        return favoritesDao.getAllfavorites();
	    }
	 public favoritesresponse getfavoritesById(int favoritesId) 
	 {
	        return favoritesDao.getfavoritesById(favoritesId);
	    }
	 public static void main(String[] args) {
		favoritesservice f= new favoritesservice();
//		System.out.println(f.createFavorites(new favoritesrequest(3,2)));
//		System.out.println(f.updatefavorites(new favoritesrequest(2, 2), 6));
//		System.out.println(f.deleteFavoritesById(6));
//		System.out.println(f.getAllfavorites());
		System.out.println(f.getfavoritesById(5));
	}

}
