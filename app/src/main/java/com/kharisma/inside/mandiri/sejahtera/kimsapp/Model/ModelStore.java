package com.kharisma.inside.mandiri.sejahtera.kimsapp.Model;

public class ModelStore {
    String storeName, stroreAddress, storePhone, storeArea;

    public ModelStore(String storeName, String stroreAddress, String storePhone, String storeArea) {
        this.storeName = storeName;
        this.stroreAddress = stroreAddress;
        this.storePhone = storePhone;
        this.storeArea = storeArea;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStroreAddress() {
        return stroreAddress;
    }

    public void setStroreAddress(String stroreAddress) {
        this.stroreAddress = stroreAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreArea() {
        return storeArea;
    }

    public void setStoreArea(String storeArea) {
        this.storeArea = storeArea;
    }
}
