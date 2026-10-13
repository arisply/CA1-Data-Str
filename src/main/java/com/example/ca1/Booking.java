package com.example.ca1;

public class Booking {
    private int bookingId;
    private String startDate;
    private String endDate;
    private Guest guest;
    private Plot plot;

    public Booking(int bookingId,String startDate,String endDate,Guest guest,Plot plot) {
        this.bookingId=bookingId;
        this.startDate=startDate;
        this.endDate=endDate;
        this.guest=guest;
        this.plot=plot;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return"Booking "+bookingId+": "+startDate+" to "+endDate;
    }
}