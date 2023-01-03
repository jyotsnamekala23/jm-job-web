package com.web.jobsentry.utils;

import java.util.HashMap;
import java.util.Map;

public class Descriptions {
	
	 Map<String, Map<String,String>> data = new HashMap<>();	 
	 
	 Map<String, String> sse = new HashMap<>();
	 Map<String, String> em = new HashMap<>();
	 
	 public Descriptions() {
		 buildData();
	 }
	 
	 void buildData(){
		 Map<String, String> se = loadSE();
		 Map<String, String> sse = loadSSE();
		 Map<String, String> em = loadEM();
		 data.put("se", se);
		 data.put("sse", sse);
		 data.put("em", em);
		 data.put("SE", se);
		 data.put("SSE", sse);
		 data.put("EM", em);
	 }
	 
	public Map<String, String> getData(String key){
		if(data.containsKey(key)) {
			return data.get(key);
		} else {
			buildData();
			return data.get(key);
		}
	}

	private Map<String, String> loadEM() {
		Map<String, String> em = new HashMap<>();
		em.put(Constants.TITLE, Constants.TITLE_EM);
		em.put(Constants.DESC, Constants.DESC_EM);
		em.put(Constants.QUAL, Constants.QUAL_EM);
		em.put(Constants.RESP, Constants.RESP_EM);
		return em;
	}

	private Map<String, String> loadSSE() {
		Map<String, String> sse = new HashMap<>();
		sse.put(Constants.TITLE, Constants.TITLE_SSE);
		sse.put(Constants.DESC, Constants.DESC_SSE);
		sse.put(Constants.QUAL, Constants.QUAL_SSE);
		sse.put(Constants.RESP, Constants.RESP_SSE);
		return sse;
	}

	private Map<String, String> loadSE() {
		Map<String, String> se = new HashMap<>();
		se.put(Constants.TITLE, Constants.TITLE_SE);
		se.put(Constants.DESC, Constants.DESC_SE);
		se.put(Constants.QUAL, Constants.QUAL_SE);
		se.put(Constants.RESP, Constants.RESP_SE);
		return se;
	}
	 
	 
}
