package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.productrequest;
import DTO.productresponse;
import utils.ConnectionFactory;

public class ProductDAOClass implements ProductDao {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOClass.class);
	
	@Override
	public productresponse getProductById(int productId) {
		
		String sql="SELECT * FROM Product_details WHERE productId=?";
		try (Connection con=ConnectionFactory.getConnectionFactory().getConnection(); 
				PreparedStatement stmt=con.prepareStatement(sql))
		{
			stmt.setInt(1, productId);
			try(ResultSet rs=stmt.executeQuery())
			{
				if(rs.next())
				{
					 logger.info("Product retreived");
					 return new productresponse(
							rs.getInt("productId"),
							rs.getString("productName"),
							rs.getFloat("price"),
							rs.getString("productDescription"),
							rs.getInt("sellerId"),
							rs.getInt("productQuantity"),
							rs.getString("user_review"),
							rs.getInt("categoryId"));
					 
				}
				else {
                    logger.warn("No product found with ID: {}", productId);
                }
			}
		}
		catch (SQLException e) {
			
			logger.error("SQL error occurred while retrieving product with ID: {}", productId, e);
			e.printStackTrace();
			}
		return null;	
	}

@Override
	public boolean createProduct(productrequest productrequest) {
		String sql="INSERT INTO product_details(productName,price,productDescription,sellerId,productQuantity,user_review,categoryId) VALUES(?,?,?,?,?,?,?)";
		try (Connection con=ConnectionFactory.getConnectionFactory().getConnection(); 
				PreparedStatement stmt=con.prepareStatement(sql))
		{
			stmt.setString(1, productrequest.getProductName());
			stmt.setFloat(2, productrequest.getPrice());
			stmt.setString(3, productrequest.getProductDescription());
			stmt.setInt(4, productrequest.getSellerId());
			stmt.setInt(5, productrequest.getProductQuantity());
			stmt.setString(6, productrequest.getUser_review());
			stmt.setInt(7, productrequest.getCategoryId());
			
			int result=stmt.executeUpdate();
			if(result>0)
			{
				logger.info("Product successfully created: {}", productrequest);
 
				return true;
			}
			else {
                logger.warn("Failed to create product: {}", productrequest);
            }
			
		} catch (SQLException e) {
			 logger.error("SQL error occurred while creating product: {}", productrequest, e);
			e.printStackTrace();
		}
		return false;   
	}
	@Override
	
