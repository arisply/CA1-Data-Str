package com.example.ca1;

public class Plot {
    private int plotNum;
    private String type;
    private boolean electricity;
    private double costPerNight;
    private double size;
    private int bedrooms;
    private int beds;
    private String facilities;
    private String photoURL;


    public Plot(int plotNum,String type,boolean electricity,double costPerNight, double size,int bedrooms, int beds,String facilities,String photoURL) {
        this.plotNum = plotNum;
        this.type=type;
        this.electricity=electricity;
        this.costPerNight=costPerNight;
        this.size=size;
        this.bedrooms=bedrooms;
        this.beds=beds;
        this.facilities=facilities;
        this.photoURL=photoURL;

    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }


    public int getPlotNum() {
        return plotNum;
    }

    public void setPlotNum(int plotNum) {
        this.plotNum = plotNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "Plot "+plotNum+" - "+type;
    }
}
