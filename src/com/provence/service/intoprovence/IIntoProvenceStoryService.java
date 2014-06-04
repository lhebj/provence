package com.provence.service.intoprovence;

import java.util.List;

import com.provence.pojo.IntoProvenceStory;

public interface IIntoProvenceStoryService {
	public void saveOrUpdateIntoProvenceStory(IntoProvenceStory intoProvenceStory);
	
	public IntoProvenceStory findIntoProvenceStoryById(Long id);
	
	public void deleteIntoProvenceStory(IntoProvenceStory intoProvenceStory);
	
	public void deleteIntoProvenceStoryById(Long id);
	
	/**
	 * 
	  * 每个类型只有一个story
	  * @param typeInps
	  * @return    
	  * @return IntoProvenceStory
	 */
	public IntoProvenceStory findFirstIntoProvenceStoryByType(String typeInps);
	
	public List<IntoProvenceStory> getIntoProvenceStoryList (int start, int limit, String typeInps); 
		
	public int getIntoProvenceStoryTotalCount(String typeInps);
}
