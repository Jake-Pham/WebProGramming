package KDA.dao;

import java.util.List;

import KDA.model.UserModel;

public interface UserDao {
	List<UserModel> getAlluser();
	UserModel get(int id);
	void edit(UserModel user);
}
