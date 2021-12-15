package KDA.service;

import java.util.List;

import KDA.model.CategoryModel;

public interface CategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	List<CategoryModel> getAllcategory();
}
