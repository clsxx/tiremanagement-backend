package com.adesso.tireManagement.service;

import com.adesso.tireManagement.error.*;
import com.adesso.tireManagement.model.Account;
import com.adesso.tireManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The business implementation of the account management.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    /**
     * Creates a new user or admin account.
     * @param account
     * @return account
     */
    public Account createAccount(Account account) {
        if(getAccount(account.getUsername()) != null){
            throw new AccountAlreadyExistsException();
        }
        return accountRepository.save(account);
    }

    /**
     * Retrieves account by username
     * @param username
     * @return account
     */
    public Account getAccount(String username) {
        return accountRepository.findTop1ByUsername(username);
    }

    /**
     * Check if user account with username and password exists,
     * is valid and if user is admin for logIn.
     *
     * @param username
     * @param password
     * @param isAdminLogIn
     * @return logInIsGranted
     */
    public Boolean logIn(String username, String password, Boolean isAdminLogIn){
        Account account = getAccount(username);
        if(account != null) {
            if (isAdminLogIn) {
                return adminLogIn(username, password, account);
            } else {
                return checkPassword(password, account.getPassword());
            }
        }
        throw new AccountNotFoundException();
    }

    /**
     * Checks if user has an admin account and checks the password.
     * @param username
     * @param password
     * @param account
     * @return adminLogInIsGranted
     */
    private static Boolean adminLogIn(String username, String password, Account account) {
        if(account.getIsAdmin()) {
            return checkPassword(password, account.getPassword());
        }
        throw new NoAdminAccountException();
    }

    /**
     * Checks the validity of the password.
     *
     * @param password
     * @param accountPassword
     * @return passwordIsValid
     */
    private static Boolean checkPassword(String password, String accountPassword) {
        if(password.equals(accountPassword)) {
            return Boolean.TRUE;
        }
        throw new InvalidPasswordException();
    }
}
