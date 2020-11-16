package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class GsonUtilService {
	  public String simpleJson(Object object){
	      Gson gson = new Gson();
	      String json = gson.toJson(object);
	      System.out.println(json);
	      return json;
	  }
}

