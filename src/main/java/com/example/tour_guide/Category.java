package com.example.tour_guide;


import java.util.ArrayList;

public class Category {
    private String type;
    private String icon;
    private int count;
    private ArrayList<Place> places;

    public Category() {
        this.type = "Null";
        this.icon = "Null";
        this.count = 0;
        this.places = new ArrayList<>();
    }

    public Category(String type, String icon, int count) {
        this.type = type;
        this.icon = icon;
        this.count = count;
        this.places = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }
}