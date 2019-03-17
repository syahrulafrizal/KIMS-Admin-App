package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelSales {
    String salesName, salesEmail, salesHP;

    public ModelSales(String salesName, String salesEmail, String salesHP) {
        this.salesName = salesName;
        this.salesEmail = salesEmail;
        this.salesHP = salesHP;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getSalesEmail() {
        return salesEmail;
    }

    public void setSalesEmail(String salesEmail) {
        this.salesEmail = salesEmail;
    }

    public String getSalesHP() {
        return salesHP;
    }

    public void setSalesHP(String salesHP) {
        this.salesHP = salesHP;
    }
}
