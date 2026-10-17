package com.example.ca1;
import java.time.LocalDate;

public class CampingArea {
    private String name;
    private String description;

    private CustomList<Plot> plots=new CustomList<>();

    public CampingArea(String name, String description) {
        this.name=name;
        this.description = description;
    }

    // Find available plot
    public Plot findAvailablePlot(LocalDate startDate,LocalDate endDate) {
        for(int i=0;i<plots.size();i++) {
            Plot plot=plots.get(i);

            if(plot.isAvailable(startDate,endDate)) {
                return plot;
            }
        }
        return null;
    }

    // Find available plot by type
    public Plot findAvailablePlotByType(LocalDate startDate,LocalDate endDate,String type) {
        for(int i=0;i<plots.size();i++) {
            Plot plot=plots.get(i);

            if(plot.getType().equalsIgnoreCase(type) &&
                    plot.isAvailable(startDate,endDate)) {
                return plot;
            }
        }
        return null;
    }

    // Find plot by guest preferences
    public Plot findMatchingPlot(LocalDate startDate,LocalDate endDate,String type,double maxPrice,double minSize,boolean electricity,int minBedrooms,int numberOfGuests) {
        for(int i=0;i<plots.size();i++) {
            Plot plot=plots.get(i);

            if(plot.getType().equalsIgnoreCase(type) &&
                    plot.getCostPerNight()<=maxPrice &&
                    plot.getSize()>=minSize &&
                    (!electricity || plot.isElectricity()) &&
                    plot.getBedrooms()>=minBedrooms &&
                    plot.getBeds()>=numberOfGuests &&
                    plot.isAvailable(startDate,endDate)) {
                return plot;
            }
        }
        return null;
    }

    // Find plot by number
    public Plot findPlot(int plotNum) {
        for(int i=0;i<plots.size();i++) {
            Plot plot=plots.get(i);

            if(plot.getPlotNum()==plotNum) {
                return plot;
            }
        }
        return null;
    }

    // Remove plot if no bookings
    public boolean removePlot(int plotNum) {
        for(int i=0;i<plots.size();i++) {
            Plot plot=plots.get(i);

            if(plot.getPlotNum()==plotNum) {
                if(plot.getBookings().size()>0) {
                    return false;
                }

                return plots.remove(i);
            }
        }
        return false;
    }

    public void addPlot(Plot plot){
        plots.addElement(plot);
    }





    public CustomList<Plot> getPlots() {
        return plots;
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
