package com.provence.service.bio.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.provence.dao.IBioDAO;
import com.provence.pojo.Bio;
import com.provence.service.bio.IBioService;

@Service(value = "bioService")
public class BioServiceImpl implements IBioService {

	@Resource
	private IBioDAO bioDAO;
	
	@Override
	public void saveOrUpdateBio(Bio bio) {
		// TODO Auto-generated method stub
		bioDAO.saveOrUpdateBio(bio);
	}

	@Override
	public Bio findBioById(Long id) {
		// TODO Auto-generated method stub
		return bioDAO.findBioById(id);
	}

	@Override
	public void deleteBio(Bio bio) {
		// TODO Auto-generated method stub
		bioDAO.deleteBio(bio);
	}

	@Override
	public void deleteBioById(Long id) {
		// TODO Auto-generated method stub
		bioDAO.deleteBioById(id);
	}

	@Override
	public List<Bio> getBioList(int start, int limit, String typeBio) {
		// TODO Auto-generated method stub
		return bioDAO.getBioList(start, limit, typeBio);
	}

	@Override
	public int getBioTotalCount(String typeBio) {
		// TODO Auto-generated method stub
		return bioDAO.getBioTotalCount(typeBio);
	}

}
