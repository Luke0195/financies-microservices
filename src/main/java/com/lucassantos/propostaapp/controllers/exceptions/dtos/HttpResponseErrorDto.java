package com.lucassantos.propostaapp.controllers.exceptions.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResponseErrorDto implements Serializable {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    @JsonProperty("exception_message")
    private String exceptionMessage;
    @JsonProperty("url_path")
    private String urlPath;

    @JsonProperty("error_fields")
    private List<FieldValidation> errorFields = new ArrayList<>();

}
