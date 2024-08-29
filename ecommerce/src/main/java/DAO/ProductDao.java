package DAO;

import java.util.List;

import DTO.productrequest;
import DTO.productresponse;



public interface ProductDao {
	
	boolean createProduct(productrequest productrequest);
	boolean updateProduct(productrequest productrequest,int productId);
	boolean deleteProductById(int productId );
	
	public productresponse getProductById(int productId);
	public List<productresponse> getAllProducts();
	
	
	public List<productresponse> getAllCategories();
	public productresponse getCategoryById(int categoryId);
    
	public productresponse getProductDescriptionById(int productId);
    public productresponse getProductByName(String productName);
    public productresponse getProductReviewsById(int productId);
    public productresponse getProductPriceById(int productId);
   
 
	

}
