package com.productmanagement.Product.Managemnt.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private int customerId;


    @Column(name = "customer_name")
    @NotBlank(message = "invalid customer name")
        private String customerName;

    @Column(name="phone_number",unique = true)
    @Pattern(regexp = "^[1-9][0-9]{9}$",message = "invalid phone number")
    @NotBlank(message = "phoneNumber customer name")
    private String phoneNumber;

    @Column(name="email",unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z A-Z]{2,3}$",message = "invalid email")
    private String email;

    @ManyToMany(mappedBy = "customerList")
    private List<Product> productList;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Order> orderList;

    @OneToMany(mappedBy = "customer")
    private List<Bill> bills;

    public Customer() {
        this.productList=new ArrayList<>();
        this.orderList=new ArrayList<>();
        this.bills=new ArrayList<>();
    }

    public Customer(List<Bill> bills, int customerId, String customerName, String email, List<Order> orderList, String phoneNumber, List<Product> productList) {
        this.bills = bills;
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.orderList = orderList;
        this.phoneNumber = phoneNumber;
        this.productList = productList;
    }

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "bills=" + bills +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", orderList=" + orderList +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", productList=" + productList +
                '}';
    }
}
