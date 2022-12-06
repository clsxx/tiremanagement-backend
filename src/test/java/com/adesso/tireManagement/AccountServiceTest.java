package com.adesso.tireManagement;

import com.adesso.tireManagement.error.AccountAlreadyExistsException;
import com.adesso.tireManagement.error.AccountNotFoundException;
import com.adesso.tireManagement.error.InvalidPasswordException;
import com.adesso.tireManagement.error.NoAdminAccountException;
import com.adesso.tireManagement.service.AccountService;
import com.adesso.tireManagement.model.Account;
import com.adesso.tireManagement.repository.AccountRepository;
import com.adesso.tireManagement.service.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    Account testAccount;
    Account testAdminAccount;

    @BeforeEach
    public void init() {
        testAccount = new Account("Hans Meier", "123", false);
        testAdminAccount = new Account("Max Mustermann", "567", true);
    }

    @Test
    public void createAccountTest() {
        // Test creating an account
        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(testAccount);

        Account account = accountService.createAccount(testAccount);

        Assertions.assertNotNull(account);
        Assertions.assertEquals(account, testAccount);


        // Test creating account when account already exists
        Mockito.when(accountRepository.findTop1ByUsername(Mockito.anyString()))
                .thenReturn(testAccount);
        Assertions.assertThrows(AccountAlreadyExistsException.class, () -> {
            accountService.createAccount(testAccount);
        });

    }

    @Test
    public void getAccountTest() {
        Mockito.when(accountRepository.findTop1ByUsername(Mockito.anyString()))
                .thenReturn(testAccount);

        Account account = accountService.getAccount(testAccount.getUsername());

        Assertions.assertNotNull(account);
        Assertions.assertEquals(account, testAccount);
    }

    @Test
    public void logInUserTest() {
        // Test with correct password
        Mockito.when(accountRepository.findTop1ByUsername(Mockito.anyString()))
                .thenReturn(testAccount);
        Boolean userLogInSuccess = accountService.logIn(testAccount.getUsername(), testAccount.getPassword(), Boolean.FALSE);
        Assertions.assertTrue(userLogInSuccess);

        // Test with wrong password
        Assertions.assertThrows(InvalidPasswordException.class, () -> {
            accountService.logIn(testAccount.getUsername(), "wrongPassword", Boolean.FALSE);
        });

        // Test no account exists
        Mockito.when(accountRepository.findTop1ByUsername(Mockito.anyString()))
                .thenReturn(null);
        Assertions.assertThrows(AccountNotFoundException.class, () -> {
            accountService.logIn(testAccount.getUsername(),
                    testAccount.getPassword(), Boolean.FALSE);
        });
    }

    @Test
    public void logInAdminTest() {
        // Test with admin user
        Mockito.when(accountRepository.findTop1ByUsername(Mockito.anyString()))
                .thenReturn(testAdminAccount);
        Boolean adminLogInSuccess = accountService.logIn(testAdminAccount.getUsername(), testAdminAccount.getPassword(), Boolean.TRUE);
        Assertions.assertTrue(adminLogInSuccess);

        // Test with non admin user
        testAdminAccount.setIsAdmin(Boolean.FALSE);
        Mockito.when(accountRepository.findTop1ByUsername(Mockito.anyString()))
                .thenReturn(testAdminAccount);
        Assertions.assertThrows(NoAdminAccountException.class, () -> {
                accountService.logIn(testAdminAccount.getUsername(), testAdminAccount.getPassword(), Boolean.TRUE);
        });
    }
}
