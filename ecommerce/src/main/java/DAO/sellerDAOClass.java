package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.sellerrequest;
import DTO.sellerresponse;
import service.sellerservice;
import utils.ConnectionFactory;

public class sellerDAOClass implements sellerDao {
	 private static final Logger logger = LoggerFactory.getLogger(sellerservice.class);

	@Override
	public sellerresponse getsellerById(int sellerId) {
		String sql="SELECT * FROM seller WHERE sellerId=?";
		try (Connection con=ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt=con.prepareStatement(sql))
		{
			stmt.setInt(1, sellerId);
			
			try(ResultSet rs=stmt.executeQuery())
			{
				if(rs.next())
				{
					logger.info("Seller found with ID: {}", sellerId);
					return new sellerresponse(
						    rs.getInt("sellerId"),
							rs.getString("sellerName"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getInt("phoneno"),
							rs.getString("address")
							);
				}
				else {
                    logger.warn("No seller found with ID: {}", sellerId);
                }
				
			}
		}
		catch(SQLException e)
		{
			logger.error("Error while retrieving seller with ID: {}", sellerId, e);
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean createseller(sellerrequest sellerrequest) {
		String sql="INSERT INTO seller(sellerName,email,password,phoneno,address) values(?,?,?,?,?)";
		try (Connection con=ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement stmt=con.prepareStatement(sql))
		{
//			stmt.setInt(1, sellerrequest.getSellerId());
			stmt.setString(1,  sellerrequest.getSellerName());
			stmt.setString(2, sellerrequest.getEmail());
			stmt.setString(3,  sellerrequest.getPassword());
			stmt.setInt(4,  sellerrequest.getPhoneno());
			stmt.setString(5, sellerrequest.getAddress());
			
			int result=stmt.executeUpdate();
			if(result>0)
			{
				logger.info("Successfully created new seller with email: {}", sellerrequest.getEmail());
				return true;
			}
			else {
                logger.warn("Failed to create new seller with email: {}", sellerrequest.getEmail());
            }
		} catch (SQLException e) {
			logger.error("Error while creating new seller with email: {}", sellerrequest.getEmail(), e);
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateseller(sellerrequest sellerrequest, int sellerId) {
		String sql= "UPDATE seller SET sellerName=?, email=?, password=?, phoneno=?, address=? WHERE sellerId=?";
		try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
				PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setString(1, sellerrequest.getSellerName());
			stmt.setString(2, sellerrequest.getEmail());
			stmt.setString(3, sellerrequest.getPassword());
			stmt.setInt(4, sellerrequest.getPhoneno());
			stmt.setString(5, sellerrequest.getAddress());
			stmt.setInt(6, sellerId);
			
			   int result = stmt.executeUpdate();
			   if(result> 0)
			   {
				   logger.info("Successfully updated seller with ID: {}", sellerId);
					return true;
				}
			   else {
	                logger.warn("No seller found to update with ID: {}", sellerId);
	            }
			} 
		catch (SQLException e) 
		{
			 logger.error("Error while updating seller with ID: {}", sellerId, e);
				e.printStackTrace();
			}
		return false;
			   
		}
	@Override
	public boolean deleteseller(int sellerId) {
    String sql = "DELETE FROM seller WHERE sellerId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, sellerId); 
	        
	        int result = stmt.executeUpdate();
	        if (result > 0) {
                logger.info("Successfully deleted seller with ID: {}", sellerId);
                return true;
            } else {
                logger.warn("No seller found to delete with ID: {}", sellerId);
            }
	        
	    } catch (SQLException e) {
	    	logger.error("Error while deleting seller with ID: {}", sellerId, e);
	        e.printStackTrace();
	    }
		return false;
	}

	    public List<Optional<sellerresponse>> getAllSellers() {
	    	List<Optional<sellerresponse>> sellers = new ArrayList<>();
	        String sql = "SELECT * FROM sellers";  // Adjust the table name as per your database schema

	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	             PreparedStatement stmt = con.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                sellerresponse response = new sellerresponse(
	                    rs.getInt("sellerId"),
	                    rs.getString("sellerName"),
	                    rs.getString("email"),
	                    rs.getString("password"),
	                    rs.getInt("phoneno"),
	                    rs.getString("address")
	                );
	                sellers.add(Optional.of(response));
	            }
	            logger.info("Successfully retrieved {} sellers", sellers.size());
	            if(sellers.isEmpty())
	            {
	            	logger.warn("No sellers found in the database.");
	            }
	        } catch (SQLException e) {
	        	 logger.error("Error while retrieving all sellers", e);
	            e.printStackTrace(); 
	        }

	        return sellers;
 	    }
       

	}



