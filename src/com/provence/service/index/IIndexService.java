package com.provence.service.index;

import java.util.List;

import com.provence.pojo.Index;

public interface IIndexService {

	public void saveOrUpdateIndex(Index index);
	
	public Index findIndexDetailById(Long id);
	
	public void deleteIndex(Index index);
	
	public List<Index> getRandomIndexList (int limit, String typeIdx); 
}
