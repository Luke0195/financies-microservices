package com.lucassantos.propostaapp.controllers.exceptions;

import com.lucassantos.propostaapp.controllers.exceptions.dtos.FieldValidation;
import com.lucassantos.propostaapp.controllers.exceptions.dtos.HttpResponseData;
import com.lucassantos.propostaapp.services.exceptions.ResourceAlreadyExists;
import com.lucassantos.propostaapp.services.exceptions.ResourceNotExistsException;
import com.lucassantos.propostaapp.utils.factories.HttpResponseErrorFactory;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Integer BADREQUEST = HttpStatus.BAD_REQUEST.value();
    private static final Integer NOTFOUND = HttpStatus.NOT_FOUND.value();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponseData> validationHibernateFields(HttpServletRequest request, MethodArgumentNotValidException e) {
        List<FieldValidation> errors = new ArrayList<>();
        e.getFieldErrors().forEach(x -> {
            String fieldName = x.getField();
            String fieldDescription = x.getDefaultMessage();
            errors.add(FieldValidation.builder().fieldName(fieldName).fieldDescription(fieldDescription).build());
        });
        HttpResponseData httpResponseErrorDto = HttpResponseErrorFactory
                .makeHttpResponseError(
                        BADREQUEST,
                        "Fails to validate fields check the errors_fields list",
                        "Hibernate Validation Exception",
                        request.getRequestURI(),
                        errors);
        return ResponseEntity.status(BADREQUEST).body(httpResponseErrorDto);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<HttpResponseData> entityAlreadyExists(HttpServletRequest request, ResourceAlreadyExists exceptionMessage) {
        HttpResponseData httpResponseErrorDto = HttpResponseErrorFactory
                .makeHttpResponseError(
                        BADREQUEST,
                        "Entity already exists!",
                        exceptionMessage.getMessage(),
                        request.getRequestURI(),
                        null);
        return ResponseEntity.status(BADREQUEST).body(httpResponseErrorDto);
    }

    @ExceptionHandler(ResourceNotExistsException.class)
    public ResponseEntity<HttpResponseData> entityNotFound(HttpServletRequest request, ResourceNotExistsException exceptionMessage){
        HttpResponseData httpResponseErrorDto = HttpResponseErrorFactory
                .makeHttpResponseError(
                        NOTFOUND,
                        "Entity not found!",
                        exceptionMessage.getMessage(),
                        request.getRequestURI(),
                        new ArrayList<>());
        return ResponseEntity.status(BADREQUEST).body(httpResponseErrorDto);
    }
}
