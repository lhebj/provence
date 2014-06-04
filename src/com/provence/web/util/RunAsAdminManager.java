package com.provence.web.util;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;

import com.provence.pojo.User;

public class RunAsAdminManager {
	public static void authenticationAsAdmin(AuthenticationProvider daoAuthenticationProvider) {
		Authentication adminAuth = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(CommonStaticConst.ADMIN, SearchUser.findUserByName(CommonStaticConst.ADMIN).getPasswordU()));
		SecurityContextHolder.getContext().setAuthentication(adminAuth);
	}

	public static void authenticationAsGuest(AuthenticationProvider daoAuthenticationProvider) {
//		Authentication guestAuth = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken("guest", SearchUser.findAccountByName("guest").getPassword()));
		SecurityContextHolder.getContext().setAuthentication(null);
	}

	public static void authenticationRestore(AuthenticationProvider daoAuthenticationProvider, User user) {
		Authentication auth = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUsernameU(), user.getPasswordU()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
