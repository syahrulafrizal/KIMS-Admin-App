package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelProduct {
    private String serialNumber, product, claimBy, status, qrCode;
    private int point, imgProduct;

    public ModelProduct(String serialNumber, String product, String claimBy, String status, String qrCode, int point, int imgProduct) {
        this.serialNumber = serialNumber;
        this.product = product;
        this.claimBy = claimBy;
        this.status = status;
        this.qrCode = qrCode;
        this.point = point;
        this.imgProduct = imgProduct;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getClaimBy() {
        return claimBy;
    }

    public void setClaimBy(String claimBy) {
        this.claimBy = claimBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(int imgProduct) {
        this.imgProduct = imgProduct;
    }
}
