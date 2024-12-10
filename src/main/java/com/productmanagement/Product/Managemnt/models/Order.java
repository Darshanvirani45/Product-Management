package com.productmanagement.Product.Managemnt.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.productmanagement.Product.Managemnt.models.embeddeble.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "customer can not be null")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "product can not be null")
    private Product product;

    @Min(value = 1,message = "quantity must greater then 1 or 1")
    private int quantity;


    @NotNull(message = "address can not be null")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "pinCode",column = @Column(name = "pin_code")),
            @AttributeOverride(name = "city",column = @Column(name = "city")),
            @AttributeOverride(name = "state",column = @Column(name = "state")),
            @AttributeOverride(name = "apartmentOrSociety",column = @Column(name = "apartment_or_society")),
                    @AttributeOverride(name = "apartmentOrSocietyNumber",column = @Column(name = "no"))
    })
    private Address address;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Bill bill;

    public Order(int orderId) {
        this.orderId = orderId;
    }
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Order() {
    }

    public Order(Address address, Customer customer, int orderId, Product product, int quantity) {
        this.address = address;
        this.customer = customer;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
