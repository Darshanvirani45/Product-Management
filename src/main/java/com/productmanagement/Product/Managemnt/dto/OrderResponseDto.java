package com.productmanagement.Product.Managemnt.dto;


import com.productmanagement.Product.Managemnt.models.Bill;
import com.productmanagement.Product.Managemnt.models.Order;
import org.springframework.http.HttpStatus;

public class OrderResponseDto {

    private Bill response;

    private String message;

    private HttpStatus httpStatus;


    public OrderResponseDto() {
        this.message="order not placed";
        this.httpStatus=HttpStatus.BAD_REQUEST;
    }

    public OrderResponseDto(HttpStatus httpStatus, String message, Bill response) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.response = response;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bill getResponse() {
        return response;
    }

    public void setResponse(Bill response) {
        this.response = response;
    }
}
