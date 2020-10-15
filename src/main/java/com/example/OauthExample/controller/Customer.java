
package com.example.OauthExample.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Customer {

  @GetMapping("/login")
  public Map<String, Object> login(@RequestParam @NonNull String userName, @RequestParam @NonNull String password) {
    Map<String, Object> response = new HashMap<String, Object>();
    System.out.println("Printing params " + userName + "password " + userName);
    if (null != userName && !StringUtils.isEmpty(userName) && userName.equalsIgnoreCase("steve")
            && password.equalsIgnoreCase("steve123")) {
      response.put("status", HttpStatus.OK);
      response.put("loginStatus", "success");
      return response;
    }
    response.put("status", HttpStatus.NOT_FOUND);
    response.put("loginStatus", "failed");
    return response;
  }

  @GetMapping("/getAccounts")
  @PreAuthorize("!hasAuthority('USER')")
  public Map<String, Object> getAccounts(@RequestParam @NonNull String userName,OAuth2Authentication authentication) {
    Map<String, Object> response = new HashMap<String, Object>();
    List<Account> accounts = new ArrayList<Account>();
    Account ac1 = new Account("Steve Smith", 382799319, 1920.10, new Date("12-Jan-2004"), "Savings Account");
    Account ac2 = new Account("Steve Smith", 382799319, 10.10, new Date("12/12/2007"), "Current Account");
    accounts.add(ac1);
    accounts.add(ac2);
    System.out.println("Printing userName " + userName);
    if (userName.equalsIgnoreCase("steve")) {
      response.put("status", HttpStatus.OK);
      response.put("statusMsg", "Success");
      response.put("accountList", accounts);
      return response;
    }
    response.put("status", HttpStatus.NOT_FOUND);
    response.put("statusMsg", "Failed to get Account Details");
    return response;
  }

  @GetMapping("/getTransactionHistory")
  @PreAuthorize("!hasAuthority('USER')")
  public Map<String, Object> getTransactionHistory(@RequestParam @NonNull long accountNo,OAuth2Authentication authentication) {
    Map<String, Object> response = new HashMap<String, Object>();
    List<TransactionHistory> history = new ArrayList<TransactionHistory>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Account acc = new Account("Steve Smith", 382799319, 1920.10, new Date("12-Jan-2004"), "Savings Account");
    
    System.out.println("Printing accountNo " + accountNo);
    TransactionHistory history1 = new TransactionHistory(sdf.format(new Date("12-Jan-2004")), 231332133, "Debit",
            "ACH-D Bill Payment HDFC", 100);
    TransactionHistory history2 = new TransactionHistory(sdf.format(new Date("18-Jan-2004")), 231300039, "Debit", "Amazon Purchase",
            1103);
    TransactionHistory history3 = new TransactionHistory(sdf.format(new Date("21-Jan-2004")), 241432143, "Credit", "ACH-D Interest",
            59.0);
    history.add(history1);
    history.add(history2);
    history.add(history3);
    if (accountNo == 123456) {
      response.put("status", HttpStatus.OK);
      response.put("statusMsg", "Success");
      response.put("historyList", history);
      response.put("account", acc);
      return response;
    }
    if (accountNo == 654321) {
      response.put("status", HttpStatus.OK);
      response.put("statusMsg", "Success");
      response.put("historyList", history);
      return response;
    }
    response.put("status", HttpStatus.NOT_FOUND);
    response.put("statusMsg", "Failed to get Transaction Details for account - " + accountNo);
    return response;
  }
}
