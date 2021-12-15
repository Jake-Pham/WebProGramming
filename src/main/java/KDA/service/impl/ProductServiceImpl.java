package KDA.service.impl;

import java.io.File;
import java.util.List;

import KDA.dao.ProductDao;
import KDA.dao.impl.CategoryDaoImpl;
import KDA.dao.impl.ProductDaoImpl;
import KDA.model.CategoryModel;
import KDA.model.ProductModel;
import KDA.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao productDao = new ProductDaoImpl();
	@Override
	public void insert(ProductModel product) {
		productDao.insert(product);
		
	}

	@Override
	public void edit(ProductModel newProduct) {
		ProductModel oldProduct = productDao.get(newProduct.getId());
		oldProduct.setName(newProduct.getName());
		oldProduct.setDescription(newProduct.getDescription());
		oldProduct.setPrice(newProduct.getPrice());
		if(newProduct.getImage() != null) {
			//Xóa ảnh cũ
			String fileName = oldProduct.getImage();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category" + fileName);
			if(file.exists()) {
				file.delete();
			}
			oldProduct.setImage(newProduct.getImage());
		}
		oldProduct.setSellerID(newProduct.getSellerID());
		oldProduct.setCategoryID(newProduct.getCategoryID());
		oldProduct.setAmount(newProduct.getAmount());
		productDao.edit(oldProduct);
		
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
		
	}

	@Override
	public ProductModel get(int id) {
		
		return productDao.get(id);
	}

	@Override
	public List<ProductModel> getAllproduct() {
		
		return productDao.getAllproduct();
	}
	public List<ProductModel> get5NewProduct() {
		// TODO Auto-generated method stub
		return productDao.get5NewProduct();
	}
	@Override
	public List<ProductModel> getTop3Product() {
		// TODO Auto-generated method stub
		return productDao.getTop3Product();
	}
	@Override
	public List<ProductModel> getFirst2Product() {
		// TODO Auto-generated method stub
		return productDao.getFirst2Product();
	}
	@Override
	public List<ProductModel> getAllProductByCID(String cid) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByCID(cid);
	}
	@Override
	public ProductModel getProductByID(String id) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(id);
	}
	@Override
	public List<ProductModel> searchByProductName(String txtsearch) {
		// TODO Auto-generated method stub
		return productDao.searchByProductName(txtsearch);
	}

	@Override
	public List<ProductModel> getMyproduct(int sellID) {
		// TODO Auto-generated method stub
		return productDao.getMyproduct(sellID);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return productDao.countAll();
	}

	@Override
	public int countProductByCID(String cid) {
		// TODO Auto-generated method stub
		return productDao.countProductByCID(cid);
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProduct(index);
	}

	@Override
	public List<ProductModel> pagingProductByCID(int index, String cid) {
		// TODO Auto-generated method stub
		return productDao.pagingProductByCID(index, cid);
	}

}
