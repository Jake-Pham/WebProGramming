package KDA.dao;

import KDA.model.UserModel;

public interface LoginDao {
	UserModel login(String email, String pass);
}
