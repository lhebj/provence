package com.provence.service.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.provence.pojo.User;

public interface IUserService {
	
	public void saveOrUpdateUser(User user);
	
	public User findUserById(Long id);
	
	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public void deleteUser(User user);
	
	public void deleteUserById(Long id);
	
	public List<User> getUserList (int start, int limit); 
	
	public int getUserTotalCount();
	
	public Map<String, Object> accessControl(HttpServletRequest request, HttpServletResponse response);
}
