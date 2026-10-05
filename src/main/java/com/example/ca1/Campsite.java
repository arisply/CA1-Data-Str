package com.example.ca1;

public class Campsite {
    private String name;
    private String address;

    private CustomList<CampingArea> campingAreas=new CustomList<>();
    private CustomList<Guest> guests=new CustomList<>();

    public void addGuest(Guest guest){
        guest.addElement(guest);
    }

    public CustomList<Guest> getGuests() {
        return guests;
    }

    public Campsite(String name, String address) {
        this.name = name;
        this.address = address;
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
