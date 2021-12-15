package KDA.service.impl;

import KDA.dao.RegisterDao;
import KDA.dao.impl.RegisterDaoImpl;
import KDA.model.UserModel;
import KDA.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	RegisterDao registerDao = new RegisterDaoImpl();

	@Override
	public void register(UserModel account) {
		// TODO Auto-generated method stub
		registerDao.register(account);
	}

}
