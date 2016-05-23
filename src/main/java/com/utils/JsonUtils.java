package com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.chanjar.weixin.common.util.StringUtils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtils {

	public static ObjectMapper objectMapper = new ObjectMapper();

	public static String obj2Json(Object object) {
		String str = "";
		try {
			if (null != object) {
				str = objectMapper.writeValueAsString(object);
			}
			return str;
		} catch (Exception e) {
			throw new RuntimeException("string to json error...");
		}
	}

	public static List<Map<String, String>> json2List(String json) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			if (StringUtils.isNotBlank(json)) {
				list = objectMapper.readValue(json,
						new TypeReference<List<Map<String, String>>>() {
						});
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException("json to list error...");
		}
	}

	public static Map<String, String> json2Map(String json) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (StringUtils.isNotBlank(json)) {
				map = objectMapper.readValue(json,
						new TypeReference<Map<String, String>>() {
						});
			}
			return map;
		} catch (Exception e) {
			throw new RuntimeException("json to map error...");
		}
	}

	public static Map<String, Object> json2MapObject(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isNotBlank(json)) {
				map = objectMapper.readValue(json,
						new TypeReference<Map<String, Object>>() {
						});
			}
			return map;
		} catch (Exception e) {
			throw new RuntimeException("json to map object error...");
		}
	}

}
