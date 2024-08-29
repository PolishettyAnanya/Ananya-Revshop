package entities;

public class Product_details {

		// TODO Auto-generated method stub
		private int productId;
		private String productName;
		private float price;
		private String productDescription;
		private int sellerId;
		private int productQuantity;
		private String user_review;
		private int categoryId;

public Product_details(int productId,String productName,float price,String productDescription,int sellerId,int productQuantity,String user_review,int categoryId)
{
	super();
	this.productId=productId;
	this.productName=productName;
	this.price=price;
	this.productDescription=productDescription;
	this.sellerId=sellerId;
	this.productQuantity=productQuantity;
	this.user_review=user_review;
	this.categoryId=categoryId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public int getSellerId() {
	return sellerId;
}
public void setSellerId(int sellerId) {
	this.sellerId = sellerId;
}
public int getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
public String getUser_review() {
	return user_review;
}
public void setUser_review(String user_review) {
	this.user_review = user_review;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
}
