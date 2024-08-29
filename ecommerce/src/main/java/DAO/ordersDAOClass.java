package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.ordersrequest;
import DTO.ordersresponse;
import service.ordersservice;
import utils.ConnectionFactory;

public class ordersDAOClass implements ordersDao{
	private static final Logger logger = LoggerFactory.getLogger(ordersservice.class);


	@Override
public boolean createOrder(ordersrequest ordersrequest) {
		 String sql = "INSERT INTO orders (buyer_id,total_amount) VALUES (?, ?)";
	        
	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	             
	            stmt.setInt(1, ordersrequest.getBuyer_id());
	            stmt.setDouble(2,ordersrequest.getTotal_amount());
	        
	            int result = stmt.executeUpdate();
	            if (result > 0) {
	                logger.info("Successfully created new order for buyer ID: {}", ordersrequest.getBuyer_id());
	                return true;
	            } else {
	                logger.warn("Failed to create new order for buyer ID: {}", ordersrequest.getBuyer_id());
	            }
	            
	        } catch (SQLException e) {
	        	logger.error("Error while creating order for buyer ID: {}", ordersrequest.getBuyer_id(), e);
	            e.printStackTrace();
	        }
	        return false;
	}

public boolean updateOrder(ordersrequest ordersrequest, int orderid) {
	        String sql = "UPDATE orders SET buyer_id = ?, total_amount=? WHERE orderid = ?";
	        
	        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	             PreparedStatement stmt = con.prepareStatement(sql)) {
	             
	            stmt.setInt(1, ordersrequest.getBuyer_id());
	            stmt.setDouble(2, ordersrequest.getTotal_amount());
	            stmt.setInt(3, orderid);

	            int result = stmt.executeUpdate();
	            if (result > 0) {
	                logger.info("Successfully updated order ID: {}", orderid);
	                return true;
	            } else {
	                logger.warn("No order found to update with ID: {}", orderid);
	            }
	            
	        } catch (SQLException e) {
	        	logger.error("Error while updating order ID: {}", orderid, e);
	            e.printStackTrace();
	        }
	        return false;
	    }

public boolean deleteOrderById(int orderid) {
	            String sql = "DELETE FROM orders WHERE orderid = ?";
	            
	            try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	                 PreparedStatement stmt = con.prepareStatement(sql)) {
	                 
	                stmt.setInt(1, orderid);

	                int result = stmt.executeUpdate();
	                if (result > 0) {
	                    logger.info("Successfully deleted order with ID: {}", orderid);
	                    return true;
	                } else {
	                    logger.warn("No order found to delete with ID: {}", orderid);
	                }
	                
	            } catch (SQLException e) {
	            	 logger.error("Error while deleting order with ID: {}", orderid, e);
	                e.printStackTrace();
	            }
	            return false;
	        }
public ordersresponse getOrderById(int orderid) {
	                String sql = "SELECT * FROM orders WHERE orderid = ?";
	                ordersresponse order = null;
	                
	                try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	                     PreparedStatement stmt = con.prepareStatement(sql)) {
	                     
	                    stmt.setInt(1, orderid);
	                    ResultSet rs = stmt.executeQuery();
	                    
	                    if (rs.next()) {
	                        order = new ordersresponse(
	                            rs.getInt("orderid"),
	                            rs.getInt("buyer_id"),
	                            rs.getDouble("total_amount")    
	                        );
	                        logger.info("Successfully retrieved order with ID: {}", orderid);
	                    } else {
	                        logger.warn("No order found with ID: {}", orderid);
	                    }
	                    
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	                return order;
	            }


public List<ordersresponse> getAllOrders() {
	                    List<ordersresponse> orderList = new ArrayList<>();
	                    String sql = "SELECT * FROM orders";
	                    
	                    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	                         PreparedStatement stmt = con.prepareStatement(sql);
	                         ResultSet rs = stmt.executeQuery()) {
	                         
	                        while (rs.next()) {
	                        	ordersresponse order = new ordersresponse(
	                                    rs.getInt("orderid"),
	                                    rs.getInt("buyer_id"),
	                                    rs.getDouble("total_amount")
	                                );
	                                orderList.add(order);
	                            }

	                            logger.info("Successfully retrieved {} orders.", orderList.size());
	                            if(orderList.isEmpty())
	                            {
	                            	logger.warn("No porders found in the database.");
	                            }
	                        
	                    } catch (SQLException e) {
	                    	logger.error("Error while retrieving all orders.", e);
	                        e.printStackTrace();
	                    }
	                    return orderList;
	                }
	            }

