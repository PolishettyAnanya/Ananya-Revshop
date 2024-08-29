package DTO;

public class buyerresponse {
	
	private int buyerid;
	private String buyername;
	private String email;
	private String password;
	private int phoneNo;
	private String address;
	private String date;
	
	public buyerresponse(int buyerid,String buyername,String email,String password,int phoneNo,String address, String date)
	{
		super();
		this.buyerid=buyerid;
		this.buyername=buyername;
		this.email=email;
		this.password=password;
		this.phoneNo=phoneNo;
		this.address=address;
		this.date=date;
	}



	public int getBuyerid() {
		return buyerid;
	}



	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}



	public String getBuyername() {
		return buyername;
	}



	public void setBuyername(String buyername) {
		this.buyername = buyername;
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



	public int getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "buyerresponse [buyerid=" + buyerid + ", buyername=" + buyername + ", email=" + email + ", password="
				+ password + ", phoneNo=" + phoneNo + ", address=" + address + ", date=" + date + "]";
	}
	
	

}

