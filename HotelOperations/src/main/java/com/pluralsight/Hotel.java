package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedRooms=0;
        this.bookedSuites=0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        int availableRooms;
        if(isSuite){
            availableRooms=this.getAvailableSuites();
            if(availableRooms>=numberOfRooms){
                this.bookedSuites+=numberOfRooms;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            availableRooms = this.getAvailableRooms();
            if(availableRooms>=numberOfRooms){
                this.bookedRooms+=numberOfRooms;
                return true;
            }
            else {
                return false;
            }
        }
    }

    public int getAvailableSuites(){
        return this.numberOfSuites-this.bookedSuites;
    }

    public int getAvailableRooms(){
        return this.numberOfRooms-this.bookedRooms;
    }
}
