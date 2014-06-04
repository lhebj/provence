package com.provence.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpClientUtil {
	private static HttpClientUtil instance = new HttpClientUtil();
	private final static Log log = LogFactory.getLog(HttpClientUtil.class.getName());

	public static HttpClientUtil getInstance() {
		if (instance == null)
			instance = new HttpClientUtil();
		return instance;
	}

	/**
	 * Use get method
	 * 
	 * @param queryUrl
	 * @return
	 */
	public String getResponseByGetMethod(final String queryUrl, boolean syn) {
		if (syn) {
			new Thread() {
				@Override
				public void run() {
					getHttpClientResponseByGetMethod(queryUrl);
				}
			}.start();
			return null;
		} else {
			return this.getHttpClientResponseByGetMethod(queryUrl);
		}
	}

	public String getHttpClientResponseByGetMethod(String queryUrl) {
		HttpClient httpClient = new HttpClient();
		// Create a method instance.
		GetMethod getMethod = new GetMethod(queryUrl);
		// Provide custom retry handler is necessary
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(1, false));
		httpClient.getParams().setParameter("http.socket.timeout", new Integer(10000));

		try {
			// Execute the method.
			int statusCode = httpClient.executeMethod(getMethod);

			if (statusCode != HttpStatus.SC_OK) {
				log.error("GetMethod failed: " + getMethod.getStatusLine());
			}

			// Read the response body.
			InputStream is = getMethod.getResponseBodyAsStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder responseString = new StringBuilder();
			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					responseString.append(line + "/n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();

				}
			}
			// byte[] responseBody = getMethod.getResponseBody();
			//
			// String responseString = new String(responseBody, "utf-8");

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary
			// data
			return responseString.toString();

		} catch (HttpException e) {
			log.error("Fatal protocol violation: " + e.getMessage() + ", http request: " + queryUrl);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Fatal transport error: " + e.getMessage() + ", http request: " + queryUrl);
			// e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return null;
	}

	/**
	 * Use post method
	 * 
	 * @param queryUrl
	 * @param param
	 * @return
	 */
	public String getResponseByPostMethod(String queryUrl, Map<String, String> param) {
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(queryUrl);
		// Provide custom retry handler is necessary
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(1, false));
		httpClient.getParams().setParameter("http.socket.timeout", new Integer(10000));
		for (String key : param.keySet()) {
			postMethod.addParameter(new NameValuePair(key, param.get(key)));
		}
		try {
			int statusCode = httpClient.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {
				log.error("PostMethod failed: " + postMethod.getStatusLine());
			}
			try {
				return new String(postMethod.getResponseBody(), "utf-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			postMethod.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return null;
	}

	public static void main(String[] args) {
		// for(int i=0;i<1000;i++){
		System.out.println(HttpClientUtil.getInstance().getResponseByGetMethod("http://ad.ablesky-a.com:8080/ableskyadvertisement/courseAdIncome.do?action=getAdIncomeRecord", false));
		// System.out.println(i);
		// }
		// System.out.println(i);
	}

}
