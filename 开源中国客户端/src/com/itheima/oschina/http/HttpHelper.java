package com.itheima.oschina.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpHelper {

	public static HttpResponse  getResponse(String url){
		HttpResponse response = null;
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			response = httpClient.execute(httpGet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
