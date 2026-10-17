package com.example.ca1;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    void bookingWithCorrectDatesIsValid() {
        Booking booking = new Booking(
                1,
                LocalDate.of(2026, 6, 10),
                LocalDate.of(2026, 6, 15),
                null,
                null
        );

        assertTrue(booking.hasValidDates());
    }

    @Test
    void bookingWithEndDateBeforeStartDateIsInvalid() {
        Booking booking = new Booking(
                2,
                LocalDate.of(2026, 6, 15),
                LocalDate.of(2026, 6, 10),
                null,
                null
        );

        assertFalse(booking.hasValidDates());
    }

    @Test
    void bookingWithSameStartAndEndDateIsInvalid() {
        Booking booking = new Booking(
                3,
                LocalDate.of(2026, 6, 10),
                LocalDate.of(2026, 6, 10),
                null,
                null
        );

        assertFalse(booking.hasValidDates());
    }

    // Check if booking dates overlap
    @Test
    void overlappingBookingsReturnTrue() {
        Booking first=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,null);
        Booking second=new Booking(2,LocalDate.of(2026,6,12),LocalDate.of(2026,6,18),null,null);

        assertTrue(first.overlaps(second));
    }

    // Check if booking dates dont overlap
    @Test
    void bookingsOnDifferentDatesDoNotOverlap() {
        Booking first=new Booking(1,LocalDate.of(2026,6,10),LocalDate.of(2026,6,15),null,null);
        Booking second=new Booking(2,LocalDate.of(2026,6,15),LocalDate.of(2026,6,20),null,null);

        assertFalse(first.overlaps(second));
    }

    @Test
    void newBookingIsPending() {
        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                null,
                null
        );

        assertEquals("Pending",booking.getStatus());
    }
}