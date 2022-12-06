package com.adesso.tireManagement.error;

import org.springframework.http.HttpStatus;

/**
 * Business Exception for an invalid password issue.
 */
public class InvalidPasswordException extends BusinessException {

    /**
     * Creates Business Exception with httpStatus, title and message
     */
    public InvalidPasswordException() {
        super(HttpStatus.FORBIDDEN, "Invalid password", "The password is incorrect");
    }
}
