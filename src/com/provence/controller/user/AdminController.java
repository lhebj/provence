package com.provence.controller.user;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gdata.util.common.base.StringUtil;
import com.provence.pojo.Bio;
import com.provence.pojo.Brand;
import com.provence.pojo.BrandDetail;
import com.provence.pojo.Category;
import com.provence.pojo.ContactUs;
import com.provence.pojo.Index;
import com.provence.pojo.IntoProvence;
import com.provence.pojo.IntoProvenceStory;
import com.provence.pojo.NewsInfo;
import com.provence.pojo.NewsVideo;
import com.provence.pojo.ProductDetail;
import com.provence.pojo.User;
import com.provence.service.banner.IBannerService;
import com.provence.service.bio.IBioService;
import com.provence.service.brand.IBrandService;
import com.provence.service.category.ICategoryService;
import com.provence.service.contactus.IContactUsService;
import com.provence.service.index.IIndexService;
import com.provence.service.intoprovence.IIntoProvenceService;
import com.provence.service.intoprovence.IIntoProvenceStoryService;
import com.provence.service.message.IMessageService;
import com.provence.service.news.INewsInfoService;
import com.provence.service.news.INewsVideoService;
import com.provence.service.product.IProductService;
import com.provence.service.user.IUserService;
import com.provence.web.dto.BannerDTO;
import com.provence.web.dto.BioFullDTO;
import com.provence.web.dto.BrandLogoDTO;
import com.provence.web.dto.ContactUsDTO;
import com.provence.web.dto.IndexDTO;
import com.provence.web.dto.IntoProvenceDTO;
import com.provence.web.dto.MessageDTO;
import com.provence.web.dto.NewsInfoDTO;
import com.provence.web.dto.NewsVideoDTO;
import com.provence.web.dto.ProductDTO;
import com.provence.web.dto.UserDTO;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.PageUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/admin.do")
public class AdminController {

	@Resource(name = "indexService")
	private IIndexService indexService;

	@Resource(name = "bannerService")
	private IBannerService bannerService;

	@Resource(name = "newsInfoService")
	private INewsInfoService newsInfoService;

	@Resource(name = "newsVideoService")
	private INewsVideoService newsVideoService;

	@Resource(name = "bioService")
	private IBioService bioService;

	@Resource(name = "intoProvenceService")
	private IIntoProvenceService intoProvenceService;

	@Resource(name = "intoProvenceStoryService")
	private IIntoProvenceStoryService intoProvenceStoryService;

	@Resource(name = "userService")
	private IUserService userService;

	@Resource(name = "brandService")
	private IBrandService brandService;

	@Resource(name = "productService")
	private IProductService productService;

	@Resource(name = "categoryService")
	private ICategoryService categoryService;

	@Resource(name = "messageService")
	private IMessageService messageService;

	@Resource(name = "contactUsService")
	private IContactUsService contactUsService;

