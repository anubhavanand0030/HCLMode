package com.hcl.accounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	@RequestMapping("/getAccount/{id}")
	public ResponseEntity<List<Account>> getAccount(@PathVariable("id") int id) {
		return new ResponseEntity<List<Account>>(accountService.getAccountByUserId(id), new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping("/createAccount")
	public ResponseEntity<String> createAccount(@RequestBody Account acc) {
		return new ResponseEntity<String>(accountService.createAccount(acc), new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping("/deleteAccount/{accnum}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accnum") int accnum) {
		return new ResponseEntity<String>(accountService.deleteAccountByAccountNum(accnum), new HttpHeaders(), HttpStatus.OK);
	}
}
