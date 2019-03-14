package com.kharisma.inside.mandiri.sejahtera.kimsapp.Model;

public class ModelCustomerService {
    private String place, person, office;

    public ModelCustomerService(String place, String person, String office) {
        this.place = place;
        this.person = person;
        this.office = office;
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
}
