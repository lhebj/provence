package com.provence.controller.banner;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Banner;
import com.provence.pojo.Content;
import com.provence.service.banner.IBannerService;
import com.provence.service.content.IContentService;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/bannerAdmin.do")
public class BannerAdminController {
	
	@Resource(name = "bannerService")
	private IBannerService bannerService;

	@Resource
	private IContentService contentService;
	

	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		try {
				Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_BANNER, ProvenceConfig.MAX_UPLOADSIZE);
				boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
				if (!isSuccess) {
//					JSONHelperUtil.outputOperationResultAsJSON(false, (String) map.get(UploadFileUtil.MESSAGE), response);
					return "redirect:/error.do?action=1&message=" + (String) map.get(UploadFileUtil.MESSAGE);
				} else {
					// TODO
					Banner banner = new Banner();
					if( map.get(UploadFileUtil.UPLOAD_FILE) != null){
						Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);						
						contentService.saveOrUpdateContent(content);
						banner.setPic(content);
					}					
					banner.setDateCreateBa(new Date());
					bannerService.saveOrUpdateBanner(banner);
					LogUtil.log.info(WebUtil.getUserId(request) + " saves Banner id " + banner.getIdBa());
				}
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageBanner";
	}
	
	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			Banner banner = bannerService.findBannerById(id);
			if (banner == null){
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes banner id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			contentService.deleteContent(banner.getPic());
			bannerService.deleteBanner(banner);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes Banner id " + id);		
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageBanner";
	}
}