public boolean updateProduct(productrequest productrequest,int productId) {
	    String sql = "UPDATE product_details SET productName = ?, price = ?, productDescription = ?, sellerId = ?, productQuantity = ?, user_review = ?, categoryId = ? WHERE productId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setString(1, productrequest.getProductName());
	        stmt.setFloat(2, productrequest.getPrice());
	        stmt.setString(3, productrequest.getProductDescription());
	        stmt.setInt(4, productrequest.getSellerId());
	        stmt.setInt(5, productrequest.getProductQuantity());
	        stmt.setString(6, productrequest.getUser_review());
	        stmt.setInt(7, productrequest.getCategoryId()); 
	        stmt.setInt(8, productId);
	        
	        int result = stmt.executeUpdate();
	        if (result > 0) {
	        	logger.info("Successfully updated product with ID: {}", productId);
	            return true;
	        } 
	        else {
                logger.warn("Failed to create product: {}", productrequest);
            }
	        
	    } catch (SQLException e) {
	    	 logger.error("SQL error occurred while creating product: {}", productrequest, e);
	        e.printStackTrace();
	    }
	    return false;
	}
	
	@Override
	public boolean deleteProductById(int productId) {
		String sql = "DELETE FROM Product_details WHERE productId = ?"; 
	    try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
	        

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, productId);

	        int rowsAffected = ps.executeUpdate();

	        if( rowsAffected > 0)
	        {
	        	logger.info("Product with productId: {} was successfully deleted.", productId);
	        	return true;
	          } 
	        else
	        {
	        	logger.warn("No product found with productId: {} to delete.", productId);
                return false;
	        }
	    }
	        catch (SQLException e) {
	        	 logger.error("Error while deleting product with productId: {}", productId, e);
	        e.printStackTrace();
	        return false;
	    }
	}

	
	
	public List<productresponse> getAllProducts() {
	    List<productresponse> products = new ArrayList<>();
	    String sql = "SELECT * FROM Product_details";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            products.add(new productresponse(
	                rs.getInt("productId"),
	                rs.getString("productName"),
	                rs.getFloat("price"),
	                rs.getString("productDescription"),
	                rs.getInt("sellerId"),
	                rs.getInt("productQuantity"),
	                rs.getString("user_review"),
	                rs.getInt("categoryId")
	            ));
	            
	        }
	        logger.info("Total products retrieved:{}",products.size());
	        if (products.isEmpty()) {
                logger.warn("No products found in the database.");
            }
	    } catch (SQLException e) {
	    	logger.error("Error while retrieving products", e);
	        e.printStackTrace();
	    }
	    
	    return products;
	}
	
	@Override
	public productresponse getProductByName(String productName) {
	    String sql = "SELECT * FROM Product_details WHERE productName = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection(); 
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setString(1, productName);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	            	 logger.info("Product found");
	            	return new productresponse(
	            		    rs.getInt("productId"),
	            		    rs.getString("productName"),
	            		    rs.getFloat("price"),
	            		    rs.getString("productDescription"),
	            		    rs.getInt("sellerId"),
	            		    rs.getInt("productQuantity"),
	            		    rs.getString("user_review"),
	            		    rs.getInt("categoryId")
	            		);
	            }
	            logger.warn("No product found with productName: {}", productName);
	        }
	    } catch (SQLException e) {
	    	logger.error("Error while retrieving product with productName: {}", productName, e);
	        e.printStackTrace();
	    }
	    return null; 
	
}
	
	
	public productresponse getCategoryById(int categoryId) {
	    productresponse category = null;
	    String sql = "SELECT * FROM Product_details WHERE categoryId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, categoryId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	            	logger.info("Category found");
	                category = new productresponse(
	                    rs.getInt("productId"),
	                    rs.getString("productName"),
	                    rs.getFloat("price"),
	                    rs.getString("productDescription"),
	                    rs.getInt("sellerId"),
	                    rs.getInt("productQuantity"),
	                    rs.getString("user_review"),
	                    rs.getInt("categoryId")
	                );
	            }
	            else {
                    logger.warn("No product found with categoryId: {}", categoryId);
                }
	        }
	    } catch (SQLException e) {
	    	 logger.error("Error while retrieving product with categoryId: {}", categoryId, e);
	        e.printStackTrace();
	    }
	    
	    return category;
	}
	public productresponse getProductDescriptionById(int productId) {
		productresponse product = null;
	    String sql = "SELECT productId, productName, price, productDescription, sellerId, productQuantity, user_review, categoryId FROM Product_details WHERE productId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, productId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	            	 logger.info("Product found");
	                product = new productresponse(
	                    rs.getInt("productId"),
	                    rs.getString("productName"),
	                    rs.getFloat("price"),
	                    rs.getString("productDescription"),
	                    rs.getInt("sellerId"),
	                    rs.getInt("productQuantity"),
	                    rs.getString("user_review"),
	                    rs.getInt("categoryId")
	                );
	            }
	            else {
                    logger.warn("No product found with productId: {}", productId);
                }
	        }
	    } catch (SQLException e) {
	    	logger.error("Error while retrieving product with productId: {}", productId, e);
	        e.printStackTrace();
	    }
	    
	    return product;
	}
	
	
	public productresponse getProductReviewsById(int productId) {
	    productresponse product = null;
	    String sql = "SELECT productId, productName, price, productDescription, sellerId, productQuantity, user_review, categoryId FROM Product_details WHERE productId = ?";
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setInt(1, productId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	            	logger.info("Product found");
	                product = new productresponse(
	                    rs.getInt("productId"),
	                    rs.getString("productName"),
	                    rs.getFloat("price"),
	                    rs.getString("productDescription"),
	                    rs.getInt("sellerId"),
	                    rs.getInt("productQuantity"),
	                    rs.getString("user_review"),
	                    rs.getInt("categoryId")
	                );
	            }
	            else {
                    logger.warn("No product found with productId: {}", productId);
                }
	        }
	    } catch (SQLException e) {
	    	logger.error("Error while retrieving product reviews for productId: {}", productId, e);
	        e.printStackTrace();
	    }
	    
	    return product;
	}
	


	@Override
	public List<productresponse> getAllCategories()

	{
		List<productresponse> products = new ArrayList<>();
        String sql = "SELECT * FROM product_details"; 

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
   	         PreparedStatement stmt = con.prepareStatement(sql);
   	         ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
            	products.add(new productresponse(
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getFloat("price"),
                    rs.getString("productDescription"),
                    rs.getInt("sellerId"),
                    rs.getInt("productQuantity"),
                    rs.getString("user_review"),
                    rs.getInt("categoryId") )
                );
            }
            logger.info("Products found");
            if (products.isEmpty()) {
                logger.warn("No products found in the database.");
            }
        } 
          catch (SQLException e) {
        	  logger.error("Error while retrieving products", e);
            e.printStackTrace(); 
        }
        logger.info("Total products retrieved: {}", products.size());
        return products;
	}

	@Override
	public productresponse getProductPriceById(int productId) {
		// TODO Auto-generated method stub
		    productresponse product = null;
		    String sql = "SELECT * FROM Product_details WHERE productId = ?";
		    
		    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
		         PreparedStatement stmt = con.prepareStatement(sql)) {
		        
		        stmt.setInt(1, productId);
		        try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		            	 logger.info("Product found");
		                product = new productresponse(
		                    rs.getInt("productId"),
		                   rs.getString("productName"),
		                    rs.getFloat("price"),
		                    rs.getString("productDescription"),
		                    rs.getInt("sellerId"),
		                    rs.getInt("productQuantity"),
		                    rs.getString("user_review"),
		                    rs.getInt("categoryId")
		                );
		            }
		            else {
	                    logger.warn("No product found with productId: {}", productId);
	                }
		        }
		    } catch (SQLException e) {
		    	logger.error("Error while retrieving product with productId: {}", productId, e);
	 
		        e.printStackTrace();
		    }
		    
		    return product;
	}
	}

