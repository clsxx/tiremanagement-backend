package com.adesso.tireManagement.experience;

import com.adesso.tireManagement.error.BusinessException;
import com.adesso.tireManagement.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Handles BusinessExceptions.
 */
@ControllerAdvice
public class TireManagementExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Method to handle all kinds of BusinessExceptions that could be thrown
     * @param ex
     * @return responseEntity
     */
    @ExceptionHandler({ BusinessException.class })
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<Object>(
                ex.getApiError(), new HttpHeaders(), ex.getApiError().getStatus());
    }

    /**
     * Handles method argument not valid Exception
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return new ResponseEntity<Object>(
                new ApiError(status, "Invalid input", ex.getMessage()), new HttpHeaders(), status);
    }
}
