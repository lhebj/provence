package com.provence.dao;

import java.util.List;

import com.provence.pojo.Category;

public interface ICategoryDAO {

	
	public void saveOrUpdateCategory(Category category);
	
	public Category findCategoryById(Long id);
	
	public void deleteCategory(Long id);
	
	public List<Category> getCategoryListByBrandId (Long brandId); 
}
