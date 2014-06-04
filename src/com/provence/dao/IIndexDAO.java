package com.provence.dao;

import java.util.List;

import com.provence.pojo.Index;

public interface IIndexDAO {

	public void saveOrUpdateIndex(Index index);
	
	public Index findIndexDetailById(Long id);
	
	public void deleteIndex(Index index);
	
	public List<Index> getRandomIndexList (int limit, String typeIdx); 
}
