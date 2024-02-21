package com.lucassantos.propostaapp.dtos.responsestatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucassantos.propostaapp.controllers.exceptions.dtos.FieldValidation;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class BadRequestDto {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    @JsonProperty("exception_message")
    private String exceptionMessage;
    @JsonProperty("url_path")
    private String urlPath;

    @JsonProperty("error_fields")
    private List<FieldValidation> errorFields = new ArrayList<>();

    private BadRequestDto(){}



}
