package com.hcl.accounts;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	@Override
	public List<Account> getAccountByUserId(int userid) {
		List<Account> lst=accountRepository.getAccountByUserId(userid);
		return lst;
	}
	@Override
	public String createAccount(Account acc) {

		Account tempacc=accountRepository.save(acc);
				String str="";
				if (tempacc != null) {
					str= "Account created successfully";
				} else {
					str= "Not Created";
				}
			
			return str;
	}
	@Override
	public String deleteAccountByAccountNum(int accnum) {
		boolean bool=accountRepository.existsById(accnum);
		String str="";
		if(bool==true) {
			accountRepository.deleteById(accnum);
			str="Account deleted successfully";
		} else {
			str="Account doesn't exist";
		}
		return str;
	}

}
