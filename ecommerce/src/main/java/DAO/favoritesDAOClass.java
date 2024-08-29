package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.favoritesrequest;
import DTO.favoritesresponse;
import utils.ConnectionFactory;

public class favoritesDAOClass implements favoritesDao{
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOClass.class);

	 public boolean createfavorites(favoritesrequest favoritesrequest) {
	        String sql = "INSERT INTO favorites(productId,buyerId) VALUES(?,?)";
	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	             
	            stmt.setInt(1, favoritesrequest.getBuyerId());
	            stmt.setInt(2, favoritesrequest.getProductId());
	            int result = stmt.executeUpdate();
	            if (result > 0) {
	            	logger.info("Successfully created favorite entry for productId: {} and buyerId: {}", 
                            favoritesrequest.getProductId(), favoritesrequest.getBuyerId());
	                return true;
	            }
	            else {
	                logger.warn("No rows affected when trying to create favorite entry for productId: {} and buyerId: {}", 
	                            favoritesrequest.getProductId(), favoritesrequest.getBuyerId());
	            }
	            
	        } catch (SQLException e) {
	        	logger.error("Error while creating favorite entry for productId: {} and buyerId: {}", 
                        favoritesrequest.getProductId(), favoritesrequest.getBuyerId(), e);
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 public boolean updatefavorites(favoritesrequest favoritesrequest, int favoritesId) {
	        String sql = "UPDATE favorites SET buyerId = ?, productId = ? WHERE favoritesId = ?";
	        
	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	             
	            stmt.setInt(1, favoritesrequest.getBuyerId());
	            stmt.setInt(2, favoritesrequest.getProductId());
	            stmt.setInt(3, favoritesId);

	            int result = stmt.executeUpdate();
	            if (result > 0) {
	            	logger.info("Successfully updated favorite entry with favoritesId: {}", favoritesId);
	                return true;
	            }
	            else {
	                logger.warn("No rows affected when updating favorite entry with favoritesId: {}", favoritesId);
	            }
	            
	        } catch (SQLException e) {
	        	 logger.error("Error while updating favorite entry with favoritesId: {}", favoritesId, e);
	            e.printStackTrace();
	        }
	        return false;
	    }

	@Override
	public boolean deletefavoritesById(int favoritesId) {
		// TODO Auto-generated method stub
String sql = "DELETE FROM favorites WHERE favoritesId = ?";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, favoritesId);

            int result = stmt.executeUpdate();
            if (result > 0) {
            	logger.info("Successfully deleted favorite entry with favoritesId: {}", favoritesId);
                return true;
            }
            else {
                logger.warn("No rows affected when trying to delete favorite entry with favoritesId: {}", favoritesId);
            }
            
        } catch (SQLException e) {
        	logger.error("Error while deleting favorite entry with favoritesId: {}", favoritesId, e);
            e.printStackTrace();
        }
        return false;
	}
	
	public List<favoritesresponse> getAllfavorites() {
        List<favoritesresponse> favorites = new ArrayList<>();
        String sql = "SELECT * FROM favorites";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                favorites.add(new favoritesresponse(
                    rs.getInt("favoritesId"),
                    rs.getInt("buyerId"),
                    rs.getInt("productId")
                ));
            }
            if (favorites.isEmpty()) {
                logger.info("No favorite entries found.");
            } else {
                logger.warn("Retrieved {} favorite entries.", favorites.size());
            }
            
        } catch (SQLException e) {
        	logger.error("Error while fetching favorite entries", e);
            e.printStackTrace();
        }
        return favorites;
    }

	@Override
	public favoritesresponse getfavoritesById(int favoritesId) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM favorites WHERE favoritesId = ?";
	        favoritesresponse favorite = null;
	        
	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	             
	            stmt.setInt(1, favoritesId);
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                favorite = new favoritesresponse(
	                    rs.getInt("favoritesId"),
	                    rs.getInt("buyerId"),
	                    rs.getInt("productId")
	                );
	                logger.info("Successfully retrieved favorite entry with favoritesId: {}", favoritesId);
	            }
	            else {
	                logger.warn("No favorite entry found with favoritesId: {}", favoritesId);
	            }
	            
	        } catch (SQLException e) {
	        	 logger.error("Error while retrieving favorite entry with favoritesId: {}", favoritesId, e);
	            e.printStackTrace();
	        }
	        return favorite;
	}




	

}
