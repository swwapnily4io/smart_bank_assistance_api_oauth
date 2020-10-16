package com.example.OauthExample.controller;

import java.util.Date;

public class Account {

  private String userName;
  private long accountNo;
  private double balance;
  private String createdOn;
  private String accountType;
  private String currencySymbol;
  
  public Account(String userName, long accountNo, double balance, String createdOn, String accountType,String currencySymbol) {
    super();
    this.userName = userName;
    this.accountNo = accountNo;
    this.balance = balance;
    this.createdOn = createdOn;
    this.accountType = accountType;
    this.currencySymbol = currencySymbol;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(long accountNo) {
    this.accountNo = accountNo;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }
  
  
  
}
