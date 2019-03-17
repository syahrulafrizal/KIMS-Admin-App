package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelRiwayatReward {
    private String jenis, tanggal;
    private int nominal;

    public ModelRiwayatReward(String jenis, String tanggal, int nominal) {
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.nominal = nominal;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
