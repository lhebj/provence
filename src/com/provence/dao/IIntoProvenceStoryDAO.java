package com.provence.dao;

import java.util.List;

import com.provence.pojo.IntoProvenceStory;

public interface IIntoProvenceStoryDAO {
	public void saveOrUpdateIntoProvenceStory(IntoProvenceStory intoProvenceStory);
	
	public IntoProvenceStory findIntoProvenceStoryById(Long id);
	
	public void deleteIntoProvenceStory(IntoProvenceStory intoProvenceStory);
	
	public void deleteIntoProvenceStoryById(Long id);
	
	public List<IntoProvenceStory> getIntoProvenceStoryList (int start, int limit, String typeInps); 
	
	public int getIntoProvenceStoryTotalCount(String typeInps);
}
