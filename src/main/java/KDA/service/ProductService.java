package KDA.service;

import java.util.List;

import KDA.model.ProductModel;


public interface ProductService {
	void insert(ProductModel product);
	void edit(ProductModel product);
	void delete(int id);
	ProductModel get(int id);
	List<ProductModel> getAllproduct();
	List<ProductModel> get5NewProduct();
	List<ProductModel> getTop3Product();
	List<ProductModel> getFirst2Product();
	List<ProductModel> getAllProductByCID(String cid);
	ProductModel getProductByID(String id);
	List<ProductModel> searchByProductName(String txtsearch);
	List<ProductModel> getMyproduct(int sellID);
	int countAll();
	int countProductByCID(String cid);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> pagingProductByCID(int index,String cid);
}
