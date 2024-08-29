package DTO;

public class ordersresponse {
	private int orderid;
	private int buyer_id;
	private double total_amount;
	
	public ordersresponse(int orderid,int buyer_id,double total_amount)
	{
		super();
		this.orderid=orderid;
		this.buyer_id=buyer_id;
		this.total_amount=total_amount;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "orderresponse [orderid=" + orderid + ", buyer_id=" + buyer_id + ", total_amount=" + total_amount + "]";
	}
	
}
