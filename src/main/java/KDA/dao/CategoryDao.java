package KDA.dao;

import java.util.List;

import KDA.model.CategoryModel;

public interface CategoryDao {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	List<CategoryModel> getAllcategory();
}
