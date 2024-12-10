package com.productmanagement.Product.Managemnt.advicer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodException(MethodArgumentNotValidException exception){
        Map<String,String> map=new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(),fieldError.getDefaultMessage()));

        return map;
    }

    @ExceptionHandler(ArithmeticException.class)
    public void add(ArithmeticException e){
        System.out.println(e.getMessage());
    }
}
