package DTO;

public class sellerresponse {
	private int sellerId;
	private String sellerName;
	private String email;
	private String password;
	private int phoneno;
	private String address;
	
	

	public sellerresponse(int sellerId, String sellerName,String email, String password,int phoneno,String address)
	{
		super();
		this.sellerId=sellerId;
		this.sellerName=sellerName;
		this.email=email;
		this.password=password;
		this.phoneno=phoneno;
		this.address=address;
				
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "sellerresponse [sellerId=" + sellerId + ", sellerName=" + sellerName + ", email=" + email
				+ ", password=" + password + ", phoneno=" + phoneno + ", address=" + address + "]";
	}
	

}
