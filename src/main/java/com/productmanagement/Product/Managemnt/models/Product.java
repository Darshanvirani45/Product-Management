package com.productmanagement.Product.Managemnt.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_product")
public class Product {

    @Id
    @Column(name = "p_id")
    private int productId;

    @Column(name = "title")
    @NotEmpty(message = "invalid title")
    private String title;

    @Column(name="description")
    @NotEmpty(message = "invalid description")
    private String description;

    @Column(name = "mrp")
    @Min(value = 1,message = "mrp must 1 or greater then 1")
    private int mrp;

    @Column(name = "discount")
    @Max(value = 99,message = "discount must be smaller then 99")
    private double discount;

    @Column(name="current_price")
    @Min(1)
    private int currentPrice;

    @Column(name = "inventory_count")
    @Min(1)
    private int inventoryCount;

    @Column(name="gst")
    @Min(1)
    private double gst;

    @ManyToMany
    @JoinTable(
            name = "tbl_customer_product", // this name of table which we want to give
            joinColumns = @JoinColumn(name = "customer_id"), // primary table column
            inverseJoinColumns = @JoinColumn(name = "product_id") // child table column
    )
    private List<Customer> customerList;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Order> orderList;

    @OneToMany(mappedBy = "product")
    private List<Bill> bills;

    public Product() {
        this.customerList=new ArrayList<>();
        this.orderList=new ArrayList<>();
        this.bills=new ArrayList<>();
    }

    public Product(List<Bill> bills, int currentPrice, List<Customer> customerList, String description, double discount, double gst, int inventoryCount, int mrp, List<Order> orderList, int productId, String title) {
        this.bills = bills;
        this.currentPrice = currentPrice;
        this.customerList = customerList;
        this.description = description;
        this.discount = discount;
        this.gst = gst;
        this.inventoryCount = inventoryCount;
        this.mrp = mrp;
        this.orderList = orderList;
        this.productId = productId;
        this.title = title;
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
