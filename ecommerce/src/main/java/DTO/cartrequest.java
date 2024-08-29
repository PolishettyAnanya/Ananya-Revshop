package DTO;

public class cartrequest {
	private int cartId;
	private int buyerId;
	private int productId;
	private int cartQuantity;
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
	@Override
	public String toString() {
		return "cartrequest [cartId=" + cartId + ", buyerId=" + buyerId + ", productId=" + productId + ", cartQuantity="
				+ cartQuantity + "]";
	}
	
	

}
