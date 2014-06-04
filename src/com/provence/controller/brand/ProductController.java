package com.provence.controller.brand;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.ProductDetail;
import com.provence.service.banner.IBannerService;
import com.provence.service.brand.IBrandService;
import com.provence.service.product.IProductService;
import com.provence.web.dto.ProductDTO;
import com.provence.web.dto.ProductDetailDTO;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.PageUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.StringUtil;


@Controller
@RequestMapping("/product.do")
public class ProductController {
	
	@Resource(name = "brandService")
	private IBrandService brandService;
	
	@Resource(name = "productService")
	private IProductService productService; 
	
	@Resource
	private IBannerService bannerService;
	
	@RequestMapping(params = "action=detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if(id==0){
			return "redirect:/error.do?action=1&message=" + LocalizationUtil.getClientString("PageNotFound", request);
		}
		
		ProductDetail productDetail = productService.findProductDetailByProductId(id);
		if(productDetail == null){
			return "redirect:/error.do?action=1&message=" + LocalizationUtil.getClientString("PageNotFound", request);
		}		
		ProductDetailDTO productDetailDTO = productDetail.toDTO();
		model.addAttribute("productDetailDTO", productDetailDTO);		
		model.addAttribute("currentBrandId", productDetailDTO.getBrandDTO().getIdBrd());
		model.addAttribute("currentCategoryId", productDetailDTO.getCategoryDTO().getIdCat());
		model.addAttribute("brandDTOList", brandService.getFullBrandDTOList());
		
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		
		//SEO
		String seoDescription = StringUtil.html2Text(productDetailDTO.getIngredientsPrd());
		seoDescription = seoDescription.trim().replaceAll("[\\t\\n\\r]", "").replaceAll("&nbsp;", "").replaceAll("\\s*", ""); ;
		model.addAttribute("seoDescription", seoDescription.trim());
//		System.out.println(seoDescription.trim());
		return "product";
	}
	
	@RequestMapping(params = "action=list")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		String wd = ParamUtils.getParameter(request, "wd");		
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 25);
		
		if(wd == null){
			return "redirect:/error.do?action=1&message=" + LocalizationUtil.getClientString("PageNotFound", request);
		}
		int totalCount = productService.getProductTotalCountByName(wd);
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);;
		List<ProductDTO> productDTOList = productService.getProductDTOListByName(pageUtil.getStart(), pageUtil.getLimit(), wd);
		
		model.addAttribute("wd", wd);
		model.addAttribute("productDTOList", productDTOList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("product.do?action=list&wd="+wd, request));
		

		//左侧导航品牌	
		model.addAttribute("brandDTOList",  brandService.getFullBrandDTOList());	
		
		//banner
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		return "productList";
	}
}
