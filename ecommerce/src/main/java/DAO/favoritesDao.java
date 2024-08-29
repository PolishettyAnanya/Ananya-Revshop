package DAO;

import java.util.List;

import DTO.favoritesrequest;
import DTO.favoritesresponse;


public interface favoritesDao {

	boolean createfavorites(favoritesrequest favoritesrequest);
	boolean updatefavorites(favoritesrequest favoritesrequest,int favoritesId);
	boolean deletefavoritesById(int favoritesId );
	
	public favoritesresponse getfavoritesById(int favoritesId);
	public List<favoritesresponse> getAllfavorites();
	
}
