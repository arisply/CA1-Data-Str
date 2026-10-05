package com.example.ca1;

public class TestList {

    public static void main(String[] args) {

        Campsite campsite = new Campsite("Waterford Camping", "Waterford");

        CampingArea area = new CampingArea("Tent Area", "Area for tents");

        Plot plot = new Plot(
                1,
                "Tent",
                true,
                25.00,
                30.0,
                0,
                0,
                "Shower",
                "https://example.com/tent1.jpg"
        );

        area.addPlot(plot);

        campsite.addCampingArea(area);

        area.getPlots().printList();
    }
}