package com.example.tour_guide;


public class Category {
    private String type;
    private String icon;
    private int count;

    public Category() {
        this.type = "Null";
        this.icon = "Null";
        this.count = 0;
    }

    public Category(String type, String icon, int count) {
        this.type = type;
        this.icon = icon;
        this.count = count;
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
}