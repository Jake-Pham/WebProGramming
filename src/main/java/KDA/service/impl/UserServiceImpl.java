package KDA.service.impl;

import java.util.List;

import KDA.dao.UserDao;
import KDA.dao.impl.UserDaoImpl;
import KDA.model.UserModel;
import KDA.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public List<UserModel> getAlluser() {
		
		return userDao.getAlluser();
	}
	@Override
	public UserModel get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	@Override
	public void edit(UserModel newUser) {
		UserModel oldUser = userDao.get(newUser.getUid());
		oldUser.setFname(newUser.getFname());
		oldUser.setLname(newUser.getLname());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setPass(newUser.getPass());
		oldUser.setAdrs(newUser.getAdrs());
		oldUser.setIsAdmin(newUser.getIsAdmin());
		oldUser.setIsSell(newUser.getIsSell());		
		userDao.edit(oldUser);
		
	}

}
