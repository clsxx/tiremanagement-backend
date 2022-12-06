package com.adesso.tireManagement.error;

import org.springframework.http.HttpStatus;

/**
 * Business Exception for a tire not found issue.
 */
public class TireNotFoundException extends BusinessException {

    /**
     * Creates Business Exception with httpStatus, title and message
     */
    public TireNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Not found", "Tire not found");
    }
}
