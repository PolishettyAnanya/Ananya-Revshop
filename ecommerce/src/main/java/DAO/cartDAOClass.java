package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.cartrequest;
import DTO.cartresponse;
import utils.ConnectionFactory;

public class cartDAOClass implements cartDao {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOClass.class);

	@Override
	public boolean createcart(cartrequest cartrequest) {
String sql = "INSERT INTO cart (buyerId, productId, cartQuantity) VALUES (?, ?, ?)";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, cartrequest.getBuyerId());
            stmt.setInt(2, cartrequest.getProductId());
            stmt.setInt(3, cartrequest.getCartQuantity());
            
            int result = stmt.executeUpdate();
            if( result > 0)
            {
            	logger.info("Successfully created cart entry for buyerId: {}, productId: {}", 
                        cartrequest.getBuyerId(), cartrequest.getProductId());
        }
        else {
            logger.warn("Failed to create cart entry for buyerId: {}, productId: {}", 
                        cartrequest.getBuyerId(), cartrequest.getProductId());
        }
        }
        catch (SQLException e) {
        	logger.error("Error while creating cart entry with cartId: {}, productId:{}");
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updatecart(cartrequest cartrequest, int cartId) {
       String sql = "UPDATE cart SET buyerId = ?, productId = ?, cartQuantity = ? WHERE cartId = ?";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, cartrequest.getBuyerId());
            stmt.setInt(2, cartrequest.getProductId());
            stmt.setInt(3, cartrequest.getCartQuantity());
            stmt.setInt(4, cartId);

            int result = stmt.executeUpdate();
            if (result > 0) {
                logger.info("Successfully updated cart entry with cartId: {}", cartId);
                return true;
            } else {
                logger.warn("No rows updated for cartId: {}", cartId);
            }
            
        } catch (SQLException e) {
        	logger.error("Error while updating cart entry with cartId: {}", cartId, e);
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean deletecartById(int cartId) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM cart WHERE cartId = ?";
	        
	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	             
	            stmt.setInt(1, cartId);

	            int result = stmt.executeUpdate();
	            if (result > 0) {
	                logger.info("Successfully deleted cart entry with cartId: {}", cartId);
	                return true;
	            } else {
	                logger.warn("No rows deleted for cartId: {}", cartId);
	            }
	            
	        } catch (SQLException e) {
	        	 logger.error("Error while deleting cart entry with cartId: {}", cartId, e);
	            e.printStackTrace();
	        }
		return false;
	}

	@Override
	public cartresponse getcartById(int cartId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cart WHERE cartId = ?";
        cartresponse cart = null;
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                cart = new cartresponse(
                    rs.getInt("cartId"),
                    rs.getInt("buyerId"),
                    rs.getInt("productId"),
                    rs.getInt("cartQuantity")
                );
                logger.info( "Cart retrieved successfully with ID: {0}", cartId);
            } else {
                logger.warn( "No cart found with ID: {0}", cartId);
            }
            
        } catch (SQLException e) {
        	logger.error( "SQL exception occurred while retrieving cart with ID: " + cartId, e);
            e.printStackTrace();
        }
        return cart;
	}

	@Override
	public List<cartresponse> getAllcarts() {
		// TODO Auto-generated method stub
		List<cartresponse> cartList = new ArrayList<>();
        String sql = "SELECT * FROM cart";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
            	logger.info("Successfully retrieved {} carts", cartList.size());                cartList.add(new cartresponse(
                    rs.getInt("cartId"),
                    rs.getInt("buyerId"),
                    rs.getInt("productId"),
                    rs.getInt("cartQuantity")
                ));
            }
         
            if (cartList.isEmpty()) {
                logger.warn("No products found in the database.");
            }
            
        } catch (SQLException e) {
        	 logger.error("Error while retrieving all carts", e);
            e.printStackTrace();
        }
        return cartList;
	}
	

}
