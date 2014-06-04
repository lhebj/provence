package com.provence.controller.brand;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Brand;
import com.provence.pojo.BrandDetail;
import com.provence.pojo.Category;
import com.provence.service.banner.IBannerService;
import com.provence.service.brand.IBrandService;
import com.provence.service.category.ICategoryService;
import com.provence.service.product.IProductService;
import com.provence.web.dto.BrandDetailDTO;
import com.provence.web.dto.BrandLogoDTO;
import com.provence.web.dto.ProductDTO;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.PageUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.StringUtil;

@Controller
@RequestMapping("/brand.do")
public class BrandController {	
	

	@Resource(name = "brandService")
	private IBrandService brandService;
	
	@Resource(name = "productService")
	private IProductService productService; 
	
	@Resource(name = "categoryService")
	private ICategoryService categoryService; 
	
	@Resource
	private IBannerService bannerService;
	
	@RequestMapping(params = "action=list")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		//左侧导航品牌
		
		model.addAttribute("brandDTOList", brandService.getFullBrandDTOList());
		
		//品牌logo
		List<BrandLogoDTO> brandLogoDTOList = brandService.getBrandLogoDTOList(0, Integer.MAX_VALUE);
		model.addAttribute("brandLogoDTOList", brandLogoDTOList);
		
		//banner
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		return "brandList";
	}
	
	@RequestMapping(params = "action=detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		try{
			if(id==0){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			}
			
			Brand brand = brandService.findBrandById(id);
			if(brand == null){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			}
			
			BrandDetail brandDetail = brandService.findBrandDetailByBrand(brand);		
			if(brandDetail == null){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			}
			BrandDetailDTO brandDetailDTO = brandDetail.toDTO();
			model.addAttribute("brandDetailDTO", brandDetailDTO);	
			model.addAttribute("currentBrandId", brandDetailDTO.getIdBrd());
			
			//SEO
			String seoDescription = StringUtil.html2Text(brandDetailDTO.getIntroductionBrdd());
			seoDescription = seoDescription.trim().replaceAll("[\\t\\n\\r]", "").replaceAll("&nbsp;", "").replaceAll("\\s*", ""); ;
			model.addAttribute("seoDescription", seoDescription.trim());
//			System.out.println(seoDescription.trim());
			
			//左侧导航品牌	
			model.addAttribute("brandDTOList",  brandService.getFullBrandDTOList());	
			
			//分类及产品
			int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
			int pageSize = ParamUtils.getIntParameter(request, "pageSize", 6);
			Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);
			if(categoryId != 0){
				Category category = categoryService.findCategoryById(categoryId);
				if(category != null && category.getBrand().getIdBrd() == id){
					model.addAttribute("categoryDTO", category.toDTO());
					model.addAttribute("currentCategoryId", categoryId);
				}
			}
			int totalCount = 0;
			List<ProductDTO> productDTOList = null;
			PageUtil pageUtil = null;
			String pageLink = null;
			if(categoryId != 0) {
				totalCount = productService.getProductTotalCountByCategoryId(categoryId);
				pageUtil = new PageUtil(totalCount, curPage, pageSize);
				productDTOList = productService.getProductDTOListByCategoryId(pageUtil.getStart(), pageUtil.getLimit(), categoryId);
				pageLink = "brand.do?action=detail&id="+id + "&categoryId="+categoryId;
			}else {
				totalCount = productService.getProductTotalCountByBrandId(id);
				pageUtil = new PageUtil(totalCount, curPage, pageSize);
				productDTOList = productService.getProductDTOListByBrandId(pageUtil.getStart(), pageUtil.getLimit(), id);
				pageLink = "brand.do?action=detail&id="+id;
			}
			
			model.addAttribute("productDTOList", productDTOList);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pageutil", pageUtil.getToolBar(pageLink, request));
			
			//banner
			model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "brandDetail";
	}
}
