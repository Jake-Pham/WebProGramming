package KDA.service.impl;

import KDA.dao.LoginDao;
import KDA.dao.impl.LoginDaoImpl;
import KDA.model.UserModel;
import KDA.service.LoginService;

public class LoginServiceImpl implements LoginService{
	LoginDao loginDao=new LoginDaoImpl();
	@Override
	public UserModel login(String email, String pass) {
		// TODO Auto-generated method stub
		return loginDao.login(email, pass);
	}

}
