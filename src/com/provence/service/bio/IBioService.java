package com.provence.service.bio;

import java.util.List;

import com.provence.pojo.Bio;

public interface IBioService {

	public void saveOrUpdateBio(Bio bio);
	
	public Bio findBioById(Long id);
	
	public void deleteBio(Bio bio);
	
	public void deleteBioById(Long id);
	
	public List<Bio> getBioList (int start, int limit, String typeBio); 
	
	public int getBioTotalCount(String typeBio);
}
