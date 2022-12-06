package com.adesso.tireManagement.model;

import org.springframework.http.HttpStatus;


/**
 * ApiError with error information.
 */
public class ApiError {
    private HttpStatus status;
    private String title;
    private String message;

    /**
     * Creates ApiError.
     * @param status
     * @param message
     * @param title
     */
    public ApiError(HttpStatus status, String message, String title) {
        super();
        this.status = status;
        this.message = message;
        this.title = title;
    }

    /**
     * Get the status.
     * @return status
     */
    public HttpStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status.
     * @param status
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * Gets the message.
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the title.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
