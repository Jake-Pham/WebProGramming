package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import KDA.connection.DBConnect;
import KDA.dao.InformationDAO;
import KDA.model.InformationModel;

public class InformationDAOImpl implements InformationDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public InformationModel getInformation() {
		String sql = "select * from Information order by ID desc";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new InformationModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void insert(InformationModel information) {
		String sql = "insert into Information (FirstName,LastName,Email,Phone,Address,City) values (?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, information.getFname());
			ps.setString(2, information.getLname());
			ps.setString(3, information.getEmail());
			ps.setString(4, information.getPhone());
			ps.setString(5, information.getAdrs());
			ps.setString(6, information.getCity());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
