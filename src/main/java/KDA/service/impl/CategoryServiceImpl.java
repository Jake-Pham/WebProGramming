package KDA.service.impl;

import java.io.File;
import java.util.List;

import KDA.dao.CategoryDao;
import KDA.dao.impl.CategoryDaoImpl;
import KDA.model.CategoryModel;
import KDA.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void edit(CategoryModel newCategory) {
		CategoryModel oldCategory = categoryDao.get(newCategory.getCate_id());
		oldCategory.setCname(newCategory.getCname());
		if(newCategory.getIcons() != null) {
			//Xóa ảnh cũ
			String fileName = oldCategory.getIcons();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category" + fileName);
			if(file.exists()) {
				file.delete();
			}
			oldCategory.setIcons(newCategory.getIcons());
		}
		categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
		
	}

	@Override
	public CategoryModel get(int id) {
		
		return categoryDao.get(id);
	}

	@Override
	public List<CategoryModel> getAllcategory() {
		
		return categoryDao.getAllcategory();
	}

}
