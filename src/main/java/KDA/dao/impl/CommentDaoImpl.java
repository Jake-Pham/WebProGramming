package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KDA.connection.DBConnect;
import KDA.dao.CommentDao;
import KDA.model.CommentModel;
import KDA.model.ProductModel;

public class CommentDaoImpl implements CommentDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CommentModel comment) {
		String sql = "insert into Comment(UserID, ProductID, Content) values (?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getUid());
			ps.setInt(2, comment.getPid());
			ps.setString(3, comment.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CommentModel> getbyPid(String pid) {
		List<CommentModel> list = new ArrayList<CommentModel>();
		String sql = "select CommentID, Comment.UserID, ProductID, FirstName, LastName, Content from Comment\r\n" + 
				"join users on Comment.UserID = Users.UserID\r\n" + 
				"where ProductID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CommentModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
