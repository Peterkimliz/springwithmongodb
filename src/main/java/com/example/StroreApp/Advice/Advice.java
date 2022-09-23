package com.example.StroreApp.Advice;

import com.example.StroreApp.Exceptions.ExceptionObject;
import com.example.StroreApp.Exceptions.NotFoundResource;
import com.example.StroreApp.Exceptions.ResourceExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<ExceptionObject> inputsValidation(MethodArgumentNotValidException ex) {
  ExceptionObject exceptionObject = new ExceptionObject();
  ex.getBindingResult().getFieldErrors().forEach(e -> {
   exceptionObject.setMessage(e.getDefaultMessage());
  });
  return new ResponseEntity<ExceptionObject>(exceptionObject, HttpStatus.CONFLICT);
 }
 @ExceptionHandler( ResourceExistException.class)
    public ResponseEntity<ExceptionObject >resourceFound(ResourceExistException e){
     ExceptionObject exceptionObject=new ExceptionObject();
     exceptionObject.setMessage(e.getMessage());
     return new ResponseEntity<ExceptionObject>(exceptionObject,HttpStatus.CONFLICT);
 }
 @ExceptionHandler( NotFoundResource.class)
    public ResponseEntity< ExceptionObject> resourceNotFound(NotFoundResource e){
     ExceptionObject exceptionObject=new ExceptionObject();
     exceptionObject.setMessage(e.getMessage());
     return new ResponseEntity<>(exceptionObject,HttpStatus.NOT_FOUND);
 }


}
