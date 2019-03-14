package com.kharisma.inside.mandiri.sejahtera.kimsapp.Model;

public class ModelAdmin {
    private String name, postion;

    public ModelAdmin(String name, String postion) {
        this.name = name;
        this.postion = postion;
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
}
