package com.adesso.tireManagement.error;

import com.adesso.tireManagement.model.ApiError;
import org.springframework.http.HttpStatus;

/**
 * Business Exception for business errors.
 */
public class BusinessException extends RuntimeException {

    /**
     * ApiError contains all relevant information for the error
     */
    private ApiError apiError;

    /**
     * Creates a BusinessException with title and message
     * @param status
     * @param title
     * @param message
     */
    public BusinessException(HttpStatus status, String title, String message) {
        this.apiError = new ApiError(status, message, title);
    }

    /**
     * Gets the api error.
     * @return apiError
     */
    public ApiError getApiError() {
        return apiError;
    }

    /**
     * Sets the api error.
     * @param apiError
     */
    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}
