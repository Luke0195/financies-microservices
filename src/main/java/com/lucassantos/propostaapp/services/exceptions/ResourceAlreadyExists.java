package com.lucassantos.propostaapp.services.exceptions;

public class ResourceAlreadyExists extends RuntimeException{

    public ResourceAlreadyExists(){}

    public ResourceAlreadyExists(String message){
        super(message);
    }
}
