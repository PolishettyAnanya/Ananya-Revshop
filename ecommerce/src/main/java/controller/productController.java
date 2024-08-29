package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.productservice;

@WebServlet("/product/*")
public class productController extends HttpServlet {
	private productservice ps; 
	

	@Override
	public void init() throws ServletException {
		System.out.println("Init");
		this.ps=new productservice();
 		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
//		session.setAttribute(LEGACY_DO_HEAD, session);e
		super.doGet(req, resp);
	}
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		super.service(arg0, arg1);
//	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	
}
