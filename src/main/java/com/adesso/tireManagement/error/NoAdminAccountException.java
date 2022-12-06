package com.adesso.tireManagement.error;

import org.springframework.http.HttpStatus;

/**
 * Business Exception for no admin account issue.
 */
public class NoAdminAccountException extends BusinessException {

    /**
     * Creates Business Exception with httpStatus, title and message
     */
    public NoAdminAccountException() {
        super(HttpStatus.FORBIDDEN, "No admin", "No such admin account");
    }
}
