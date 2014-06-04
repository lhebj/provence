package com.provence.service.brand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.provence.pojo.Brand;
import com.provence.pojo.BrandDetail;
import com.provence.web.dto.BrandDTO;
import com.provence.web.dto.BrandDetailDTO;
import com.provence.web.dto.BrandLogoDTO;

public interface IBrandService {


	public void saveOrUpdateBrand(Brand brand);
	
	public Brand findBrandById(Long id);
	
	public void deleteBrand(Long id);
	
	public  Map<String, Object> fullDeleteBrandById(Long id, HttpServletRequest request);
	
	public List<BrandDTO> getBrandDTOList (int start, int limit);
	
	public List<BrandLogoDTO> getBrandLogoDTOList (int start, int limit);
	
	public void saveOrUpdateBrandDetail(BrandDetail bd);
	
	public BrandDetail findBrandDetailByBrand(Brand brand);
	
	public void deleteBrandDetail(BrandDetail bd);
	
	public List<BrandDetailDTO> getBrandDetailDTOList (int start, int limit);
	
	public List<BrandDTO> getFullBrandDTOList();
}
