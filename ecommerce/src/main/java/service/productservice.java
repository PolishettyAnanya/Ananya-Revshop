package service;

import java.util.List;

import DAO.ProductDAOClass;
import DTO.productrequest;
import DTO.productresponse;

public class productservice {
	
	private final ProductDAOClass ProductDao;
	
	
	public productservice()
	{
		ProductDao = new ProductDAOClass();
	}
	
	public productresponse getProductById(int productId)
	{
		try
		{
			return ProductDao.getProductById(productId);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public productresponse getProductByName(String productName)
	{
		try
		{
			return ProductDao.getProductByName(productName);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public boolean createProduct(productrequest productrequest)
	{
		return ProductDao.createProduct(productrequest);
	}
	
	public List<productresponse> getAllProducts()

	{
		return ProductDao.getAllProducts();
	}
	
	public boolean deleteProductById(int productId)
	{
	    return ProductDao.deleteProductById(productId);
	}
	
	public boolean updateProduct(productrequest productrequest, int productId)
	{
	    return ProductDao.updateProduct(productrequest, productId);
	}
	public List<productresponse> getAllCategories() 
	{
		return ProductDao.getAllCategories();
	}
	public productresponse getCategoryById(int categoryId)
	{
	    return ProductDao.getCategoryById(categoryId);
	}
	public productresponse getProductDescriptionById(int productId)
	{
		return ProductDao.getProductDescriptionById(productId);
	}
	
	public productresponse getProductReviewsById(int productId)
	{
	    return ProductDao.getProductReviewsById(productId);
	}
	public productresponse getProductPriceById(int productId)
	{
	    return ProductDao.getProductPriceById(productId);
	}








	
	public static void main(String[] args) {
		
		productservice p = new productservice();
	//System.out.println(p.createProduct(new productrequest("Laptop",80000.00F,"LenovoLaptop",1,1,"Excellent",121)));
//		System.out.println(p.createProduct(new productrequest("SmartWatch",15000.00F,"I-watch",1,3,"Good",200)));
//System.out.println(p.getAllProducts());
		//System.out.println(p.getProductById(2));
//	System.out.println(p.getAllCategories());
//		System.out.println(p.getCategoryById(111));
//		System.out.println(p.getProductDescriptionById(2));
		System.out.println(p.getProductReviewsById(2));
//		System.out.println(p.getProductPriceById(3));
//	    System.out.println(p.getProductByName("EarPhones"));
//	System.out.println(p.deleteProductById(3));
		//System.out.println(p.updateProduct(new productrequest("Laptop",80000.00F,"DellLaptop",1,1,"Excellent",121)));
//		System.out.println(p.updateProduct(new productrequest("EarPhones", 15000.00F, "Boat-Earphones", 1, 1, "Good", 111),3));
		

	}

}
