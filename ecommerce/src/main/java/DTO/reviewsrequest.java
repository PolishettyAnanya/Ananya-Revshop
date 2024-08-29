package DTO;

public class reviewsrequest {
	
	private int prod_Id;
	private int buyerId;
	private int sellerId;
	private int rating;
	private String comments;
	
	
	public reviewsrequest(int prod_Id, int buyerId, int sellerId, int rating, String comments) {
		super();
		this.prod_Id = prod_Id;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.rating = rating;
		this.comments = comments;
	}
	public int getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(int prod_Id) {
		this.prod_Id = prod_Id;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "reviewsrequest [prod_Id=" + prod_Id + ", buyerId=" + buyerId + ", sellerId=" + sellerId + ", rating="
				+ rating + ", comments=" + comments + "]";
	}
	
	
	

}
