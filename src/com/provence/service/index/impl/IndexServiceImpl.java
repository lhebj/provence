package com.provence.service.index.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IContentDAO;
import com.provence.dao.IIndexDAO;
import com.provence.pojo.Index;
import com.provence.service.index.IIndexService;

@Service(value = "indexService")
public class IndexServiceImpl implements IIndexService {
	
	@Resource
	private IContentDAO contentDAO;
	
	@Resource
	private IIndexDAO indexDAO;

	@Override
	public void saveOrUpdateIndex(Index index) {
		// TODO Auto-generated method stub
		indexDAO.saveOrUpdateIndex(index);
	}

	@Override
	public Index findIndexDetailById(Long id) {
		// TODO Auto-generated method stub
		return indexDAO.findIndexDetailById(id);
	}

	@Override
	public void deleteIndex(Index index) {
		// TODO Auto-generated method stub
		indexDAO.deleteIndex(index);
	}

	@Override
	public List<Index> getRandomIndexList(int limit, String typeIdx) {
		// TODO Auto-generated method stub
		return indexDAO.getRandomIndexList(limit, typeIdx);
	}

}
