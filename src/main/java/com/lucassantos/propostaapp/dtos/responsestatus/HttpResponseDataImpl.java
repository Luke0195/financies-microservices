package com.lucassantos.propostaapp.dtos.responsestatus;

import com.lucassantos.propostaapp.controllers.exceptions.dtos.HttpResponseData;

public class HttpResponseDataImpl implements  HttpResponseDataFactory{
    @Override
    public HttpResponseData makeHttpResponse(HttpResponseData httpResponseData) {
        return httpResponseData;
    }
}