	@RequestMapping(params = "action=home")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/home";
	}

	@RequestMapping(params = "action=manageIndex")
	public String manageIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Index> list = indexService.getRandomIndexList(4, Index.TYPE_PIC);
		List<IndexDTO> dtoList = new ArrayList<IndexDTO>();
		for (Index index : list) {
			dtoList.add(index.toDTO());
		}
		list = indexService.getRandomIndexList(1, Index.TYPE_VIDEO);
		for (Index index : list) {
			dtoList.add(index.toDTO());
		}
		model.addAttribute("indexDtoList", dtoList);
		return "admin/index/manageIndex";
	}

	@RequestMapping(params = "action=postIndex")
	public String postIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/index/postIndex";
	}

	@RequestMapping(params = "action=manageUsers")
	public String manageUsers(HttpServletRequest request, HttpServletResponse response, Model model) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = userService.getUserTotalCount();
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<User> userList = userService.getUserList(pageUtil.getStart(), pageUtil.getLimit());
		List<UserDTO> userDtoList = new ArrayList<UserDTO>();
		for (User user : userList) {
			userDtoList.add(user.toDTO());
		}
		model.addAttribute("userDtoList", userDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("admin.do?action=manageUsers", request));
		return "admin/user/manageUsers";
	}
	
	@RequestMapping(params = "action=modifyPassword")
	public String modifyPassword(HttpServletRequest request, HttpServletResponse response, Model model) {		
		return "admin/user/setPassword";
	}
	
	@RequestMapping(params = "action=setPassword")
	public String setPassword(HttpServletRequest request, HttpServletResponse response, Model model) {
		String oldPassword = ParamUtils.getParameter(request, "oldPassword");
		String newPassword = ParamUtils.getParameter(request, "newPassword");
		String newPasswordSure = ParamUtils.getParameter(request, "newPasswordSure");
		
		if(StringUtil.isEmptyOrWhitespace(oldPassword)){
			model.addAttribute("message", "当前密码不能为空");	
			return "admin/user/setPassword";
		}
		
		if(StringUtil.isEmptyOrWhitespace(newPassword)){
			model.addAttribute("message", "新密码不能为空");	
			return "admin/user/setPassword";
		}
		
		if(StringUtil.isEmptyOrWhitespace(newPasswordSure) || !newPasswordSure.equals(newPassword)){
			model.addAttribute("message", "确认密码不一致");	
			return "admin/user/setPassword";
		}
		
		User user = userService.findUserByUsername(WebUtil.getUserId(request));
		if(!oldPassword.equals(user.getPasswordU())){
			model.addAttribute("message", "当前密码不正确");	
			return "admin/user/setPassword";
		}
		
		user.setPasswordU(newPassword);
		userService.saveOrUpdateUser(user);
		
		return "redirect:/admin.do?action=manageUsers";
	}

	@RequestMapping(params = "action=manageBanner")
	public String manageBanner(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<BannerDTO> list = bannerService.getRandomBannerList(5);
		model.addAttribute("bannerDtoList", list);
		return "admin/banner/manageBanner";
	}

	@RequestMapping(params = "action=postBanner")
	public String postBanner(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/banner/postBanner";
	}

	@RequestMapping(params = "action=manageNews")
	public String manageNews(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/news/manageNews";
	}

	@RequestMapping(params = "action=manageNewsVideo")
	public String manageNewsVideo(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<NewsVideo> list = newsVideoService.getNewsVideoList(0, 10);
		List<NewsVideoDTO> newsVideoDtoList = new ArrayList<NewsVideoDTO>();
		for (NewsVideo newsVideo : list) {
			newsVideoDtoList.add(newsVideo.toDTO());
		}
		model.addAttribute("newsVideoDtoList", newsVideoDtoList);
		return "admin/news/manageNewsVideo";
	}

	@RequestMapping(params = "action=postNewsVideo")
	public String postNewsVideo(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id != 0) {
			NewsVideo newsVideo = newsVideoService.findNewsVideoById(id);
			if (newsVideo != null) {
				model.addAttribute("newsVideoDto", newsVideo.toDTO());
			}
		}

		return "admin/news/postNewsVideo";
	}

	@RequestMapping(params = "action=manageNewsInfo")
	public String manageNewsInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = newsInfoService.getNewsInfoTotalCount();
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<NewsInfo> newsInfoList = newsInfoService.getNewsInfoList(pageUtil.getStart(), pageUtil.getLimit());
		List<NewsInfoDTO> newsInfoDtoList = new ArrayList<NewsInfoDTO>();
		for (NewsInfo newsInfo : newsInfoList) {
			newsInfoDtoList.add(newsInfo.toDTO());
		}
		model.addAttribute("newsInfoDtoList", newsInfoDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("admin.do?action=manageNewsInfo", request));
		return "admin/news/manageNewsInfo";
	}

	@RequestMapping(params = "action=postNewsInfo")
	public String postNewsInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id != 0) {
			NewsInfo newsInfo = newsInfoService.findNewsInfoById(id);
			if (newsInfo != null) {
				model.addAttribute("newsInfoDto", newsInfo.toDTO());
			}
		}

		return "admin/news/postNewsInfo";
	}

	private String manageBio(HttpServletRequest request, HttpServletResponse response, Model model, String typeBio) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = bioService.getBioTotalCount(typeBio);
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<Bio> bioList = bioService.getBioList(pageUtil.getStart(), pageUtil.getLimit(), typeBio);
		List<BioFullDTO> bioDtoList = new ArrayList<BioFullDTO>();
		for (Bio bio : bioList) {
			bioDtoList.add(bio.toFullDTO());
		}
		model.addAttribute("bioDtoList", bioDtoList);
		model.addAttribute("totalCount", totalCount);
		String pageUrl = "admin.do?action=manageAimeBio";
		String returnPage = "admin/bio/manageAimeBio";
		if(typeBio != null && typeBio.equals(Bio.BioType.FraBioAuth.toString())){
			pageUrl = "admin.do?action=manageFraBioAuth";
			returnPage = "admin/bio/manageFraBioAuth";
		}
		model.addAttribute("pageutil", pageUtil.getToolBar(pageUrl, request));
		model.addAttribute("typeBio", typeBio);
		return returnPage;
	}
	
	@RequestMapping(params = "action=manageAimeBio")
	public String manageAimeBio(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.manageBio(request, response, model, Bio.BioType.AimeBio.toString());
	}

	@RequestMapping(params = "action=postBio")
	public String postBio(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String type = ParamUtils.getParameter(request, "type");
		model.addAttribute("type", type);
		if (id != 0) {
			Bio bio = bioService.findBioById(id);
			if (bio != null) {
				model.addAttribute("bioDto", bio.toFullDTO());
			}
		}
		return "admin/bio/postBio";
	}

	@RequestMapping(params = "action=manageFraBioAuth")
	public String manageFraBioAuth(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.manageBio(request, response, model, Bio.BioType.FraBioAuth.toString());
	}

	private void data(HttpServletRequest request, HttpServletResponse response, Model model, String typeInp, String pageBar) {
		IntoProvenceStory intoProvenceStory = intoProvenceStoryService.findFirstIntoProvenceStoryByType(typeInp);
		if (intoProvenceStory != null) {
			model.addAttribute("intoProvenceStoryDTO", intoProvenceStory.toDTO());
		}

		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = intoProvenceService.getIntoProvenceTotalCount(typeInp);
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<IntoProvence> intoProvenceList = intoProvenceService.getIntoProvenceList(pageUtil.getStart(), pageUtil.getLimit(), typeInp);
		List<IntoProvenceDTO> intoProvenceDtoList = new ArrayList<IntoProvenceDTO>();
		for (IntoProvence intoProvence : intoProvenceList) {
			intoProvenceDtoList.add(intoProvence.toDTO());
		}
		model.addAttribute("intoProvenceDtoList", intoProvenceDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("type", typeInp);
		model.addAttribute("pageutil", pageUtil.getToolBar(pageBar, request));
	}

	@RequestMapping(params = "action=manageIntoProvence")
	public String manageIntoProvence(HttpServletRequest request, HttpServletResponse response, Model model) {
		String type = ParamUtils.getParameter(request, "type");
		if (type != null && Arrays.asList(IntoProvence.typeInpEnum.values()).contains(IntoProvence.typeInpEnum.valueOf(type))) {
			this.data(request, response, model, type, "admin.do?action=manageIntoProvence&type=" + type);
		}
		return "admin/intoProvence/manageIntoProvence";
	}

	@RequestMapping(params = "action=postIntoProvence")
	public String postIntoProvence(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String typeInp = ParamUtils.getParameter(request, "type");
		model.addAttribute("type", typeInp);
		if (id != 0) {
			IntoProvence intoProvence = intoProvenceService.findIntoProvenceById(id);
			if (intoProvence != null) {
				model.addAttribute("intoProvenceDto", intoProvence.toDTO());
			}
		}
		return "admin/intoProvence/postIntoProvence";
	}

	@RequestMapping(params = "action=postIntoProvenceStroy")
	public String postIntoProvenceStroy(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String typeInp = ParamUtils.getParameter(request, "type");
		model.addAttribute("type", typeInp);
		if (id != 0) {
			IntoProvenceStory intoProvenceStory = intoProvenceStoryService.findIntoProvenceStoryById(id);
			if (intoProvenceStory != null) {
				model.addAttribute("intoProvenceStoryDto", intoProvenceStory.toDTO());
			}
		}

		return "admin/intoProvence/postIntoProvenceStroy";
	}

	@RequestMapping(params = "action=manageContactUs")
	public String manageContactUs(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<ContactUsDTO> dtoList = contactUsService.getContactUsList(3);
		for(ContactUsDTO dto : dtoList){
			if(ContactUs.TYPE_CONTACT.equals(dto.getTypeCtu())){
				model.addAttribute(ContactUs.TYPE_CONTACT, dto);
			}
			if(ContactUs.TYPE_HR.equals(dto.getTypeCtu())){
				model.addAttribute(ContactUs.TYPE_HR, dto);
			}
			if(ContactUs.TYPE_STORES.equals(dto.getTypeCtu())){
				model.addAttribute(ContactUs.TYPE_STORES, dto);
			}
		}
		return "admin/contactus/manageContactUs";
	}

	@RequestMapping(params = "action=postContactUs")
	public String postContactUs(HttpServletRequest request, HttpServletResponse response, Model model) {
		String type = ParamUtils.getParameter(request, "type");
		if (type != null) {
			ContactUs contactUs = contactUsService.findContactUsByType(type);
			if(contactUs != null){
				model.addAttribute("contactUsDTO", contactUs.toDTO());
			}			
		}	
		if(ContactUs.TYPE_CONTACT.equals(type)){
			model.addAttribute("ContactUsType", LocalizationUtil.getClientString("Contact.contactUs", request));
		}
		if(ContactUs.TYPE_HR.equals(type)){
			model.addAttribute("ContactUsType", LocalizationUtil.getClientString("Contact.hr", request));
		}
		if(ContactUs.TYPE_STORES.equals(type)){
			model.addAttribute("ContactUsType", LocalizationUtil.getClientString("Contact.stores", request));
		}
		
		return "admin/contactus/postContactUs";
	}

	@RequestMapping(params = "action=manageMessage")
	public String manageMessage(HttpServletRequest request, HttpServletResponse response, Model model) {

		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = 0;
		List<MessageDTO> messageDTOList = null;
		PageUtil pageUtil = null;
		String pageLink = "admin.do?action=manageMessage";

		totalCount = messageService.getMessageTotalCount();
		pageUtil = new PageUtil(totalCount, curPage, pageSize);
		messageDTOList = messageService.getMessageList(pageUtil.getStart(), pageUtil.getLimit());
		model.addAttribute("messageDTOList", messageDTOList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar(pageLink, request));
		return "admin/contactus/manageMessage";
	}

	@RequestMapping(params = "action=manageBrand")
	public String manageBrand(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<BrandLogoDTO> brandLogoDTOList = brandService.getBrandLogoDTOList(0, Integer.MAX_VALUE);
		model.addAttribute("brandLogoDTOList", brandLogoDTOList);
		return "admin/brand/manageBrand";
	}

	@RequestMapping(params = "action=postBrand")
	public String postBrand(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id != 0) {
			Brand brand = brandService.findBrandById(id);
			if (brand != null) {
				model.addAttribute("brandDTO", brand.toDTO());
			}

			BrandDetail brandDetail = brandService.findBrandDetailByBrand(brand);
			if (brandDetail != null) {
				model.addAttribute("brandDetailDTO", brandDetail.toDTO());
			}

		}

		return "admin/brand/postBrand";
	}

	@RequestMapping(params = "action=manageCategory")
	public String manageCategory(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		Brand brand = null;
		if (brandId != 0) {
			brand = brandService.findBrandById(brandId);
		}

		if (brand == null) {
			return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
		}
		model.addAttribute("brandDTO", brand.toDTO());
		model.addAttribute("categoryDTOList", categoryService.getCategoryListByBrandId(brandId));
		return "admin/brand/manageCategory";
	}

	@RequestMapping(params = "action=postCategory")
	public String postCategory(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Category category = null;
		if (id != 0) {
			category = categoryService.findCategoryById(id);
			if (category != null) {
				model.addAttribute("categoryDTO", category.toDTO());
			}
		}
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		Brand brand = null;
		if (brandId != 0) {
			brand = brandService.findBrandById(brandId);
		}

		if (category == null && brand == null) {
			return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
		}
		if (brand != null) {
			model.addAttribute("brandDTO", brand.toDTO());
		} else {
			model.addAttribute("brandDTO", category.getBrand().toDTO());
		}
		return "admin/brand/postCategory";
	}

	@RequestMapping(params = "action=manageProduct")
	public String manageProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);
		Category category = null;
		if (categoryId != 0) {
			category = categoryService.findCategoryById(categoryId);
		}

		if (category == null) {
			return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
		}

		// 分类及产品
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 10);
		int totalCount = 0;
		List<ProductDTO> productDTOList = null;
		PageUtil pageUtil = null;
		String pageLink = null;

		totalCount = productService.getProductTotalCountByCategoryId(categoryId);
		pageUtil = new PageUtil(totalCount, curPage, pageSize);
		productDTOList = productService.getProductDTOListByCategoryId(pageUtil.getStart(), pageUtil.getLimit(), categoryId);
		pageLink = "admin.do?action=manageProduct&categoryId=" + categoryId;

		model.addAttribute("productDTOList", productDTOList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar(pageLink, request));
		model.addAttribute("categoryDTO", category.toDTO());
		model.addAttribute("brandDTO", category.getBrand().toDTO());
		return "admin/brand/manageProduct";
	}

	@RequestMapping(params = "action=postProduct")
	public String postProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		ProductDetail productDetail = null;
		if (id != 0) {
			productDetail = productService.findProductDetailByProductId(id);
			if (productDetail != null) {
				model.addAttribute("productDetailDTO", productDetail.toDTO());
			}
		}

		Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);
		Category category = null;
		if (categoryId != 0) {
			category = categoryService.findCategoryById(categoryId);

		}
		if (category == null) {
			return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
		}
		model.addAttribute("categoryDTO", category.toDTO());

		model.addAttribute("brandDTO", category.getBrand().toDTO());

		return "admin/brand/postProduct";
	}
}
