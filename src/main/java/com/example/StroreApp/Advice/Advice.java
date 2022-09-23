package com.example.StroreApp.Advice;

import com.example.StroreApp.Exceptions.ExceptionObject;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Exceptions.ResourceExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {
 @ExceptionHandler( ResourceExistException.class)
    public ExceptionObject resourceFound(ResourceExistException e){
     ExceptionObject exceptionObject=new ExceptionObject();
     exceptionObject.setMessage(e.getMessage());
     return exceptionObject;
 }
 @ExceptionHandler( NotFoundResource.class)
    public ExceptionObject resourceNotFound(NotFoundResource e){
     ExceptionObject exceptionObject=new ExceptionObject();
     exceptionObject.setMessage(e.getMessage());
     return exceptionObject;
 }


}
