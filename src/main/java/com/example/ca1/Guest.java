package com.example.ca1;

public class Guest {
    private int guestId;
    private String name;
    private String dateOfBirth;
    private String email;
    private String additionalInfo;

    public Guest(int guestId,String name,String dateOfBirth,String email, String additionalInfo) {
        this.guestId = guestId;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.email=email;
        this.additionalInfo=additionalInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return guestId+" - "+name;
    }

}


