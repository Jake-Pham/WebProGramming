package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KDA.connection.DBConnect;
import KDA.dao.UserDao;
import KDA.model.UserModel;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<UserModel> getAlluser() {
		// Khai báo List để lưu danh sách sp
				List<UserModel> list = new ArrayList<UserModel>();
				// Khai báo chuỗi truy vấn
				String sql = "select * from Users";
				try {
					// mở kết nối database
					conn = new DBConnect().getConnection();
					// Ném câu query qua sql
					ps = conn.prepareStatement(sql);
					// chạy query và nhận kết quả
					rs = ps.executeQuery();
					// lấy ResultSet đổ vào List
					while (rs.next()) {
						list.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
								rs.getString(6), rs.getInt(7), rs.getInt(8)));
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
	}

	@Override
	public UserModel get(int id) {
		String sql = "select * from Users where UserId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setUid(rs.getInt("UserId"));
				user.setFname(rs.getString("FirstName"));
				user.setLname(rs.getString("LastName"));
				user.setEmail(rs.getString("Email"));
				user.setPass(rs.getString("Password"));
				user.setAdrs(rs.getString("Address"));
				user.setIsAdmin(rs.getInt("IsAdmin"));
				user.setIsSell((rs.getInt("IsSeller")));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void edit(UserModel user) {
		String sql = "update Users set FirstName = ?, LastName = ?, Email  = ?, Password = ?, Address = ?, IsAdmin = ?, IsSeller = ? where UserID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPass());
			ps.setString(5, user.getAdrs());
			ps.setInt(6, user.getIsAdmin());
			ps.setInt(7, user.getIsSell());
			ps.setInt(8, user.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
