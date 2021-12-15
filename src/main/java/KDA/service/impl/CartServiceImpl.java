package KDA.service.impl;

import KDA.dao.CartDAO;
import KDA.dao.impl.CartDAOImpl;
import KDA.model.CartModel;
import KDA.service.CartService;

public class CartServiceImpl implements CartService{
	CartDAO cartDao=new CartDAOImpl();
	@Override
	public void insert(CartModel cart) {
		// TODO Auto-generated method stub
		cartDao.insert(cart);
	}

}
