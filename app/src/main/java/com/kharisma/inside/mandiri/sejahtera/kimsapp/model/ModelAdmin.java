package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelAdmin {
    private String name, postion, phone, email;

    public ModelAdmin(String name, String postion, String phone, String email) {
        this.name = name;
        this.postion = postion;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
