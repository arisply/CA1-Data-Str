package com.example.ca1;

public class Campsite {
    private String name;
    private String address;

    private CustomList<CampingArea> campingAreas=new CustomList<>();
    private CustomList<Guest> guests=new CustomList<>();
    private CustomList<Booking> pendingBookings=new CustomList<>();

    public Campsite(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Add pending booking
    public boolean addPendingBooking(Booking booking) {
        if(booking==null||!booking.hasValidDates()) {
            return false;
        }

        if(!booking.getStatus().equals("Pending")) {
            return false;
        }
        pendingBookings.addElement(booking);
        return true;
    }

    // Get all pending bookings
    public CustomList<Booking> getPendingBookings() {
        return pendingBookings;
    }

    // Confirm pending booking
    public boolean confirmPendingBooking(int bookingId,Plot plot) {
        if(plot==null) {
            return false;
        }

        for(int i=0;i<pendingBookings.size();i++) {
            Booking booking=pendingBookings.get(i);

            if(booking.getBookingId()==bookingId) {
                if(plot.addBooking(booking)) {
                    booking.setPlot(plot);
                    pendingBookings.remove(i);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    // Find all bookings
    public CustomList<Booking> getGuestBookings(int guestId) {
        CustomList<Booking> result=new CustomList<>();

        for(int i=0;i<campingAreas.size();i++) {
            CampingArea area=campingAreas.get(i);

            for(int j=0;j<area.getPlots().size();j++) {
                Plot plot=area.getPlots().get(j);

                for(int k=0;k<plot.getBookings().size();k++) {
                    Booking booking=plot.getBookings().get(k);

                    if(booking.getGuest()!=null &&
                            booking.getGuest().getGuestId()==guestId) {
                        result.addElement(booking);
                    }
                }
            }
        }
        return result;
    }


    public void addGuest(Guest guest){
        guests.addElement(guest);
    }

    public CustomList<Guest> getGuests() {
        return guests;
    }

    public void addCampingArea(CampingArea area){
        campingAreas.addElement(area);
    }

    public CustomList<CampingArea> getCampingAreas() {
        return campingAreas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString(){
        return name+"-"+address;
    }



}
