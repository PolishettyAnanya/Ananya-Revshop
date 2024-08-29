package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.reviewsrequest;
import DTO.reviewsresponse;
import service.reviewservice;
import utils.ConnectionFactory;

public class reviewDAOClass implements reviewDao {
	private static final Logger logger = LoggerFactory.getLogger(reviewservice.class);

	@Override
	public reviewsresponse getreviewsById(int reviewId) {
	    String sql = "SELECT * FROM reviews WHERE prod_id = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, reviewId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	            	  logger.info("Review found for ID: {}", reviewId);
	               return new reviewsresponse(
	                    rs.getInt("prod_Id"),
	                    rs.getInt("buyerId"),
	                    rs.getInt("sellerId"),
	                    rs.getInt("rating"),
	                    rs.getString("comments")
	                );
	            }
	            else {
                    logger.warn("No review found for ID: {}", reviewId);
                }
	        }
	    } catch (SQLException e) {
	    	logger.error("Error while retrieving review with ID: {}", reviewId, e);
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	@Override
	public boolean createreview(reviewsrequest reviewsrequest) {
	    String sql = "INSERT INTO reviews (prod_Id, buyerId, sellerId, rating, comments) VALUES (?, ?, ?, ?, ?)";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, reviewsrequest.getProd_Id());
	        stmt.setInt(2, reviewsrequest.getBuyerId());
	        stmt.setInt(3, reviewsrequest.getSellerId());
	        stmt.setInt(4, reviewsrequest.getRating());
	        stmt.setString(5, reviewsrequest.getComments());
	        
	        int result = stmt.executeUpdate();
	        if( result > 0)
	        {
	        	logger.info("Successfully created review for product ID: {}", reviewsrequest.getProd_Id());
                return true;
	        }
	        else {
                logger.warn("Failed to create review for product ID: {}", reviewsrequest.getProd_Id());
            }
	        
	    } catch (SQLException e) {
	    	logger.error("Error while creating review for product ID: {}", reviewsrequest.getProd_Id(), e);
	        e.printStackTrace();
	    }
	    
	    return false;
	}


	@Override
	
	public boolean updatereview(reviewsrequest reviewsrequest,int productId) {
	    String sql = "UPDATE reviews SET prod_Id = ?, buyerId = ?, sellerId = ?, rating = ?, comments = ? WHERE prod_Id = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, reviewsrequest.getProd_Id());
	        stmt.setInt(2, reviewsrequest.getBuyerId());
	        stmt.setInt(3, reviewsrequest.getSellerId());
	        stmt.setInt(4, reviewsrequest.getRating());
	        stmt.setString(5, reviewsrequest.getComments());
	        stmt.setInt(6, productId);
	        
	        int result = stmt.executeUpdate();
	        if( result > 0) {
	        	logger.info("Successfully updated review for product ID: {}", productId);
                return true;	
	        }
	        else {
                logger.warn("No review found or updated for product ID: {}", productId);
            }
	        
	    } catch (SQLException e) {
	    	logger.error("Error while updating review for product ID: {}", productId, e);
	        e.printStackTrace();
	    }
	    
	    return false;
	}


	@Override	
	public boolean deletereviewById(int productId) {
	    String sql = "DELETE FROM reviews WHERE prod_Id = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, productId); // Use the reviewId from ReviewsRequest
	        
	        int result = stmt.executeUpdate();
	        if( result > 0)
	        {
	        	logger.info("Successfully deleted review for product ID: {}", productId);
                return true;
	        }
	        else {
                logger.warn("No review found to delete for product ID: {}", productId);
            }
	        
	    } catch (SQLException e) {
	    	logger.error("Error while deleting review for product ID: {}", productId, e);
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	@Override
	public List<reviewsresponse> getAllReviews() {
        List<reviewsresponse> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
            	reviews.add(new reviewsresponse(
                    rs.getInt("prod_Id"),
                    rs.getInt("buyerId"),
                    rs.getInt("sellerId"),
                    rs.getInt("rating"),
                    rs.getString("comments")));
            }
            logger.info("Successfully retrieved {} reviews", reviews.size());
            if(reviews.isEmpty())
            {
            	logger.warn("No products found in the database.");	
            }
        } catch (SQLException e) {
        	 logger.error("Error while retrieving all reviews", e);
            e.printStackTrace();
        }
        
        return reviews;
    }

	

}

