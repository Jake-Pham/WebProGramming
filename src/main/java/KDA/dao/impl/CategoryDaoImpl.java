package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KDA.connection.DBConnect;
import KDA.dao.CategoryDao;
import KDA.model.CategoryModel;

public class CategoryDaoImpl implements CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CategoryModel category) {
		String sql = "insert into Category(CategoryName, Icon) values (?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.setString(2, category.getIcons());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "update Category set CategoryName = ?, Icon = ? where CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.setString(2, category.getIcons());
			ps.setInt(3, category.getCate_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "delete from Category where CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CategoryModel get(int id) {
		String sql = "select * from category where CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCate_id(rs.getInt("CategoryID"));
				category.setCname(rs.getString("CategoryName"));
				category.setIcons(rs.getString("Icon"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryModel> getAllcategory() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from Category";
		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

}
