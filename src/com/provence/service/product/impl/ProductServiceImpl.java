package com.provence.service.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.provence.dao.IProductDAO;
import com.provence.dao.IProductDetailDAO;
import com.provence.pojo.Content;
import com.provence.pojo.Product;
import com.provence.pojo.ProductDetail;
import com.provence.service.content.IContentService;
import com.provence.service.product.IProductService;
import com.provence.web.dto.ProductDTO;
import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.WebUtil;


@Service(value = "productService")
public class ProductServiceImpl implements IProductService {

	@Resource
	private IProductDAO productDAO;
	@Resource
	private IProductDetailDAO productDetailDAO;
	
	@Resource(name = "contentService")
	private IContentService contentService;
	
	@Override
	public void saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.saveOrUpdateProduct(product);
	}

	@Override
	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		return productDAO.findProductById(id);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(product);
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		productDAO.deleteProductById(id);
	}
	
	public  Map<String, Object> deleteFullProductById(Long id, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		if (id == 0) {
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}

		try {
			Product product = findProductById(id);
			ProductDetail pd = findProductDetailByProductId(id);
			if(product == null){
				map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
				map.put(CommonStaticConst.RETURN_SUCCESS, false);
				return map;
			}
			
			if(pd == null){
				map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
				map.put(CommonStaticConst.RETURN_SUCCESS, false);
				return map;
			}
			Content cover = product.getCover();
			if(cover != null){
				contentService.deleteContent(cover);
			}
			
			Content bigPic = pd.getBigPic();
			if(bigPic != null){
				contentService.deleteContent(bigPic);
			}
			
			Content smallPic1 = pd.getSmallPic1();
			if(smallPic1 != null){
				contentService.deleteContent(smallPic1);
			}
			
			Content smallPic2 = pd.getSmallPic2();
			if(smallPic2 != null){
				contentService.deleteContent(smallPic2);
			}
			
			Content smallPic3 = pd.getSmallPic3();
			if(smallPic3 != null){
				contentService.deleteContent(smallPic3);
			}
			
			this.deleteProduct(product);
			this.deleteProductDetail(pd);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes product id " + id);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(CommonStaticConst.RETURN_MESSAGE, "");
		map.put(CommonStaticConst.RETURN_SUCCESS, true);
		return map;
	}

	@Override
	public List<ProductDTO> getProductDTOListByCategoryId(int start, int limit, long categoryId) {
		// TODO Auto-generated method stub
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByCategoryId(start, limit, categoryId);
		for(Product product: list){
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}
	
	@Override
	public int getProductTotalCountByCategoryId(long categoryId){
		return productDAO.getProductTotalCountByCategoryId(categoryId);
	}
	
	@Override
	public int getProductTotalCountByBrandId(long brandId){
		return productDAO.getProductTotalCountByBrandId(brandId);
	}

	@Override
	public List<ProductDTO> getProductDTOListByBrandId(int start, int limit, long brandId) {
		// TODO Auto-generated method stub
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByBrandId(start, limit, brandId);
		for(Product product: list){
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}
	
	@Override
	public int getProductTotalCountByName(String name){
		return productDAO.getProductTotalCountByName(name);
	}
	
	@Override
	public List<ProductDTO> getProductDTOListByName (int start, int limit, String name){
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByName(start, limit, name);
		for(Product product: list){
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}

	
	public void saveOrUpdateProductDetail(ProductDetail bd){
		productDetailDAO.saveOrUpdateProductDetail(bd);
	}
	
	public ProductDetail findProductDetailByProductId(Long productId){
		return productDetailDAO.findProductDetailByProductId(productId);
	}
	
	public void deleteProductDetail(ProductDetail bd){
		productDetailDAO.deleteProductDetail(bd);
	}
	
	public List<ProductDetail> getProductDetailList (int start, int limit){
		return productDetailDAO.getProductDetailList(start, limit);
	}
}
