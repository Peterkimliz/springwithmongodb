package com.example.StroreApp.Exceptions;

public class NotFoundResource extends RuntimeException{
    public NotFoundResource(String message){
        super(message);
    }

}
