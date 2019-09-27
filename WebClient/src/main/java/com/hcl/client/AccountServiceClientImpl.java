package com.hcl.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AccountServiceClientImpl implements AccountServiceClient {
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public AccountServiceClientImpl(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public List<Account> getAccountByUserId(int userid) {
		Account[] acc=restTemplate.getForObject(serviceUrl+"/account/getAccount/{id}", Account[].class,userid);
		return Arrays.asList(acc);
	}

	@Override
	public String createAccount(Account acc) {
		ResponseEntity<String> st=restTemplate.postForEntity(serviceUrl+"/createAccount", acc, String.class);
		return st.getBody();
	}

	@Override
	public String deleteAccountByAccountNum(int accnum) {
		ResponseEntity<String> st=restTemplate.postForEntity(serviceUrl+"/deleteAccount/{accnum}", accnum, String.class);
		return st.getBody();
	}
	
}
