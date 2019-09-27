package com.hcl.client;

import java.util.List;



public interface AccountServiceClient {
	public List<Account> getAccountByUserId(int userid);
	public String createAccount(Account acc);
	public String deleteAccountByAccountNum(int accnum);
}
