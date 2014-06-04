package com.provence.controller.index;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Content;
import com.provence.pojo.Index;
import com.provence.service.content.IContentService;
import com.provence.service.index.IIndexService;
import com.provence.service.user.IUserService;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.WebUtil;

/**
 * 首页数据操作
 * 
 * @version 1.0.0 IndexAdminController.java
 */
@Controller
@RequestMapping("/indexAdmin.do")
public class IndexAdminController {

	@Resource(name = "indexService")
	private IIndexService indexService;

	@Resource
	private IContentService contentService;

	@Resource
	private IUserService userService;

	/**
	 * 添加首頁图片或视频
	 * 
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		String typeIdx = ParamUtils.getParameter(request, "typeIdx");
		String playcodeIdx = ParamUtils.getParameter(request, "playcodeIdx");
		try {
			Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_INDEX, ProvenceConfig.MAX_UPLOADSIZE);
			boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
			if (!isSuccess) {
				// JSONHelperUtil.outputOperationResultAsJSON(false, (String)
				// map.get(UploadFileUtil.MESSAGE), response);
				return "redirect:/error.do?action=1&message=" + (String) map.get(UploadFileUtil.MESSAGE);
			} else {
				// TODO
				Index index = new Index();
				if (map.get(UploadFileUtil.UPLOAD_FILE) != null) {
					Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);
					contentService.saveOrUpdateContent(content);
					index.setPic(content);
				}
				index.setDateCreateIdx(new Date());
				index.setTypeIdx(Index.TYPE_PIC);
				indexService.saveOrUpdateIndex(index);

				if (Index.TYPE_VIDEO.equals(typeIdx)) {
					index.setPlaycodeIdx(playcodeIdx);
					index.setTypeIdx(Index.TYPE_VIDEO);
					indexService.saveOrUpdateIndex(index);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageIndex";
	}

	/**
	 * 删除首页图片或视频
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

			Index index = indexService.findIndexDetailById(id);
			if (index == null) {
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes Index id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			if (index.getPic() != null) {
				contentService.deleteContent(index.getPic());
			}
			indexService.deleteIndex(index);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes Index id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageIndex";
	}
}
