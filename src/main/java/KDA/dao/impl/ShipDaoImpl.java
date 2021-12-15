package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KDA.connection.DBConnect;
import KDA.dao.ShipDao;
import KDA.model.ShipModel;

public class ShipDaoImpl implements ShipDao{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<ShipModel> listAllCity() {
		List<ShipModel> list=new ArrayList<ShipModel>();
		String sql="select * from Ship";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new ShipModel(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	@Override
	public ShipModel getCityByID(String id) {
		String sql="select * from Ship where ShipID=?";
		try {
			conn =new DBConnect().getConnection();
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, id);
    		rs=ps.executeQuery();
    		while (rs.next()) {
    			return new ShipModel(rs.getInt(1),rs.getString(2),rs.getInt(3));
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
