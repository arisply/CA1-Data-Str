package com.example.ca1;

public class CampingArea {
    private String name;
    private String description;

    private CustomList<Plot> plots=new CustomList<>();

    public void addPlot(Plot plot){
        plots.addElement(plot);
    }

    public CustomList<Plot> getPlots() {
        return plots;
    }

    public CampingArea(String name, String description) {
        this.name=name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return name+"-"+description;
    }
}
