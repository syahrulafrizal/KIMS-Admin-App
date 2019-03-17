package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelClaim {
    private String email, nama, jenis, phone;
    private int nominal;

    public ModelClaim(String email, String nama, String jenis, String phone, int nominal) {
        this.email = email;
        this.nama = nama;
        this.jenis = jenis;
        this.phone = phone;
        this.nominal = nominal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
