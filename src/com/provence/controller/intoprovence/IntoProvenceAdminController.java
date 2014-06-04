package com.provence.controller.intoprovence;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Content;
import com.provence.pojo.IntoProvence;
import com.provence.pojo.IntoProvenceStory;
import com.provence.service.content.IContentService;
import com.provence.service.intoprovence.IIntoProvenceService;
import com.provence.service.intoprovence.IIntoProvenceStoryService;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.StringUtil;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/intoProvenceAdmin.do")
public class IntoProvenceAdminController {

	@Resource
	private IIntoProvenceService intoProvenceService;

	@Resource
	private IIntoProvenceStoryService intoProvenceStoryService;

	@Resource
	private IContentService contentService;

	@RequestMapping(params = "action=saveStory")
	public String saveStory(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String storyInps = ParamUtils.getParameter(request, "storyInps");
		String typeInps = ParamUtils.getParameter(request, "typeInps");

		try {
			if (typeInps == null || !Arrays.asList(IntoProvence.typeInpEnum.values()).contains(IntoProvence.typeInpEnum.valueOf(typeInps))) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			IntoProvenceStory intoProvenceStory = null;
			if (id != 0) {
				intoProvenceStory = intoProvenceStoryService.findIntoProvenceStoryById(id);
			}

			if (intoProvenceStory == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			intoProvenceStory.setStoryInps(storyInps);
			intoProvenceStory.setTypeInps(typeInps);
			intoProvenceStoryService.saveOrUpdateIntoProvenceStory(intoProvenceStory);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves intoProvenceStory id " + intoProvenceStory.getIdInps());

		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageIntoProvence&type=" + typeInps;
	}

	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String contentInp = ParamUtils.getParameter(request, "contentInp");
		String typeInp = ParamUtils.getParameter(request, "typeInp");
		if (typeInp == null || !Arrays.asList(IntoProvence.typeInpEnum.values()).contains(IntoProvence.typeInpEnum.valueOf(typeInp))) {
			return "redirect:/error.do?action=1&message=保存失败";
		}
		try {
			Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_INTOPROVENCE, ProvenceConfig.MAX_UPLOADSIZE);
			boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" + (String) map.get(UploadFileUtil.MESSAGE);
			} else {
				// TODO
				IntoProvence intoProvence = null;
				if (id != 0) {
					intoProvence = intoProvenceService.findIntoProvenceById(id);
				}

				if (intoProvence == null) {
					intoProvence = new IntoProvence();
				}

				if (map.get(UploadFileUtil.UPLOAD_FILE) != null) {
					Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);
					contentService.saveOrUpdateContent(content);
					intoProvence.setPic(content);
				}
				intoProvence.setDateCreateInp(new Date());
				intoProvence.setContentInp(StringUtil.filterWordFormatAndSomeHTML(contentInp));
				intoProvence.setTypeInp(typeInp);
				intoProvenceService.saveOrUpdateIntoProvence(intoProvence);
				LogUtil.log.info(WebUtil.getUserId(request) + " saves intoProvence id " + intoProvence.getIdInp());
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageIntoProvence&type=" + typeInp;
	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String typeInp = null;

		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			IntoProvence intoProvence = intoProvenceService.findIntoProvenceById(id);
			if (intoProvence == null) {
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes IntoProvence id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			typeInp = intoProvence.getTypeInp();
			contentService.deleteContent(intoProvence.getPic());
			intoProvenceService.deleteIntoProvence(intoProvence);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes IntoProvence id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageIntoProvence&type=" + typeInp;
	}
}
