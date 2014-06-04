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
import com.provence.pojo.Category;
import com.provence.pojo.Content;
import com.provence.pojo.Product;
import com.provence.pojo.ProductDetail;
import com.provence.service.brand.IBrandService;
import com.provence.service.category.ICategoryService;
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
@RequestMapping("/productAdmin.do")
public class ProductAdminController {
	
	
	@Resource(name = "brandService")
	private IBrandService brandService;
	
	@Resource(name = "categoryService")
	private ICategoryService categoryService;
	
	@Resource(name = "productService")
	private IProductService productService;
	
	@Resource(name = "contentService")
	private IContentService contentService;
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Long idbrdPrd = ParamUtils.getLongParameter(request, "idbrdPrd", 0);
		Long idcatPrd = ParamUtils.getLongParameter(request, "idcatPrd", 0);
		String namePrd = ParamUtils.getParameter(request, "namePrd");
		String descriptionPrd = ParamUtils.getParameter(request, "descriptionPrd");
		String ingredientsPrd = ParamUtils.getParameter(request, "ingredientsPrd");
		String instructionsPrd = ParamUtils.getParameter(request, "instructionsPrd");
		
		try {
			Map<String, Map<String, Object>> fileMap = UploadFileUtil.uploadMultiFile(request, Content.SRC_CON_PRODUCT, ProvenceConfig.MAX_UPLOADSIZE);
			
			Map<String, Object> coverMap = fileMap.get(Product.FILE_COVER);
			boolean isSuccess = (Boolean) coverMap.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" +  (String) coverMap.get(UploadFileUtil.MESSAGE);
			}
			Map<String, Object> bigPicMap = fileMap.get(Product.FILE_BIGPIC);
			isSuccess = (Boolean) bigPicMap.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" +  (String) bigPicMap.get(UploadFileUtil.MESSAGE);
			}
			
			Map<String, Object> smallPic1Map = fileMap.get(Product.FILE_SMALLPIC1);
			isSuccess = (Boolean) smallPic1Map.get(UploadFileUtil.SUCCESS);
//			if (id == 0 && !isSuccess) {
//				return "redirect:/error.do?action=1&message=" +  (String) smallPic1Map.get(UploadFileUtil.MESSAGE);
//			}
			
			Map<String, Object> smallPic2Map = fileMap.get(Product.FILE_SMALLPIC2);
			isSuccess = (Boolean) smallPic2Map.get(UploadFileUtil.SUCCESS);
//			if (id == 0 && !isSuccess) {
//				return "redirect:/error.do?action=1&message=" +  (String) smallPic2Map.get(UploadFileUtil.MESSAGE);
//			}
			
			Map<String, Object> smallPic3Map = fileMap.get(Product.FILE_SMALLPIC3);
			isSuccess = (Boolean) smallPic3Map.get(UploadFileUtil.SUCCESS);
//			if (id == 0 && !isSuccess) {
//				return "redirect:/error.do?action=1&message=" +  (String) smallPic3Map.get(UploadFileUtil.MESSAGE);
//			}
			
			Brand brand = null;
			if( idbrdPrd !=0 ){
				brand = brandService.findBrandById(idbrdPrd);
			}
			if(brand == null){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
			Category category = null;
			if (idcatPrd != 0) {
				category = categoryService.findCategoryById(idcatPrd);
			}
			if (category == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
			Product product = null;
			ProductDetail pd = null;
			if(id != 0){
				product = productService.findProductById(id);
				pd = productService.findProductDetailByProductId(id);
			}
			
			if (product == null) {
				product = new Product();
				pd = new ProductDetail();
			}
			product.setBrand(brand);
			product.setCategory(category);			
			product.setNamePrd(namePrd);
			
			if (coverMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) coverMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				product.setCover(content);
			}
			
			pd.setDescriptionPrd(StringUtil.filterWordFormatAndSomeHTML(descriptionPrd));
			pd.setIngredientsPrd(StringUtil.filterWordFormatAndSomeHTML(ingredientsPrd));
			pd.setInstructionsPrd(StringUtil.filterWordFormatAndSomeHTML(instructionsPrd));
			pd.setDateCreatePrd(new Date());
						
			if (bigPicMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) bigPicMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setBigPic(content);
			}
			
			if (smallPic1Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic1Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setSmallPic1(content);
			}
			
			if (smallPic2Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic2Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setSmallPic2(content);
			}
			
			if (smallPic3Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic3Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setSmallPic3(content);
			}
	
			productService.saveOrUpdateProduct(product);
			pd.setProduct(product);
			productService.saveOrUpdateProductDetail(pd);
	
			LogUtil.log.info(WebUtil.getUserId(request) + " saves product id " + brand.getIdBrd());
			
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageProduct&categoryId=" + idcatPrd;
	}
	
	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);


		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			Map<String, Object> map = productService.deleteFullProductById(id, request);
			if((Boolean)map.get(CommonStaticConst.RETURN_SUCCESS) == false){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageProduct&categoryId="+categoryId;
	}
}
