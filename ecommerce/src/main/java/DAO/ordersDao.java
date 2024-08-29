package DAO;

import java.util.List;

import DTO.ordersrequest;
import DTO.ordersresponse;

public interface ordersDao {
	
	public boolean createOrder(ordersrequest ordersrequest);
	public boolean updateOrder(ordersrequest ordersrequest, int orderId);
	public boolean deleteOrderById(int orderId);
	public ordersresponse getOrderById(int orderId);
	public List<ordersresponse> getAllOrders();


}
