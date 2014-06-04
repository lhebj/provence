package com.provence.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.provence.pojo.Product;
import com.provence.pojo.ProductDetail;
import com.provence.web.dto.ProductDTO;

public interface IProductService {

public void saveOrUpdateProduct(Product product);
	
	public Product findProductById(Long id);
	
	public void deleteProduct(Product product);
	
	public void deleteProductById(Long id);
	
	public  Map<String, Object> deleteFullProductById(Long id,HttpServletRequest request);
	
	public List<ProductDTO> getProductDTOListByCategoryId (int start, int limit, long categoryId);
	
	public int getProductTotalCountByCategoryId(long categoryId);
	
	public int getProductTotalCountByBrandId(long brandId);
	
	public List<ProductDTO> getProductDTOListByBrandId (int start, int limit, long brandId); 
	
	public int getProductTotalCountByName(String name);
	
	public List<ProductDTO> getProductDTOListByName (int start, int limit, String name); 
	
	
	public void saveOrUpdateProductDetail(ProductDetail bd);
	
	public ProductDetail findProductDetailByProductId(Long productId);
	
	public void deleteProductDetail(ProductDetail bd);
	
	public List<ProductDetail> getProductDetailList (int start, int limit);
}
