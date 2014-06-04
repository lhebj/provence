package com.provence.service.intoprovence.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IIntoProvenceStoryDAO;
import com.provence.pojo.IntoProvenceStory;
import com.provence.service.intoprovence.IIntoProvenceStoryService;

@Service(value = "intoProvenceStoryService")
public class IntoProvenceStoryServiceImpl implements IIntoProvenceStoryService {

	@Resource
	private IIntoProvenceStoryDAO intoProvenceStoryDAO;
	
	@Override
	public void saveOrUpdateIntoProvenceStory(IntoProvenceStory intoProvenceStory) {
		// TODO Auto-generated method stub
		intoProvenceStoryDAO.saveOrUpdateIntoProvenceStory(intoProvenceStory);
	}

	@Override
	public IntoProvenceStory findIntoProvenceStoryById(Long id) {
		// TODO Auto-generated method stub
		return intoProvenceStoryDAO.findIntoProvenceStoryById(id);
	}

	@Override
	public void deleteIntoProvenceStory(IntoProvenceStory intoProvenceStory) {
		// TODO Auto-generated method stub
		intoProvenceStoryDAO.deleteIntoProvenceStory(intoProvenceStory);
	}

	@Override
	public void deleteIntoProvenceStoryById(Long id) {
		// TODO Auto-generated method stub
		intoProvenceStoryDAO.deleteIntoProvenceStoryById(id);
	}

	/**
	 * 
	  * 每个类型只有一个story
	  * @param typeInps
	  * @return    
	  * @return IntoProvenceStory
	 */
	@Override
	public IntoProvenceStory findFirstIntoProvenceStoryByType(String typeInps){
		List<IntoProvenceStory> list = intoProvenceStoryDAO.getIntoProvenceStoryList(0, 1, typeInps);
		return list.size()>0?list.get(0):null;
	}
	
	@Override
	public List<IntoProvenceStory> getIntoProvenceStoryList(int start, int limit, String typeInps) {
		// TODO Auto-generated method stub
		return intoProvenceStoryDAO.getIntoProvenceStoryList(start, limit, typeInps);
	}

	@Override
	public int getIntoProvenceStoryTotalCount(String typeInps) {
		// TODO Auto-generated method stub
		return intoProvenceStoryDAO.getIntoProvenceStoryTotalCount(typeInps);
	}

}
