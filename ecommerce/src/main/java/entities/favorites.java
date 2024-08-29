package entities;

public class favorites {
	private int favoritesId;
	private int productId;
	private int buyerId;
	
	
	
	public favorites(int productId,int buyerId)
	{
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



	public int getFavoritesId() {
		return favoritesId;
	}



	public void setFavoritesId(int favoritesId) {
		this.favoritesId = favoritesId;
	}
	
	
	

}
