package com.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.chanjar.weixin.common.util.StringUtils;
import okhttp3.*;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class HttpUtils {

	// 实例化Http请求
	static OkHttpClient client = new OkHttpClient();

	// 定义json提交头
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	// 上传文件
	public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

	/**
	 * 带参数的POST方法提交
	 * 
	 * @param url   url地址
	 * @return      返回map
	 */
	public static Map<String, String> postMethodByMap(String url, Map<String, String> params) {
		Map<String, String> map = new HashMap<String, String>();
		String resultContent =postMethodByStr(url, params);
		map = JsonUtils.json2Map(resultContent);
		return map;
	}
	
	/**
	 * 带参数的POST方法提交
	 * 
	 * @param url   url地址
	 * @param paramJson json参数
	 * @return      返回map
	 */
	public static Map<String, String> postMethodByMap(String url,String paramJson) {
		Map<String, String> map = new HashMap<String, String>();
		String resultContent =postMethodByStr(url, paramJson);
		map = JsonUtils.json2Map(resultContent);
		return map;
	}

	/**
	 * 带参数的POST方法提交
	 * 
	 * @param url   url地址
	 * @param paramJson json参数
	 * @return      返回json字符串
	 */
	public static String postMethodByStr(String url, String paramJson) {
		String resultContent = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = null;
		try {
			// 创建默认的httpClient实例.
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			
			//遍历map设置参数
			if (StringUtils.isNotBlank(paramJson)) {
				httpPost.setEntity(new StringEntity(paramJson, ContentType.APPLICATION_JSON));
			}
			// 请求执行
			CloseableHttpResponse response = httpclient.execute(httpPost);
			// 转换成字符串
			resultContent = new BasicResponseHandler().handleResponse(response);
			
		} catch (Exception e) {
			Logger.error(e);
		} finally {
			// 关闭连接,释放资源
			try {
				if (null != httpclient)
					httpclient.close();
			} catch (IOException e) {
				Logger.error(e);
			}
		}
		return resultContent;
	}
	
	/**
	 * 带参数的POST方法提交
	 * 
	 * @param url   url地址
	 * @return      返回json字符串
	 */
	public static String postMethodByStr(String url, Map<String, String> params) {
		String resultContent = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = null;
		try {
			// 创建默认的httpClient实例.
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			
			//遍历map设置参数
			if (null != params && params.size() > 0) {
				// 设置参数
				String paramJson = JsonUtils.obj2Json(params);
				httpPost.setEntity(new StringEntity(paramJson, ContentType.APPLICATION_JSON));
			}
			// 请求执行
			CloseableHttpResponse response = httpclient.execute(httpPost);
			// 转换成字符串
			resultContent = new BasicResponseHandler().handleResponse(response);
			
		} catch (Exception e) {
			Logger.error(e);
		} finally {
			// 关闭连接,释放资源
			try {
				if (null != httpclient)
					httpclient.close();
			} catch (IOException e) {
				Logger.error(e);
			}
		}
		return resultContent;
	}

	private static String getResponseString(HttpMethod post) throws IOException {
		InputStream resStream = post.getResponseBodyAsStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(resStream,
				"utf-8"));
		StringBuffer resBuffer = new StringBuffer();
		String resTemp = "";
		while ((resTemp = br.readLine()) != null) {
			resBuffer.append(resTemp);
		}
		String response = resBuffer.toString();
		resStream.close();
		post.releaseConnection();
		return response;
	}

	public static String getUrlContentByPost(String url,
			Map<String, String> param) throws Exception {
		PostMethod post = null;
		HttpClient client = null;
		String res = null;// 返回值
		try {
			client = new HttpClient();
			// 设置连接响应时间(连接超时)，如果在5000ms内不能建立连接，则报错
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(5000);
			// 设置处理响应时间(读超时)，如果连接成功9000ms没有返回数据，则报错
			client.getHttpConnectionManager().getParams().setSoTimeout(9000);
			post = new PostMethod(url);
			post.getParams().setContentCharset("utf-8");
			if (null != param) {
				// post.setParameter("redirect_uri", redirect_uri);
			}
			client.executeMethod(post);
			res = getResponseString(post);
		} finally {
			if (null != client && null != post) {
				post.releaseConnection();
			}
		}
		return res;
	}

	public static String getUrlContentByGet(String url) throws Exception {
		GetMethod get = null;
		HttpClient client = null;
		String res = null;// 返回值
		try {
			client = new HttpClient();
			// 设置连接响应时间(连接超时)，如果在5000ms内不能建立连接，则报错
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(5000);
			// 设置处理响应时间(读超时)，如果连接成功9000ms没有返回数据，则报错
			client.getHttpConnectionManager().getParams().setSoTimeout(9000);
			get = new GetMethod(url);
			get.getParams().setContentCharset("utf-8");
			client.executeMethod(get);
			res = getResponseString(get);
		} finally {
			if (null != client && null != get) {
				get.releaseConnection();
			}
		}
		return res;
	}

	// GET方式请求
	public static String GET(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	// GET方式请求
	public static Map<String, String> get2Map(String url) throws Exception {
		String str = getUrlContentByGet(url);
		System.out.println(str);
		return JsonUtils.json2Map(str);
	}

	// POST提交JSON
	public static String json(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	/**
	 * okHttp 提交Form
	 * @param url
     *        目标url
	 * @param map
     *        map参数
	 * @return
	 * @throws IOException
     */
	public static String post(String url,Map<String,Object> map) throws IOException {
		//遍历参数
		FormBody.Builder newFormBody = new FormBody.Builder();
		for(Map.Entry<String, Object> entry:map.entrySet()){
			newFormBody.add(entry.getKey(),entry.getValue()+"");
		}
		RequestBody formBody = newFormBody.build();

		Request request = new Request.Builder().url(url).post(formBody).build();

		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

	// 上传文件
	private static final String IMGUR_CLIENT_ID = "9199fdef135c122";
	private static final MediaType MEDIA_TYPE_PNG = MediaType
			.parse("audio/mp4");

	public static void run() throws Exception {
		File file = new File("D://xxx.mp4");

		RequestBody requestBody = new MultipartBody.Builder()
				.setType(MultipartBody.FORM)
				.addFormDataPart("agentid", "1")
				.addFormDataPart("type", "video")
				.addFormDataPart(
						"access_token",
						"Nt7vW11o90ExxbOC3wbg3tXXl-dXt672LK0bBeADfKtDAlLtpr073emyC9cCPD7eupV5RbkiL853aOEhiyeMGA")
				.addFormDataPart("media", "xxx.mp4",
						RequestBody.create(MEDIA_TYPE_PNG, file)).build();

		Request request = new Request.Builder()
				.header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
				.url("https://qyapi.weixin.qq.com/cgi-bin/material/add_material")
				.post(requestBody).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

	public static void main(String[] args) throws Exception {
		HttpUtils.run();
	}
}
