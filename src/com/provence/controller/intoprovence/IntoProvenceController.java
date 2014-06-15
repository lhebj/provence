package com.provence.controller.intoprovence;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.IntoProvence;
import com.provence.pojo.IntoProvenceStory;
import com.provence.service.banner.IBannerService;
import com.provence.service.intoprovence.IIntoProvenceService;
import com.provence.service.intoprovence.IIntoProvenceStoryService;
import com.provence.web.dto.IntoProvenceDTO;
import com.provence.web.util.PageUtil;
import com.provence.web.util.ParamUtils;
import com.weather.Weather;
import com.weather.YahooWeather;


@Controller
@RequestMapping("/intoProvence.do")
public class IntoProvenceController {
	

	@Resource
	private IIntoProvenceService intoProvenceService;

	@Resource
	private IIntoProvenceStoryService intoProvenceStoryService;
	
	@Resource
	private IBannerService bannerService;
	
	private void data (HttpServletRequest request, HttpServletResponse response, Model model, String typeInp, String pageBar){
		IntoProvenceStory intoProvenceStory = intoProvenceStoryService.findFirstIntoProvenceStoryByType(typeInp);
		if(intoProvenceStory != null){
			model.addAttribute("intoProvenceStoryDTO", intoProvenceStory.toDTO());	
		}		
		
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 2);
		int totalCount = intoProvenceService.getIntoProvenceTotalCount(typeInp);
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<IntoProvence> intoProvenceList = intoProvenceService.getIntoProvenceList(pageUtil.getStart(), pageUtil.getLimit(),typeInp);
		List<IntoProvenceDTO> intoProvenceDtoList = new ArrayList<IntoProvenceDTO>();
		for(IntoProvence intoProvence : intoProvenceList){
			intoProvenceDtoList.add(intoProvence.toDTO());
		}
		model.addAttribute("intoProvenceDtoList", intoProvenceDtoList);
		model.addAttribute("typeInp", typeInp);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar(pageBar, request));
		
		//Weather
		Weather weather = new YahooWeather();
		try {
			model.addAttribute("weatherData", weather.getCurrentDayWeather(YahooWeather.PROVENCE_CODE));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//banner
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		
	}

	@RequestMapping(params = "action=intro")
	public String intro(HttpServletRequest request, HttpServletResponse response, Model model) {
		this.data(request, response, model, IntoProvence.typeInpEnum.intro.toString(), "intoProvence.do?action=intro");		
		return "intoProvence";
	}
	
	@RequestMapping(params = "action=color")
	public String color(HttpServletRequest request, HttpServletResponse response, Model model) {
		this.data(request, response, model, IntoProvence.typeInpEnum.color.toString(), "intoProvence.do?action=color");
		return "intoProvence";
	}
	
	
	@RequestMapping(params = "action=smell")
	public String smell(HttpServletRequest request, HttpServletResponse response, Model model) {
		this.data(request, response, model, IntoProvence.typeInpEnum.smell.toString(), "intoProvence.do?action=smell");
		return "intoProvence";
	}
	
	
	@RequestMapping(params = "action=taste")
	public String taste(HttpServletRequest request, HttpServletResponse response, Model model) {
		this.data(request, response, model, IntoProvence.typeInpEnum.taste.toString(), "intoProvence.do?action=taste");
		return "intoProvence";
	}
	
	
	@RequestMapping(params = "action=quality")
	public String quality(HttpServletRequest request, HttpServletResponse response, Model model) {
		this.data(request, response, model, IntoProvence.typeInpEnum.quality.toString(), "intoProvence.do?action=quality");
		return "intoProvence";
	}
	
}
