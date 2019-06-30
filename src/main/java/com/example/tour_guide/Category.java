package com.example.tour_guide;


import java.util.ArrayList;

public class Category {
    private String type;
    private String key ;

    public Category() {
    }

    public Category(String type, String key) {
        this.type = type;
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}