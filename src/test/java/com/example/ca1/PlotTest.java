package com.example.ca1;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PlotTest {
    @Test
    void newPlotHasNoBookings() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        assertEquals(0,plot.getBookings().size());
    }

    @Test
    void addingBookingIncreasesSize() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        Booking booking=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,plot);
        plot.addBooking(booking);
        assertEquals(1,plot.getBookings().size());
    }

    // Check if plot unavailable for overlapping dates
    @Test
    void plotIsUnavailableForOverlappingDates() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        Booking booking=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,plot);
        plot.addBooking(booking);

        assertFalse(plot.isAvailable(LocalDate.of(2026,6,12),LocalDate.of(2026,6,18)));
    }

    // Check if overlapping booking denied
    @Test
    void cannotAddOverlappingBooking() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        Booking first=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,plot);
        Booking second=new Booking(2,LocalDate.of(2026,6,12),LocalDate.of(2026,6,18),null,plot);
        plot.addBooking(first);

        assertFalse(plot.addBooking(second));
        assertEquals(1,plot.getBookings().size());
    }

    // Check if bookings on different dates allowed
    @Test
    void canAddBookingsOnDifferentDates() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        Booking first=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,plot);
        Booking second=new Booking(2,LocalDate.of(2026,6,15),LocalDate.of(2026,6,20),null,plot);

        assertTrue(plot.addBooking(first));
        assertTrue(plot.addBooking(second));
        assertEquals(2,plot.getBookings().size());
    }

    @Test
    void cancelBookingRemovesIt() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        Booking booking=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,plot);
        plot.addBooking(booking);

        assertTrue(plot.cancelBooking(1));
        assertEquals(0,plot.getBookings().size());
    }

    @Test
    void cannotCancelNonExistingBooking() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");
        Booking booking=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,plot);
        plot.addBooking(booking);

        assertFalse(plot.cancelBooking(5));
        assertEquals(1,plot.getBookings().size());
    }

    @Test
    void addedBookingIsConfirmed() {
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                null,
                plot
        );

        assertTrue(plot.addBooking(booking));
        assertEquals("Confirmed",booking.getStatus());
    }
}