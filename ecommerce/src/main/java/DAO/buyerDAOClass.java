package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.buyerrequest;
import DTO.buyerresponse;
import service.buyerservice;
import utils.ConnectionFactory;

public class buyerDAOClass implements buyerDao {
	private static final Logger logger = LoggerFactory.getLogger(buyerservice.class);

	@Override
	public buyerresponse getBuyerById(int buyerId) {
		String sql= "SELECT * FROM buyer WHERE buyerId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			
			stmt.setInt(1, buyerId);			
			try(ResultSet rs= stmt.executeQuery())
			{
				if(rs.next()) {
					logger.info("Buyer found for ID: {}", buyerId);
					   return new buyerresponse(rs.getInt("buyerId"),
							                    rs.getString("buyerName"),
							                    rs.getString("email"),
							                    rs.getString("password"),
							                    rs.getInt("phoneNo"),
					                            rs.getString("address"),
					                            rs.getString("date"));
					
				}
				else {
                    logger.warn("No buyer found with ID: {}", buyerId);
                }
			}
		}
		catch (SQLException e) 
		{
			logger.error("Error while retrieving buyer with ID: {}", buyerId, e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createbuyer(buyerrequest buyerrequest) {
		// TODO Auto-generated method stub
		String sql= "INSERT INTO buyer(buyerName,email,password, phoneNo,address) VALUES(?,?,?,?,?)";
		
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, buyerrequest.getBuyername());
			stmt.setString(2, buyerrequest.getEmail());
			stmt.setString(3, buyerrequest.getPassword());
			stmt.setLong(4, buyerrequest.getPhoneNo());
			stmt.setString(5, buyerrequest.getAddress());
			//stmt.setString(6, buyerrequest.getDate());
			
			int result= stmt.executeUpdate();
			
			if(result> 0) {
				 logger.info("Successfully created new buyer with email: {}", buyerrequest.getEmail());
				return true;
			}
			else {
                logger.warn("Failed to create new buyer with email: {}", buyerrequest.getEmail());
            }
		} 
		catch (SQLException e)
		{
			logger.error("Error while creating new buyer with email: {}", buyerrequest.getEmail(), e);
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean updatebuyer(buyerrequest buyerrequest, int buyerId) {
		// TODO Auto-generated method stub
		String sql="UPDATE buyer SET buyerName=?,email=?,password=?, phoneNo=?,address=? where buyerId =?";
		try(Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, buyerrequest.getBuyername());
			stmt.setString(2, buyerrequest.getEmail());
			stmt.setString(3, buyerrequest.getPassword());
			stmt.setLong(4, buyerrequest.getPhoneNo());
			stmt.setString(5, buyerrequest.getAddress());
			stmt.setInt(6, buyerId);
				
		int result=	stmt.executeUpdate();
		if(result > 0) {
			logger.info("Successfully updated buyer with ID: {}", buyerId);
			return true;
		}
		else {
            logger.warn("No buyer found to update with ID: {}", buyerId);
        }
			
		}catch (SQLException e) {
			logger.error("Error while updating buyer with ID: {}", buyerId, e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deletebuyer(int buyerId) {
    String sql = "DELETE FROM buyer WHERE buyerId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, buyerId); 
	        
	        int result = stmt.executeUpdate();
	        if( result > 0)
	        {
	        	logger.info("Successfully deleted buyer with ID: {}", buyerId);
                return true;	
	        }
	        else {
                logger.warn("No buyer found to delete with ID: {}", buyerId);
            }
	        
	    } catch (SQLException e) {
	    	logger.error("Error while deleting buyer with ID: {}", buyerId, e);
	        e.printStackTrace();
	    }
		return false;
	}

	@Override
	public List<buyerresponse> getAllBuyers() {
		// TODO Auto-generated method stub
		List<buyerresponse> buyers = new ArrayList<>();
        String sql = "SELECT * FROM buyers";  // Adjust the table name as per your database schema

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Map the result set to buyerresponse
                buyers.add(new buyerresponse(
                    rs.getInt("buyerid"),
                    rs.getString("buyername"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("phoneNo"),
                    rs.getString("address"),
                    rs.getString("date")
                ));
            }
            logger.info("Successfully retrieved {} buyers", buyers.size());
            if(buyers.isEmpty())
            {
            	logger.warn("No favorite entries found.");
            }
        } catch (SQLException e) {
        	 logger.error("Error while retrieving all buyers", e);
            e.printStackTrace(); 
        }

        return buyers;
    }
}





















		
	    
			
	    
