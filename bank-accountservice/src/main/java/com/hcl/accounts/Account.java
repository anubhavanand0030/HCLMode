package com.hcl.accounts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	private static final long SerialVersionUID=1L;

	@Id
	@Column(name="accountnum")
	private int accountNum;
	@Column
	private double amount;
	@Column(name="accounttype")
	private char accountType;
	@Column
	private int userId;
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public char getAccountType() {
		return accountType;
	}
	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
