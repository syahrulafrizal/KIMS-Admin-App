package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelRiwayatScan {
    private String qrCode, tanggal;

    public ModelRiwayatScan(String qrCode, String tanggal) {
        this.qrCode = qrCode;
        this.tanggal = tanggal;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
