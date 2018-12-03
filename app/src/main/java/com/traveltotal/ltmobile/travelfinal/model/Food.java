package com.traveltotal.ltmobile.travelfinal.model;

public class Food {

    private String fTitle;
    private String fImage;
    private double fPrice;
    private String fAdress;
    private String fCity;
    private  String fSDT;
    private String fContent;
    private int frate;

    public Food() {
    }

    public Food(String fTitle, String fImage, double fPrice, String fAdress, String fCity, String fSDT, String fContent, int frate) {
        this.fTitle = fTitle;
        this.fImage = fImage;
        this.fPrice = fPrice;
        this.fAdress = fAdress;
        this.fCity = fCity;
        this.fSDT = fSDT;
        this.fContent = fContent;
        this.frate = frate;
    }

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getfImage() {
        return fImage;
    }

    public void setfImage(String fImage) {
        this.fImage = fImage;
    }

    public double getfPrice() {
        return fPrice;
    }

    public void setfPrice(double fPrice) {
        this.fPrice = fPrice;
    }

    public String getfAdress() {
        return fAdress;
    }

    public void setfAdress(String fAdress) {
        this.fAdress = fAdress;
    }

    public String getfCity() {
        return fCity;
    }

    public void setfCity(String fCity) {
        this.fCity = fCity;
    }

    public String getfSDT() {
        return fSDT;
    }

    public void setfSDT(String fSDT) {
        this.fSDT = fSDT;
    }

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public int getFrate() {
        return frate;
    }

    public void setFrate(int frate) {
        this.frate = frate;
    }
}
