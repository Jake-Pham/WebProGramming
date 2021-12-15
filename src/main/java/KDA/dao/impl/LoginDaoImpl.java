package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import KDA.dao.LoginDao;
import KDA.model.UserModel;
import KDA.dao.LoginDao;
import KDA.model.UserModel;
import KDA.connection.DBConnect;

public class LoginDaoImpl implements LoginDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public UserModel login(String email, String pass) {
		String sql="select * from Users where Email=? and Password=?";
		try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            while (rs.next()) {
            	return new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
            }           
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
