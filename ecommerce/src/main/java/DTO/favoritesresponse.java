package DTO;

public class favoritesresponse {
	
	private int favoritesId;
	private int productId;
	private int buyerId;
	
	public favoritesresponse(int favoritesId,int productId, int buyerId) {
		// TODO Auto-generated constructor stub
		super();
		this.favoritesId=favoritesId;
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





	@Override
	public String toString() {
		return "[favoritesId=" + favoritesId + ", productId=" + productId + ", buyerId=" + buyerId
				+ "]";
	}
	
	
	

}
