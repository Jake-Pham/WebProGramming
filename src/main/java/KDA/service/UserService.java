package KDA.service;

import java.util.List;

import KDA.model.UserModel;

public interface UserService {
	List<UserModel> getAlluser();
	UserModel get(int id);
	void edit(UserModel user);
}
