package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import KDA.connection.DBConnect;
import KDA.dao.RegisterDao;
import KDA.model.UserModel;



public class RegisterDaoImpl implements RegisterDao{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public void register(UserModel account) {
		String sql="insert into Users(FirstName,LastName,Email,Password,Address,isAdmin,isSeller) values (?,?,?,?,?,?,?)";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);		
			ps.setString(1, account.getFname());
			ps.setString(2, account.getLname());
			ps.setString(3, account.getEmail());
			ps.setString(4, account.getPass());
			ps.setString(5, account.getAdrs());
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
