package com.provence.controller.news;

import java.net.URLEncoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.NewsVideo;
import com.provence.service.news.INewsVideoService;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.WebUtil;

/**
 * 资讯视频部分操作
 * 
 * @version 1.0.0 NewsVideoAdminController.java
 */
@Controller
@RequestMapping("/newsVideoAdmin.do")
public class NewsVideoAdminController {

	@Resource(name = "newsVideoService")
	private INewsVideoService newsVideoService;

	/**
	 * 添加资讯视频
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		String titleNsv = ParamUtils.getParameter(request, "titleNsv");
		String playcodeNsv = ParamUtils.getParameter(request, "playcodeNsv");
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		try {
			NewsVideo newsVideo = null;
			if (id != 0) {
				newsVideo = newsVideoService.findNewsVideoById(id);
			}

			if (newsVideo == null) {
				newsVideo = new NewsVideo();
			}

			newsVideo.setDateCreateNsv(new Date());
			newsVideo.setPlaycodeNsv(playcodeNsv);
			newsVideo.setTitleNsv(titleNsv);
			newsVideoService.saveOrUpdateNewsVideo(newsVideo);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves NewsVideo id " + newsVideo.getIdNsv());
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "save false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageNewsVideo";
	}

	/**
	 * 删除资讯视频
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

			newsVideoService.deleteNewsVideoById(id);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes NewsVideo id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageNewsVideo";
	}

}
