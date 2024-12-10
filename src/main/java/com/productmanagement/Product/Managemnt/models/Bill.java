package com.productmanagement.Product.Managemnt.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.productmanagement.Product.Managemnt.models.embeddeble.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bill_id")
    private int billId;

    @NotNull(message = "product can not be null")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull(message = "customer can not be null")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

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


    @Column(name = "total-amount-payable")
    private double totalAmountPayAble;

    @Min(value = 1,message = "quantity must greater then 1")
    private int quantity;

    @OneToOne
    @NotNull
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Bill() {
    }

    public Bill(Address address, int billId, Customer customer, Product product, int quantity, double totalAmountPayAble) {
        this.address = address;
        this.billId = billId;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalAmountPayAble = totalAmountPayAble;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalAmountPayAble() {
        return totalAmountPayAble;
    }

    public void setTotalAmountPayAble(double totalAmountPayAble) {
        this.totalAmountPayAble = totalAmountPayAble;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
