package com.provence.controller.news;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Content;
import com.provence.pojo.NewsInfo;
import com.provence.service.content.IContentService;
import com.provence.service.news.INewsInfoService;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.WebUtil;

/**
 * 资讯数据接口
 * 
 * @version 1.0.0 NewsInfoAdminController.java
 */
@Controller
@RequestMapping("/newsInfoAdmin.do")
public class NewsInfoAdminController {

	@Resource(name = "newsInfoService")
	private INewsInfoService newsInfoService;

	@Resource
	private IContentService contentService;

	/**
	 * 添加资讯
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String titleNsi = ParamUtils.getParameter(request, "titleNsi");
		String contentNsi = ParamUtils.getParameter(request, "contentNsi");
		try {
			Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_NEWS, ProvenceConfig.MAX_UPLOADSIZE);
			boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" +  (String) map.get(UploadFileUtil.MESSAGE);
			} else {
				// TODO
				NewsInfo newsInfo = null;
				if (id != 0) {
					newsInfo = newsInfoService.findNewsInfoById(id);
				}
				
				if(newsInfo == null){
					newsInfo = new NewsInfo();
				}
				
				if (map.get(UploadFileUtil.UPLOAD_FILE) != null) {
					Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);
					contentService.saveOrUpdateContent(content);
					newsInfo.setPic(content);
				}
				newsInfo.setDateCreateNsi(new Date());
				newsInfo.setContentNsi(contentNsi);
				newsInfo.setTitleNsi(titleNsi);
				newsInfoService.saveOrUpdateNewsInfo(newsInfo);
				LogUtil.log.info(WebUtil.getUserId(request) + " saves newsInfo id " + newsInfo.getIdNsi());
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageNewsInfo";
	}

	/**
	 * 删除资讯
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);

		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			NewsInfo newsInfo = newsInfoService.findNewsInfoById(id);
			if (newsInfo == null) {
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes NewsInfo id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			contentService.deleteContent(newsInfo.getPic());
			newsInfoService.deleteNewsInfo(newsInfo);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes NewsInfo id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageNewsInfo";
	}

}
