package com.provence.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.provence.dao.IUserDAO;
import com.provence.pojo.User;
import com.provence.service.user.IUserService;
import com.provence.web.util.LocalizationUtil;
import com.provence.web.util.WebUtil;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDAO userDAO;
	
	@Override
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveOrUpdateUser(user);
	}

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return userDAO.findUserDetailById(id);
	}

	
	
	public User findUserByUsername(String username){
		return userDAO.findUserByUsername(username);
	}
	
	public User findUserByEmail(String email){
		return userDAO.findUserByEmail(email);
	}
	
	
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(user);
	}
	
	public void deleteUserById(Long id){
		userDAO.deleteUserById(id);
	}

	@Override
	public List<User> getUserList(int start, int limit) {
		// TODO Auto-generated method stub
		return userDAO.getUserList(start, limit);
	}
	
	public int getUserTotalCount(){
		return userDAO.getUserTotalCount();
	}
	
	@Override
	public Map<String, Object> accessControl(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		if (!WebUtil.getUserId(request).equalsIgnoreCase(User.ADMIN)){
			map.put("message", LocalizationUtil.getClientString("Permission.deny", request));
			map.put("access", false);
			return map;
		}
		map.put("access", true);
		return map;
	}

}
