package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelApproval {
    private String name, email, phoneNumber, store, address;

    public ModelApproval(String name, String email, String phoneNumber, String store, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.store = store;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
