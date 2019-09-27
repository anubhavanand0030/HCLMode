package com.hcl.client;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private int accountNum;

	private double amount;

	private char accountType;

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
