package com.provence.dao;

import java.util.List;

import com.provence.pojo.ProductDetail;

public interface IProductDetailDAO {
	public void saveOrUpdateProductDetail(ProductDetail bd);
	
	public ProductDetail findProductDetailByProductId(Long productId);
	
	public void deleteProductDetail(ProductDetail bd);
	
	public List<ProductDetail> getProductDetailList (int start, int limit);
}
