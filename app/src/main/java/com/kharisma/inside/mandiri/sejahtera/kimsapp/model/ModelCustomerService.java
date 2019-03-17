package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelCustomerService {
    private String place, person, office, phone;

    public ModelCustomerService(String place, String person, String office, String phone) {
        this.place = place;
        this.person = person;
        this.office = office;
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
