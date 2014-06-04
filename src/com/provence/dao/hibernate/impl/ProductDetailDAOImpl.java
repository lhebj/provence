package com.provence.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.provence.dao.IBasicHibernateDAO;
import com.provence.dao.IProductDetailDAO;
import com.provence.pojo.ProductDetail;

@Repository("productDetailDAO")
public class ProductDetailDAOImpl implements IProductDetailDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateProductDetail(ProductDetail bd) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(bd);
	}

	@Override
	public ProductDetail findProductDetailByProductId(Long productId) {
		// TODO Auto-generated method stub
		String hql = " from ProductDetail where product.idPrd=:idPrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idPrd", productId);
		List<ProductDetail> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void deleteProductDetail(ProductDetail bd) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(bd);
	}

	@Override
	public List<ProductDetail> getProductDetailList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from ProductDetail";
		return basicHibernateDao.getResultList(start, limit, hql);
	}

}
