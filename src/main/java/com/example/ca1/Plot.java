package com.example.ca1;
import java.time.LocalDate;

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
    private CustomList<Booking> bookings=new CustomList<>();


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
    // Get all bookings
    public CustomList<Booking> getBookings() {
        return bookings;
    }

    // Add booking if available
    public boolean addBooking(Booking booking) {
        if(booking==null) {
            return false;
        }

        if(isAvailable(booking.getStartDate(),booking.getEndDate())) {
            bookings.addElement(booking);
            booking.setStatus("Confirmed");
            return true;
        }
        return false;
    }

    // Check if plot available for selected dates
    public boolean isAvailable(LocalDate startDate,LocalDate endDate) {
        Booking newBooking=new Booking(0,startDate,endDate,null,this);

        if(!newBooking.hasValidDates()) {
            return false;
        }

        for(int i=0;i<bookings.size();i++) {
            Booking existing=bookings.get(i);

            if(existing.overlaps(newBooking)) {
                return false;
            }
        }
        return true;
    }

    // Cancel booking by ID
    public boolean cancelBooking(int bookingId) {
        for(int i=0;i<bookings.size();i++) {
            Booking booking=bookings.get(i);

            if(booking.getBookingId()==bookingId) {
                bookings.remove(i);
                return true;
            }
        }
        return false;
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
