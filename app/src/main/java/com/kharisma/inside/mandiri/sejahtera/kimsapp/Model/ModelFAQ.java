package com.kharisma.inside.mandiri.sejahtera.kimsapp.Model;

public class ModelFAQ {
    private String titleFAQ, contenFAQ;

    public ModelFAQ(String titleFAQ, String contenFAQ) {
        this.titleFAQ = titleFAQ;
        this.contenFAQ = contenFAQ;
    }

    public String getTitleFAQ() {
        return titleFAQ;
    }

    public void setTitleFAQ(String titleFAQ) {
        this.titleFAQ = titleFAQ;
    }

    public String getContenFAQ() {
        return contenFAQ;
    }

    public void setContenFAQ(String contenFAQ) {
        this.contenFAQ = contenFAQ;
    }
}
