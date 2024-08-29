package DTO;

public class favoritesrequest {
	private int productId;
	private int buyerId;
	
	public favoritesrequest(int productId, int buyerId) {
		// TODO Auto-generated constructor stub
		super();
		this.productId=productId;
		this.buyerId=buyerId;
		
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	@Override
	public String toString() {
		return "favoritesrequest [productId=" + productId + ", buyerId=" + buyerId + "]";
	}
	
	
	

}
