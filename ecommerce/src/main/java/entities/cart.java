package entities;

public class cart {
	
	private int cartId;
	private int buyerId;
	private int productId;
	private int cartQuantity;
	
	
	public cart(int cartId, int buyerId, int productId,int cartQuantity)
	{
		super();
		this.cartId=cartId;
		this.buyerId=buyerId;
		this.productId=productId;
		this.cartQuantity=cartQuantity;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getCartQuantity() {
		return cartQuantity;
	}


	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	
	
	
	

}
