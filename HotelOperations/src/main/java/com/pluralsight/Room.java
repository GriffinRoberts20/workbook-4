package com.pluralsight;

public class Room {

    private int numberOfBeds;
    private float price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, float price){
        this.numberOfBeds=numberOfBeds;
        this.price=price;
        this.occupied=false;
        this.dirty=false;
    }

    public Room(int numberOfBeds, float price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public void checkIn(){
        this.setOccupied(true);
        this.setDirty(true);
    }

    public void checkOut(){
        this.cleanRoom();
        this.setOccupied(false);
    }

    public void cleanRoom(){
        this.setDirty(false);
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public float getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !this.dirty && !this.occupied;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
