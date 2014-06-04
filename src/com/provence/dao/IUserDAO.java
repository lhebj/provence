package com.provence.dao;

import java.util.List;

import com.provence.pojo.User;

public interface IUserDAO {
	public void saveOrUpdateUser(User user);
	
	public User findUserDetailById(Long id);
	
	
	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public void deleteUser(User user);
	
	public void deleteUserById(Long id);
	
	public List<User> getUserList (int start, int limit); 
	
	public int getUserTotalCount();
}
