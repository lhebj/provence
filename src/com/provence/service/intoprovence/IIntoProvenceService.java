package com.provence.service.intoprovence;

import java.util.List;

import com.provence.pojo.IntoProvence;

public interface IIntoProvenceService {
	public void saveOrUpdateIntoProvence(IntoProvence intoProvence);
	
	public IntoProvence findIntoProvenceById(Long id);
	
	public void deleteIntoProvence(IntoProvence intoProvence);
	
	public List<IntoProvence> getIntoProvenceList (int start, int limit, String typeInp); 
	
	public int getIntoProvenceTotalCount(String typeInp);
}
