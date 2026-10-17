package com.example.ca1;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CampingAreaTest {

    @Test
    void findsAvailablePlot() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");

        area.addPlot(plot);

        assertEquals(plot,area.findAvailablePlot(
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15)));
    }

    @Test
    void returnsNullWhenNoPlots() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");

        assertNull(area.findAvailablePlot(
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15)));
    }

    @Test
    void doesNotFindBookedPlot() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","photo.jpg");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                null,
                plot
        );

        plot.addBooking(booking);
        area.addPlot(plot);

        assertNull(area.findAvailablePlot(
                LocalDate.of(2026,6,12),
                LocalDate.of(2026,6,14)));
    }

    @Test
    void findsPlotByType() {
        CampingArea area=new CampingArea("Camping Area","Different plots");

        Plot tent=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");
        Plot cabin=new Plot(2,"Cabin",true,80.0,50.0,2,4,"Kitchen","cabin.jpg");

        area.addPlot(tent);
        area.addPlot(cabin);

        assertEquals(tent,area.findAvailablePlotByType(
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                "Tent"));
    }

    @Test
    void findsPlotMatchingPreferences() {
        CampingArea area=new CampingArea("Camping Area","Different plots");

        Plot tent=new Plot(1,"Tent",false,20.0,20.0,0,0,"Shower","tent.jpg");
        Plot cabin=new Plot(2,"Cabin",true,80.0,50.0,2,4,"Kitchen","cabin.jpg");

        area.addPlot(tent);
        area.addPlot(cabin);

        assertEquals(cabin,area.findMatchingPlot(
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                "Cabin",100.0,40.0,true,2,4));
    }

    @Test
    void returnsNullWhenBudgetTooLow() {
        CampingArea area=new CampingArea("Camping Area","Different plots");

        Plot cabin=new Plot(2,"Cabin",true,80.0,50.0,2,4,"Kitchen","cabin.jpg");
        area.addPlot(cabin);

        assertNull(area.findMatchingPlot(
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                "Cabin",50.0,40.0,true,2,4));
    }

    @Test
    void rejectsPlotWithNotEnoughBeds() {
        CampingArea area=new CampingArea("Cabin Area","Cabins");

        Plot cabin=new Plot(1,"Cabin",true,80.0,50.0,2,2,"Kitchen","cabin.jpg");
        area.addPlot(cabin);

        assertNull(area.findMatchingPlot(
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                "Cabin",100.0,40.0,true,2,4));
    }

    @Test
    void findsPlotByNumber() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");

        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");
        area.addPlot(plot);

        assertEquals(plot,area.findPlot(1));
    }

    @Test
    void returnsNullForUnknownPlot() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");

        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");
        area.addPlot(plot);

        assertNull(area.findPlot(99));
    }

    @Test
    void removesEmptyPlot() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        area.addPlot(plot);

        assertTrue(area.removePlot(1));
        assertEquals(0,area.getPlots().size());
    }

    @Test
    void cannotRemoveUnknownPlot() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        area.addPlot(plot);

        assertFalse(area.removePlot(99));
        assertEquals(1,area.getPlots().size());
    }
    @Test
    void cannotRemoveBookedPlot() {
        CampingArea area=new CampingArea("Tent Area","Area for tents");
        Plot plot=new Plot(1,"Tent",true,25.0,30.0,0,0,"Shower","tent.jpg");

        Booking booking=new Booking(
                1,
                LocalDate.of(2026,6,10),
                LocalDate.of(2026,6,15),
                null,
                plot
        );

        plot.addBooking(booking);
        area.addPlot(plot);

        assertFalse(area.removePlot(1));
        assertEquals(1,area.getPlots().size());
    }
}