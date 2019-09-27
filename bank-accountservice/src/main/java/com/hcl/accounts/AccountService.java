package com.hcl.accounts;

import java.util.List;

public interface AccountService {
	public List<Account> getAccountByUserId(int userid);
	public String createAccount(Account acc);
	public String deleteAccountByAccountNum(int accnum);
}
