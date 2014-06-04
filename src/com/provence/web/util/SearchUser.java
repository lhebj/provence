package com.provence.web.util;

import com.provence.pojo.User;


/**
 *
 */
public class SearchUser {

	public static User findUserByName(String uname) {
//		IAccountService accountService = (IAccountService) BeanFactoryUtil.getBean("accountService");
//		return accountService.findAccountByName(uname);
		return null;
	}

	public static boolean checkIfIsGuest(String uname) {
		if (StringUtil.isNull(uname) || uname.equalsIgnoreCase(CommonStaticConst.GUEST)) {
			return true;
		}
		return false;
	}
}
