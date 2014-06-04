package com.provence.dao;

import java.util.List;

import com.provence.pojo.Product;

public interface IProductDAO {

	public void saveOrUpdateProduct(Product product);
	
	public Product findProductById(Long id);
	
	public void deleteProduct(Product product);
	
	public void deleteProductById(Long id);
	
	public List<Product> getProductListByCategoryId (int start, int limit, long categoryId);
	
	public int getProductTotalCountByCategoryId(long categoryId);
	
	public List<Product> getProductListByBrandId (int start, int limit, long brandId); 
	
	public int getProductTotalCountByBrandId(long brandId);
	
	public List<Product> getProductListByName (int start, int limit, String name); 
	
	public int getProductTotalCountByName(String name); 
}
