package com.lucassantos.propostaapp.controllers.exceptions.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldValidation implements Serializable {

    @JsonProperty("field_name")
    private String fieldName;
    @JsonProperty("field_description")
    private String fieldDescription;

}
