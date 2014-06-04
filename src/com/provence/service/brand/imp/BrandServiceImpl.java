package com.provence.service.brand.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.provence.dao.IBrandDAO;
import com.provence.dao.IBrandDetailDAO;
import com.provence.pojo.Brand;
import com.provence.pojo.BrandDetail;
import com.provence.service.brand.IBrandService;
import com.provence.service.category.ICategoryService;
import com.provence.web.dto.BrandDTO;
import com.provence.web.dto.BrandDetailDTO;
import com.provence.web.dto.BrandLogoDTO;
import com.provence.web.dto.CategoryDTO;
import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.LocalizationUtil;


@Service(value = "brandService")
public class BrandServiceImpl implements IBrandService {

	@Resource
	private IBrandDAO brandDAO;
	@Resource
	private IBrandDetailDAO brandDetailDAO;
	
	@Resource
	private ICategoryService categoryService;
	
	@Override
	public void saveOrUpdateBrand(Brand brand) {
		// TODO Auto-generated method stub
		brandDAO.saveOrUpdateBrand(brand);
	}

	@Override
	public Brand findBrandById(Long id) {
		// TODO Auto-generated method stub
		return brandDAO.findBrandById(id);
	}

	@Override
	public void deleteBrand(Long id) {
		// TODO Auto-generated method stub
		brandDAO.deleteBrand(id);
	}
	
	public  Map<String, Object> fullDeleteBrandById(Long id, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		Brand brand = findBrandById(id);
		if (brand == null) {
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}
		BrandDetail brandDetail = this.findBrandDetailByBrand(brand);
		if(brandDetail == null){
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}
		
		List<CategoryDTO> list = categoryService.getCategoryListByBrandId(id);
		for(CategoryDTO dto: list){
			map = categoryService.fullDeleteCategoryById(dto.getIdCat(), request);
		}
		this.deleteBrandDetail(brandDetail);
		this.deleteBrand(id);
		map.put(CommonStaticConst.RETURN_MESSAGE, "");
		map.put(CommonStaticConst.RETURN_SUCCESS, true);
		return map;
	}

	@Override
	public List<BrandDTO> getBrandDTOList(int start, int limit) {
		// TODO Auto-generated method stub
		List<Brand> list = brandDAO.getBrandList(start, limit);
		List<BrandDTO> dtoList = new ArrayList<BrandDTO>();
		for(Brand brand: list){
			dtoList.add(brand.toDTO());
		}
		return dtoList;
	}
	
	public List<BrandLogoDTO> getBrandLogoDTOList (int start, int limit){
		List<BrandDetail> list = brandDetailDAO.getBrandDetailList(start, limit);
		List<BrandLogoDTO> dtoList = new ArrayList<BrandLogoDTO>();
		for(BrandDetail brandDetail: list){
			dtoList.add(brandDetail.toBrandLogoDTO());
		}
		return dtoList;
	}

	@Override
	public void saveOrUpdateBrandDetail(BrandDetail bd){
		brandDetailDAO.saveOrUpdateBrandDetail(bd);
	}

	@Override
	public BrandDetail findBrandDetailByBrand(Brand brand){
		return brandDetailDAO.findBrandDetailByBrand(brand);
	}

	@Override
	public void deleteBrandDetail(BrandDetail bd){
		brandDetailDAO.deleteBrandDetail(bd);
	}

	@Override
	public List<BrandDetailDTO> getBrandDetailDTOList (int start, int limit){
		List<BrandDetail> list = brandDetailDAO.getBrandDetailList(start, limit);
		List<BrandDetailDTO> dtoList = new ArrayList<BrandDetailDTO>();
		for(BrandDetail brandDetail: list){
			dtoList.add(brandDetail.toDTO());
		}
		return dtoList;
	}
	
	
	public List<BrandDTO> getFullBrandDTOList(){
		List<BrandDTO> brandDTOList = getBrandDTOList(0, Integer.MAX_VALUE);
		for(BrandDTO brandDTO : brandDTOList) {
			//优化TODO
			brandDTO.setCategoryDTOList(categoryService.getCategoryListByBrandId(brandDTO.getIdBrd()));
		}
		return brandDTOList;
	}

}
