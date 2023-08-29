package com.blogBackend.blogBackendService.exception;

import com.blogBackend.blogBackendService.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest) {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(),
                                 exception.getMessage(),
                                 webRequest.getDescription(false)
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BlogAPIException.class)
    public ResponseEntity<ErrorDetails> handleBlogAPIException(BlogAPIException exception,
                                                               WebRequest webRequest) {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        webRequest.getDescription(false)
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                            WebRequest webRequest) {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        webRequest.getDescription(false)
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
