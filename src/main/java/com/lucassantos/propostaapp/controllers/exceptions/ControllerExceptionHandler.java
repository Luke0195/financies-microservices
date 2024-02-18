package com.lucassantos.propostaapp.controllers.exceptions;

import com.lucassantos.propostaapp.controllers.exceptions.dtos.FieldValidation;
import com.lucassantos.propostaapp.controllers.exceptions.dtos.HttpResponseErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponseErrorDto> validationHibernateFields(HttpServletRequest request, MethodArgumentNotValidException e){
        List<FieldValidation> errors = new ArrayList<>();
        e.getFieldErrors().forEach(x -> {
            String fieldName = x.getField();
            String fieldDescription = x.getDefaultMessage();
            errors.add(FieldValidation.builder().fieldName(fieldName).fieldDescription(fieldDescription).build());
        });
        HttpResponseErrorDto httpResponseErrorDto = HttpResponseErrorDto
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Fails to validate fields check the errors_fields list")
                .exceptionMessage("Hibernate Validation Exception ")
                .urlPath(request.getRequestURI())
                .errorFields(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpResponseErrorDto);
    }
}
