package com.hcl.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;



public class UserServiceClientImpl implements UserServiceClient {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public UserServiceClientImpl(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	

	@Override
	public User getUserByName(String name) {
		User user=restTemplate.getForObject(serviceUrl+"/user/getUser/{name}", User.class,name);
		return user;
	}

}
