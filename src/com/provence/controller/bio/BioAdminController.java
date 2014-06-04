package com.provence.controller.bio;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Bio;
import com.provence.pojo.Content;
import com.provence.service.bio.IBioService;
import com.provence.service.content.IContentService;
import com.provence.web.upload.UploadFileUtil;
import com.provence.web.util.JSONHelperUtil;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.LogUtil;
import com.provence.web.util.ParamUtils;
import com.provence.web.util.ProvenceConfig;
import com.provence.web.util.StringUtil;
import com.provence.web.util.WebUtil;

@Controller
@RequestMapping("/bioAdmin.do")
public class BioAdminController {

	@Resource(name = "bioService")
	private IBioService bioService;

	@Resource
	private IContentService contentService;
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String titleBio = ParamUtils.getParameter(request, "titleBio");
		String titleEnBio = ParamUtils.getParameter(request, "titleEnBio");
		String titleFrBio = ParamUtils.getParameter(request, "titleFrBio");
		String contentBio = ParamUtils.getParameter(request, "contentBio");
		String contentEnBio = ParamUtils.getParameter(request, "contentEnBio");
		String contentFrBio = ParamUtils.getParameter(request, "contentFrBio");
		String typeBio = ParamUtils.getParameter(request, "typeBio");
		String picPlaceBio = ParamUtils.getParameter(request, "picPlaceBio");
		try {
			if(typeBio == null || !Arrays.asList(Bio.BioType.values()).contains(Bio.BioType.valueOf(typeBio))){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			if(picPlaceBio == null || !Arrays.asList(Bio.PicPlace.values()).contains(Bio.PicPlace.valueOf(picPlaceBio))){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_NEWS, ProvenceConfig.MAX_UPLOADSIZE);
			boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" +  (String) map.get(UploadFileUtil.MESSAGE);
			} else {
				// TODO
				Bio bio = null;
				if (id != 0) {
					bio = bioService.findBioById(id);
				}
				
				if(bio == null){
					bio = new Bio();
				}
				
				if (map.get(UploadFileUtil.UPLOAD_FILE) != null) {
					Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);
					contentService.saveOrUpdateContent(content);
					bio.setPic(content);
				}
				bio.setDateCreateBio(new Date());
				bio.setContentBio(StringUtil.filterWordFormatAndSomeHTML(contentBio));
				bio.setContentEnBio(StringUtil.filterWordFormatAndSomeHTML(contentEnBio));
				bio.setContentFrBio(StringUtil.filterWordFormatAndSomeHTML(contentFrBio));
				bio.setTitleBio(titleBio);
				bio.setTitleEnBio(titleEnBio);
				bio.setTitleFrBio(titleFrBio);
				bio.setTypeBio(typeBio);
				bio.setPicPlaceBio(picPlaceBio);
				bioService.saveOrUpdateBio(bio);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		if(typeBio.equals(Bio.BioType.AimeBio.toString())){
			return "redirect:/admin.do?action=manageAimeBio";
		}
		return "redirect:/admin.do?action=manageFraBioAuth";
	}
	
	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id == 0) {
//			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, LocalizationUtil.getClientString("ContentId_is_Null", request), response);
			return "redirect:/error.do?action=1&message=参数错误";
		}

		try {
			Bio bio = bioService.findBioById(id);
			if (bio == null) {
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes Bio id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			if(bio.getTypeBio().equals(Bio.BioType.AimeBio)){
				contentService.deleteContent(bio.getPic());
			}
			bioService.deleteBio(bio);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes bio id " + id);
			if(bio.getTypeBio().equals(Bio.BioType.AimeBio.toString())){
				return "redirect:/admin.do?action=manageAimeBio";
			}
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}		
		return "redirect:/admin.do?action=manageFraBioAuth";
	}
}
