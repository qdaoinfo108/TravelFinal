package com.traveltotal.ltmobile.travelfinal.model;

public class Location {

    private String lThanhpho;
    private String lImageMain;
    private String lTitle;

    public Location(String lThanhpho, String lImageMain, String lTitle) {
        this.lThanhpho = lThanhpho;
        this.lImageMain = lImageMain;
        this.lTitle = lTitle;
    }

    public String getlThanhpho() {
        return lThanhpho;
    }

    public void setlThanhpho(String lThanhpho) {
        this.lThanhpho = lThanhpho;
    }

    public String getlImageMain() {
        return lImageMain;
    }

    public void setlImageMain(String lImageMain) {
        this.lImageMain = lImageMain;
    }

    public String getlTitle() {
        return lTitle;
    }

    public void setlTitle(String lTitle) {
        this.lTitle = lTitle;
    }
}