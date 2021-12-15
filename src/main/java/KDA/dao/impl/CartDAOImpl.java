package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import KDA.connection.DBConnect;
import KDA.dao.CartDAO;
import KDA.model.CartModel;

public class CartDAOImpl implements CartDAO{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void insert(CartModel cart) {
		String sql = "insert into Cart (ProductName, ImageLink, UnitPrice, Quantity, Price, BillID) values (?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cart.getName());
			ps.setString(2, cart.getImage());
			ps.setInt(3, cart.getUnitPrice());
			ps.setInt(4, cart.getQuantity());
			ps.setInt(5, cart.getPrice());
			ps.setInt(6, cart.getBillID());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
