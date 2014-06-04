package com.provence.controller.bio;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Bio;
import com.provence.service.banner.IBannerService;
import com.provence.service.bio.IBioService;
import com.provence.web.dto.BioDTO;
import com.provence.web.util.PageUtil;
import com.provence.web.util.ParamUtils;

@Controller
@RequestMapping("/")
public class FraBioAuthController {


	@Resource(name = "bioService")
	private IBioService bioService;	
	
	@Resource
	private IBannerService bannerService;
	
	@RequestMapping("/fraBioAuth.do")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 3);
		int totalCount = bioService.getBioTotalCount(Bio.BioType.FraBioAuth.toString());
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<Bio> bioList = bioService.getBioList(pageUtil.getStart(), pageUtil.getLimit(), Bio.BioType.FraBioAuth.toString());
		List<BioDTO> bioDtoList = new ArrayList<BioDTO>();
		for(Bio bio : bioList){
			bioDtoList.add(bio.toDTO(request));
		}
		model.addAttribute("requestURI", "fraBioAuth");
		model.addAttribute("bioDtoList", bioDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("fraBioAuth.do", request));
		
		//banner
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		return "bio";
	}
}
