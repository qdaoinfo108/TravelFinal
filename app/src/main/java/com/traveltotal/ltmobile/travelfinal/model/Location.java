package com.traveltotal.ltmobile.travelfinal.model;

public class Location {

    private int id_location;
    private String lThanhpho;
    private String lImageMain;
    private String lTitle;
    private int lRate;
    private String lAdress;
    private String lContent;
    private  String lCoordinates;
    private String lImg1;
    private String lImg2;
    private String lImg3;
    private String lImg4;

    public Location(String lThanhpho, String lImageMain, String lTitle, String lAdress, String lContent) {
        this.lThanhpho = lThanhpho;
        this.lImageMain = lImageMain;
        this.lTitle = lTitle;
        this.lAdress = lAdress;
        this.lContent = lContent;
    }

    public int getId_location() {
        return id_location;
    }

    public String getlThanhpho() {
        return lThanhpho;
    }

    public String getlImageMain() {
        return lImageMain;
    }

    public String getlTitle() {
        return lTitle;
    }

    public int getlRate() {
        return lRate;
    }

    public String getlAdress() {
        return lAdress;
    }

    public String getlContent() {
        return lContent;
    }

    public String getlCoordinates() {
        return lCoordinates;
    }

    public String getlImg1() {
        return lImg1;
    }

    public String getlImg2() {
        return lImg2;
    }

    public String getlImg3() {
        return lImg3;
    }

    public String getlImg4() {
        return lImg4;
    }
}