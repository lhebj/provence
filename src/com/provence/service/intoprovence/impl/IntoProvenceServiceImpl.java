package com.provence.service.intoprovence.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IIntoProvenceDAO;
import com.provence.pojo.IntoProvence;
import com.provence.service.intoprovence.IIntoProvenceService;

@Service(value = "intoProvenceService")
public class IntoProvenceServiceImpl implements IIntoProvenceService {

	@Resource
	private IIntoProvenceDAO intoProvenceDAO;
	
	@Override
	public void saveOrUpdateIntoProvence(IntoProvence intoProvence) {
		// TODO Auto-generated method stub
		intoProvenceDAO.saveOrUpdateIntoProvence(intoProvence);
	}

	@Override
	public IntoProvence findIntoProvenceById(Long id) {
		// TODO Auto-generated method stub
		return intoProvenceDAO.findIntoProvenceById(id);
	}

	@Override
	public void deleteIntoProvence(IntoProvence intoProvence) {
		// TODO Auto-generated method stub
		intoProvenceDAO.deleteIntoProvence(intoProvence);
	}

	@Override
	public List<IntoProvence> getIntoProvenceList(int start, int limit, String typeInp) {
		// TODO Auto-generated method stub
		return intoProvenceDAO.getIntoProvenceList(start, limit, typeInp);
	}

	@Override
	public int getIntoProvenceTotalCount(String typeInp) {
		// TODO Auto-generated method stub
		return intoProvenceDAO.getIntoProvenceTotalCount(typeInp);
	}

}
