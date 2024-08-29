package service;

import java.util.List;

import DAO.ordersDAOClass;
import DTO.ordersrequest;
import DTO.ordersresponse;

public class ordersservice {
	
	private final ordersDAOClass ordersDao;
	
	public ordersservice()
	{
		ordersDao = new ordersDAOClass();
	}
	
	public boolean createOrder(ordersrequest ordersrequest)
	{
		 return ordersDao.createOrder(ordersrequest);
	}

	public boolean updateOrder(ordersrequest ordersrequest, int orderid) 
	{
	     return ordersDao.updateOrder(ordersrequest, orderid);
	}

	public boolean deleteOrderById(int orderid)
	{
	     return ordersDao.deleteOrderById(orderid);
	}
	public ordersresponse getOrderById(int orderid) 
	{
	     return ordersDao.getOrderById(orderid);
	}
	public List<ordersresponse> getAllOrders()
	{
	     return ordersDao.getAllOrders();
	}
	
	
	public static void main(String[] args) {
		ordersservice o = new ordersservice();
//		System.out.println(o.createOrder(new ordersrequest(2, 300)));
//		System.out.println(o.createOrder(new ordersrequest(2, 165)));
		System.out.println(o.updateOrder(new ordersrequest(2, 56756), 5));
//		System.out.println(o.getAllOrders());
//		System.out.println(o.getOrderById(3));
//		System.out.println(o.deleteOrderById(2));
	}
	}





