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
}