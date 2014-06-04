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

/**
 * The <code>JSONString</code> interface allows a <code>toJSONString()</code>
 * method so that a class can change the behavior of
 * <code>JSONObject.toString()</code>, <code>JSONArray.toString()</code>,
 * and <code>JSONWriter.value(</code>Object<code>)</code>. The
 * <code>toJSONString</code> method will be used instead of the default
 * behavior of using the Object's <code>toString()</code> method and quoting
 * the result.
 */
public interface JSONString {
	/**
	 * The <code>toJSONString</code> method allows a class to produce its own
	 * JSON serialization.
	 * 
	 * @return A strictly syntactically correct JSON text.
	 */
	public String toJSONString();
}
