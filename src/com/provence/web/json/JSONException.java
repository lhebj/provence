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
 * The JSONException is thrown by the JSON.org classes then things are amiss.
 * 
 * @author JSON.org
 * @version 2
 */
public class JSONException extends Exception {
	private Throwable cause;

	/**
	 * Constructs a JSONException with an explanatory message.
	 * 
	 * @param message
	 *            Detail about the reason for the exception.
	 */
	public JSONException(String message) {
		super(message);
	}

	public JSONException(Throwable t) {
		super(t.getMessage());
		this.cause = t;
	}

	@Override
	public Throwable getCause() {
		return this.cause;
	}
}
