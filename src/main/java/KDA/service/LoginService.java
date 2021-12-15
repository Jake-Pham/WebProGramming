package KDA.service;

import KDA.model.UserModel;

public interface LoginService {
	UserModel login(String email, String pass);
}
