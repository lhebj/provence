package com.provence.controller.index;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.provence.pojo.Index;
import com.provence.service.index.IIndexService;
import com.provence.web.dto.IndexDTO;

@Controller
@RequestMapping("/")
public class IndexController {

	@Resource(name = "indexService")
	private IIndexService indexService;

	/**
	 * 获取首页图片，随机排序 获取一个视频排在第二的位置
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @return String
	 */
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Index> list = indexService.getRandomIndexList(4, Index.TYPE_PIC);
		List<Index> videoList = indexService.getRandomIndexList(1, Index.TYPE_VIDEO);
		List<IndexDTO> dtoList = new ArrayList<IndexDTO>();
		for (int i = 0; i < list.size(); i++) {
			if (i == 1) {
				for (Index index : videoList) {
					dtoList.add(index.toDTO());
				}
			}
			dtoList.add(list.get(i).toDTO());
		}
		model.addAttribute("indexDtoList", dtoList);
		return "index";
	}
}
