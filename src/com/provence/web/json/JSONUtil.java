/* Copyright 2006-2008 AbleSky, Inc. All rights reserved.
This program is an unpublished work fully protected by the United States,
P.R. China and International copyright laws and is considered a trade secret
belonging to AbleSky, Inc. It is not to be divulged or used by parties who
have not received written authorization from AbleSky, Inc.
AbleSky, Inc.
539 Chiquita Ave
Mountain View, CA 94041, USA
http://www.ablesky.com
Email: support@ablesky.com
Copyright 2006-2008 AbleSky, Inc. All rights reserved.
 */
package com.provence.web.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Thanks: http://extjs.com/forum/showthread.php?t=7481
public class JSONUtil {

	/**
	 * ����JSON��ʽ��Ӧ��
	 */
	public static void buildJSON(HttpServletRequest request, HttpServletResponse response, JSONDataReader jsonReader) throws IOException {
		response.setContentType("text/json; charset=GBK");
		PrintWriter out = response.getWriter();
		out.write(jsonReader.toString());
	}
}
