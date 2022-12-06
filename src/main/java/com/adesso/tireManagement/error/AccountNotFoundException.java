package com.adesso.tireManagement.error;

import org.springframework.http.HttpStatus;

/**
 * Business Exception for an account not found issue.
 */
public class AccountNotFoundException extends BusinessException {

    /**
     * Creates Business Exception with httpStatus, title and message
     */
    public AccountNotFoundException() {
        super(HttpStatus.NOT_FOUND, "No account", "Account not found");
    }
}
