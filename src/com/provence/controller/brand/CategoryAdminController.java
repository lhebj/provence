package com.provence.controller.brand;

import java.net.URLEncoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Brand;
import com.provence.pojo.Category;
import com.provence.service.brand.IBrandService;
import com.provence.service.category.ICategoryService;
import com.provence.web.util.CommonStaticConst;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/categoryAdmin.do")
public class CategoryAdminController {

	@Resource(name = "categoryService")
	private ICategoryService categoryService;

	@Resource(name = "brandService")
	private IBrandService brandService;

	/**
	 * 通过品牌id获取分类
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return void
	 */
	@RequestMapping(params = "action=getByBrandId")
	public void getByBrandId(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		JSONHelperUtil.outputDTOToJSON(categoryService.getCategoryListByBrandId(brandId), response);
		return;
	}

	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String nameCat = ParamUtils.getParameter(request, "nameCat");

		try {
			if (brandId == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
			if (nameCat == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Brand brand = brandService.findBrandById(brandId);
			if (brand == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Category category = null;
			if (id != 0) {
				category = categoryService.findCategoryById(id);
			}
			if (category == null) {
				category = new Category();
			}
			category.setBrand(brand);
			category.setNameCat(nameCat);
			categoryService.saveOrUpdateCategory(category);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves category id " + brand.getIdBrd());

		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}

		return "redirect:/admin.do?action=manageCategory&brandId=" + brandId;
	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		
		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			if(brandId==0){
				Category category = categoryService.findCategoryById(id);
				brandId = category.getBrand().getIdBrd();
			}

			Map<String, Object> map = categoryService.fullDeleteCategoryById(id, request);
			if((Boolean)map.get(CommonStaticConst.RETURN_SUCCESS) == false){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes category id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageCategory&brandId=" + brandId;
	}
}
