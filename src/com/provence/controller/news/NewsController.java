package com.provence.controller.news;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.NewsInfo;
import com.provence.pojo.NewsVideo;
import com.provence.service.banner.IBannerService;
import com.provence.service.news.INewsInfoService;
import com.provence.service.news.INewsVideoService;
import com.provence.web.dto.NewsInfoDTO;
import com.provence.web.dto.NewsVideoDTO;
import com.provence.web.util.PageUtil;
import com.provence.web.util.ParamUtils;

@Controller
@RequestMapping("/")
public class NewsController {

	@Resource(name = "newsInfoService")
	private INewsInfoService newsInfoService;	
	
	@Resource(name = "newsVideoService")
	private INewsVideoService newsVideoService;
	@Resource
	private IBannerService bannerService;
	
	@RequestMapping("/news.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long idNsv = ParamUtils.getLongParameter(request, "idNsv", 1);
		List<NewsVideo> list = newsVideoService.getNewsVideoList(0, 10);
		List<NewsVideoDTO> newsVideoDtoList = new ArrayList<NewsVideoDTO>();
		NewsVideoDTO showNewsVideoDto = new NewsVideoDTO();
		for(NewsVideo newsVideo : list){
			newsVideoDtoList.add(newsVideo.toDTO());
			if(newsVideo.getIdNsv() == idNsv){
				showNewsVideoDto = newsVideo.toDTO();
			}
		}
		model.addAttribute("newsVideoDtoList", newsVideoDtoList);
		model.addAttribute("showNewsVideoDto", showNewsVideoDto);
		
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 2);
		int totalCount = newsInfoService.getNewsInfoTotalCount();
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		List<NewsInfo> newsInfoList = newsInfoService.getNewsInfoList(pageUtil.getStart(), pageUtil.getLimit());
		List<NewsInfoDTO> newsInfoDtoList = new ArrayList<NewsInfoDTO>();
		for(NewsInfo newsInfo : newsInfoList){
			newsInfoDtoList.add(newsInfo.toDTO());
		}
		model.addAttribute("newsInfoDtoList", newsInfoDtoList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("news.do", request));
		model.addAttribute("bannerDtoList", bannerService.getRandomBannerList(5));
		return "news";
	}
}
