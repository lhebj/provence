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

// Custom JSONReader.java to wrap JSON for Ext JSON reader format
//
// Thanks: http://extjs.com/forum/showthread.php?t=7481
public class JSONDataReader extends JSONArray {

	private int recordCount = 0;

	public JSONDataReader() {
		super();
	}

	public JSONDataReader(Integer recordCount) {
		this();
		this.setRecordCount(recordCount);
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("{\"totalCount\":" + recordCount + ",\"rows\":");
		sb.append(super.toString());
		sb.append("}");
		return sb.toString();
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

}