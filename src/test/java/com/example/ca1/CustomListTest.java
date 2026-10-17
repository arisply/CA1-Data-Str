package com.example.ca1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {

    @Test
    void emptyListHasSizeZero() {
        CustomList<String> list=new CustomList<>();

        assertEquals(0,list.size());
    }

    @Test
    void addingOneElementIncreasesSize() {
        CustomList<String> list=new CustomList<>();

        list.addElement("Tent");

        assertEquals(1,list.size());
    }

    @Test
    void addingThreeElementsIncreasesSize() {
        CustomList<String> list=new CustomList<>();

        list.addElement("Tent");
        list.addElement("Bungalow");
        list.addElement("Mobile Home");

        assertEquals(3,list.size());
    }

    @Test
    void removeFirstElement() {
        CustomList<String> list=new CustomList<>();
        list.addElement("Tent");
        list.addElement("Cabin");
        assertTrue(list.remove(0));
        assertEquals(1,list.size());
        assertEquals("Tent",list.get(0));
    }

    @Test
    void removeInvalidIndex() {
        CustomList<String> list=new CustomList<>();
        list.addElement("Tent");
        assertFalse(list.remove(5));
        assertEquals(1,list.size());
    }
}