package com.provence.controller.brand;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Brand;
import com.provence.pojo.BrandDetail;
import com.provence.pojo.Content;
import com.provence.service.brand.IBrandService;
import com.provence.service.content.IContentService;
import com.provence.service.product.IProductService;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.StringUtil;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/brandAdmin.do")
public class BrandAdminController {

	
	@Resource(name = "brandService")
	private IBrandService brandService;
	
	
	@Resource(name = "productService")
	private IProductService productService;
	
	@Resource(name = "contentService")
	private IContentService contentService;
	
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String nameBrd = ParamUtils.getParameter(request, "nameBrd");
		String introductionBrdd = ParamUtils.getParameter(request, "introductionBrdd");
		String newproductnameBrdd = ParamUtils.getParameter(request, "newproductnameBrdd");
		
		try {
			Map<String, Map<String, Object>> fileMap = UploadFileUtil.uploadMultiFile(request, Content.SRC_CON_BRAND, ProvenceConfig.MAX_UPLOADSIZE);
			Map<String, Object> logoMap = fileMap.get(BrandDetail.FILE_LOGO);
			boolean isSuccess = (Boolean) logoMap.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" +  (String) logoMap.get(UploadFileUtil.MESSAGE);
			}
			Map<String, Object> newProductPic1Map = fileMap.get(BrandDetail.FILE_NEWPRODUCTPIC1);
			isSuccess = (Boolean) newProductPic1Map.get(UploadFileUtil.SUCCESS);
//			if (id == 0 && !isSuccess) {
//				return "redirect:/error.do?action=1&message=" +  (String) newProductPic1Map.get(UploadFileUtil.MESSAGE);
//			}
			Map<String, Object> newProductPic2Map = fileMap.get(BrandDetail.FILE_NEWPRODUCTPIC1);
			isSuccess = (Boolean) newProductPic2Map.get(UploadFileUtil.SUCCESS);
//			if (id == 0 && !isSuccess) {
//				return "redirect:/error.do?action=1&message=" +  (String) newProductPic2Map.get(UploadFileUtil.MESSAGE);
//			}
			
			Brand brand = null;
			BrandDetail brandDetail = null;
			if( id !=0 ){
				brand = brandService.findBrandById(id);
				brandDetail = brandService.findBrandDetailByBrand(brand);
			}
			if(brand == null){
				brand = new Brand();
				brandDetail = new BrandDetail();
			}
			brand.setNameBrd(nameBrd);
			
			if (logoMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) logoMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				brandDetail.setLogo(content);
			}
			
			if (newProductPic1Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) newProductPic1Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				brandDetail.setNewProductPic1(content);
			}
			
			if (newProductPic2Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) newProductPic2Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				brandDetail.setNewProductPic2(content);
			}
			brandDetail.setBrand(brand);
			brandDetail.setIntroductionBrdd(StringUtil.filterWordFormatAndSomeHTML(introductionBrdd));
			brandDetail.setNewproductnameBrdd(newproductnameBrdd);
			brandDetail.setDateCreateBrdd(new Date());
			
			brandService.saveOrUpdateBrand(brand);
			brandService.saveOrUpdateBrandDetail(brandDetail);
	
			LogUtil.log.info(WebUtil.getUserId(request) + " saves brand id " + brand.getIdBrd());
			
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageBrand";
	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		
		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Map<String, Object> map = brandService.fullDeleteBrandById(id, request);
			if((Boolean)map.get(CommonStaticConst.RETURN_SUCCESS) == false){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes brand id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageBrand";
	}
}
