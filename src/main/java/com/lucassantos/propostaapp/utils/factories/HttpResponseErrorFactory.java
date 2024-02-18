package com.lucassantos.propostaapp.utils.factories;

import com.lucassantos.propostaapp.controllers.exceptions.dtos.FieldValidation;
import com.lucassantos.propostaapp.controllers.exceptions.dtos.HttpResponseErrorDto;


import java.time.LocalDateTime;
import java.util.List;

public final class HttpResponseErrorFactory {
    private HttpResponseErrorFactory(){}


    public static HttpResponseErrorDto makeHttpResponseError(
            Integer status, String error, String exceptionMessage,
            String requestUrl, List<FieldValidation> errors){
        return HttpResponseErrorDto
                .builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error(error)
                .exceptionMessage(exceptionMessage)
                .urlPath(requestUrl)
                .errorFields(errors)
                .build();
    }
}



