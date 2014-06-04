package com.provence.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class RedirectResponseWrapper extends HttpServletResponseWrapper {
	private String redirect;

	public RedirectResponseWrapper(HttpServletResponse response) {
		super(response);

	}

	public String getRedirect() {
		return redirect;
	}

	public void sendRedirect(String string) throws IOException {
		redirect = string;
	}

}
