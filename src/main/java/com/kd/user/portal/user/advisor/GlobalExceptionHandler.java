package com.kd.user.portal.user.advisor;


import com.kd.user.portal.user.dto.GenericResponse;
import com.kd.user.portal.user.exception.UserValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<GenericResponse> handleDataIntegrityViolationException(UserValidationException ex) {
        return new ResponseEntity<>(new GenericResponse(ex.getMessage(), ex.getCause().getMessage().isBlank()? null:ex.getCause().getMessage()), HttpStatus.BAD_REQUEST);
    }
}
