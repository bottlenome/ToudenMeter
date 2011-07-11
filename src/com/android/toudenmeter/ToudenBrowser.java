package com.android.toudenmeter;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ToudenBrowser {
	
	public static String get() throws Exception
	{
		String url = "http://www.tepco.co.jp/forecast/html/images/juyo-j.csv";
		HttpGet method = new HttpGet(url);
		DefaultHttpClient client = new DefaultHttpClient();
		// ÉwÉbÉ_Çê›íËÇ∑ÇÈ
		method.setHeader("Connection", "Keep-Alive");

		HttpResponse response = client.execute(method);
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
			throw new Exception("unable to get");
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
	
}
