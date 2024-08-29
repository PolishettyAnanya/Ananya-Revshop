package service;

import DAO.buyerDAOClass;
import DTO.buyerrequest;
import DTO.buyerresponse;

public class buyerservice {
		private final buyerDAOClass buyerDao;
		
		public buyerservice() {
			buyerDao= new buyerDAOClass();
			
		}
		
		public boolean createbuyer(buyerrequest buyerrequest) {
		return buyerDao.createbuyer(buyerrequest);
			
		}
		public buyerresponse getBuyerById(int buyerId) {
			return buyerDao.getBuyerById(buyerId);
			
		}
		public boolean updatebuyer(buyerrequest buyerrequest, int buyerId) {
			return buyerDao.updatebuyer(buyerrequest, buyerId);
			
		}

		
		public static void main(String[] args) {
			buyerservice bs=new buyerservice();
			//System.out.println(bs.createbuyer(new buyerrequest("vyshu", "v@gmail.com", "12345", 987685,"khammam","22/2/2020")));
		
			//System.out.println(bs.getBuyerById(1));
			System.out.println(bs.updatebuyer(new buyerrequest("Soumya", "s@gmail.com", "12345", 996632255, "hyderabad","23/12/2222"), 1));
		}


	}

