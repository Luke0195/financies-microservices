package com.lucassantos.propostaapp.dtos.responsestatus;

import com.lucassantos.propostaapp.controllers.exceptions.dtos.HttpResponseData;

public interface HttpResponseDataFactory {

    HttpResponseData makeHttpResponse(HttpResponseData httpResponseData);
}
