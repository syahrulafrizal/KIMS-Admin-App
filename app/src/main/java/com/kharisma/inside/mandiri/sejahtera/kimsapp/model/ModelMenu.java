package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelMenu {
    private int titleMenu;
    private int imgMenu;

    public ModelMenu(int titleMenu, int imgMenu) {
        this.titleMenu = titleMenu;
        this.imgMenu = imgMenu;
    }

    public int getTitleMenu() {
        return titleMenu;
    }

    public void setTitleMenu(int titleMenu) {
        this.titleMenu = titleMenu;
    }

    public int getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(int imgMenu) {
        this.imgMenu = imgMenu;
    }
}
