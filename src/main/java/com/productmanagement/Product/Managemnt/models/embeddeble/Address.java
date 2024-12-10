package com.productmanagement.Product.Managemnt.models.embeddeble;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private int pinCode;

    private String city;

    private String state;

    private String apartmentOrSociety;

    private int apartmentOrSocietyNumber;

    public Address() {
    }

    public Address(String apartmentOrSociety, int apartmentOrSocietyNumber, String city, int pinCode, String state) {
        this.apartmentOrSociety = apartmentOrSociety;
        this.apartmentOrSocietyNumber = apartmentOrSocietyNumber;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

    public int getApartmentOrSocietyNumber() {
        return apartmentOrSocietyNumber;
    }

    public void setApartmentOrSocietyNumber(int apartmentOrSocietyNumber) {
        this.apartmentOrSocietyNumber = apartmentOrSocietyNumber;
    }

    public String getApartmentOrSociety() {
        return apartmentOrSociety;
    }

    public void setApartmentOrSociety(String apartmentOrSociety) {
        this.apartmentOrSociety = apartmentOrSociety;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
