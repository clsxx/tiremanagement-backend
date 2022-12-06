package com.adesso.tireManagement.service;

import com.adesso.tireManagement.model.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccount(String username);
    public Boolean logIn(String username, String password, Boolean isAdminLogIn);
}
