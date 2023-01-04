package com.adesso.tireManagement.experience;

import com.adesso.tireManagement.model.Account;
import com.adesso.tireManagement.service.AccountService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * AccountController handles all REST-Calls to Account.
 */
@RestController
@RequestMapping("account")
@CrossOrigin
public class AccountController {
    @Autowired
    AccountService accountService;

    /**
     * Creates a new account if the account does not exist already
     * @param account
     * @return account
     */
    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    /**
     * Check logInData for validity
     * @param json
     * @return accessGranted
     */
    @PostMapping("/logIn")
    public Boolean logIn(@RequestBody ObjectNode json) {
        String username = (json.get("username") != null) ? json.get("username").asText() : null;
        String password = (json.get("password") != null) ? json.get("password").asText() : null;
        Boolean isAdminLogIn = (json.get("isAdminLogIn") != null) ? json.get("isAdminLogIn").asBoolean() : null;

        return accountService.logIn(username, password, isAdminLogIn);
    }
}
