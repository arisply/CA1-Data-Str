package com.example.ca1;
import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private  LocalDate startDate;
    private LocalDate endDate;
    private Guest guest;
    private Plot plot;

    public Booking(int bookingId,LocalDate startDate,LocalDate endDate,Guest guest,Plot plot) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean hasValidDates(){
        return startDate!=null
                &&endDate!=null
                &&endDate.isAfter(startDate);
    }

    @Override
    public String toString() {
        return"Booking "+bookingId+": "+startDate+" to "+endDate;
    }
}