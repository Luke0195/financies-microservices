package com.lucassantos.propostaapp.dtos.responsestatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;


public abstract class HttpResponseData implements Serializable {
    protected LocalDateTime timestamp;
    protected Integer status;
    protected String error;
    @JsonProperty("exception_message")
    protected String exceptionMessage;
    @JsonProperty("url_path")
    protected String urlPath;

}
