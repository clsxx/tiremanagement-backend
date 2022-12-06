package com.adesso.tireManagement.error;

import org.springframework.http.HttpStatus;

/**
 * Business Exception for an account already exists issue.
 */
public class AccountAlreadyExistsException extends BusinessException {

    /**
     * Creates Business Exception with httpStatus, title and message
     */
    public AccountAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Already exists", "Account already exists");
    }
}
