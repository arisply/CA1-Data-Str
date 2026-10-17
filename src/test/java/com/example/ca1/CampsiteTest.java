package com.example.ca1;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CampsiteTest {

    @Test
    void findsGuestBookings() {
        Campsite campsite=new Campsite("Waterford Camping","Waterford");
        CampingArea area=new CampingArea("Tent Area","Area for tents");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        Guest guest=new Guest(1,"Anna","2000-05-10","anna@email.com","");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                guest,
                plot
        );

        plot.addBooking(booking);
        area.addPlot(plot);
        campsite.addCampingArea(area);

        assertEquals(1,campsite.getGuestBookings(1).size());
        assertEquals(0,campsite.getGuestBookings(2).size());
    }

    @Test
    void addsPendingBooking() {
        Campsite campsite=new Campsite("Waterford Camping","Waterford");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                null,
                null
        );

        assertTrue(campsite.addPendingBooking(booking));
        assertEquals(1,campsite.getPendingBookings().size());
    }

    @Test
    void rejectsInvalidPendingBooking() {
        Campsite campsite=new Campsite("Waterford Camping","Waterford");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,15),
                LocalDate.of(2026,6,10),
                null,
                null
        );

        assertFalse(campsite.addPendingBooking(booking));
        assertEquals(0,campsite.getPendingBookings().size());
    }

    @Test
    void confirmsPendingBooking() {
        Campsite campsite=new Campsite("Waterford Camping","Waterford");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                null,
                null
        );

        campsite.addPendingBooking(booking);

        assertTrue(campsite.confirmPendingBooking(1,plot));
        assertEquals("Confirmed",booking.getStatus());
        assertEquals(plot,booking.getPlot());
        assertEquals(0,campsite.getPendingBookings().size());
        assertEquals(1,plot.getBookings().size());
    }

    @Test
    void cannotConfirmUnknownBooking() {
        Campsite campsite=new Campsite("Waterford Camping","Waterford");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        assertFalse(campsite.confirmPendingBooking(99,plot));
        assertEquals(0,plot.getBookings().size());
    }
}