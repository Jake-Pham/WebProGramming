package KDA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import KDA.connection.DBConnect;
import KDA.dao.ProductDao;
import KDA.model.ProductModel;

public class ProductDaoImpl implements ProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(ProductModel product) {
		String sql = "insert into Product(ProductName, Description, Price, ImageLink, CategoryID, SellerID, Amount) values (?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCategoryID());
			ps.setInt(6, product.getSellerID());
			ps.setInt(7, product.getAmount());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(ProductModel product) {
		String sql = "update Product set ProductName = ?, Description = ?, Price  = ?, ImageLink = ?, CategoryID = ?, SellerID = ?, Amount = ? where ProductID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCategoryID());
			ps.setInt(6, product.getSellerID());
			ps.setInt(7, product.getAmount());
			ps.setInt(8, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "delete from product where ProductId = ?";
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
	public ProductModel get(int id) {
		String sql = "select * from product where ProductId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("ProductId"));
				product.setName(rs.getString("ProductName"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getInt("Price"));
				product.setImage(rs.getString("ImageLink"));
				product.setCategoryID(rs.getInt("CategoryID"));
				product.setSellerID(rs.getInt("SellerID"));
				product.setAmount(rs.getInt("Amount"));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductModel> getAllproduct() {
		// Khai báo List để lưu danh sách sp
		List<ProductModel> list = new ArrayList<ProductModel>();
		// Khai báo chuỗi truy vấn
		String sql = "select * from Product";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> get5NewProduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product order by ProductID asc limit 5";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<ProductModel> getTop3Product() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select  * from Product order by Amount desc limit 3";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getFirst2Product() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> getAllProductByCID(String cid) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where CategoryID= ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ProductModel getProductByID(String id) {
		String sql = "select * from Product where ProductID=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<ProductModel> searchByProductName(String txtsearch) {
		List<ProductModel> list = new ArrayList<ProductModel>();

		String sql = "select * from Product where ProductName like ?";
		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + txtsearch + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<ProductModel> getMyproduct(int sellID) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where SellerID= ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sellID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int countAll() {
		String sql = "select count(*) from Product";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int countProductByCID(String cid) {
		String sql = "select count(*) from Product where CategoryID=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product order by ProductID limit 6 offset ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<ProductModel> pagingProductByCID(int index, String cid) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where CategoryID=? order by ProductID limit 6 offset ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			ps.setInt(2, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
