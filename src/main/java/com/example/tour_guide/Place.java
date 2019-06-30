package com.example.tour_guide;

public class Place {
    private String key ;
    private String cateKey;
    private String title;
    private String city;
    private String street;
    private String phone;

    public Place() {
        this.key ="Null";
        this.cateKey ="Null";
        this.title ="Null";
        this.city ="Null";
        this.street ="Null";
        this.phone ="Null";
    }

    public Place(String key, String cateKey, String title, String city, String street, String phone) {
        this.key = key;
        this.cateKey = cateKey;
        this.title = title;
        this.city = city;
        this.street = street;
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCateKey() {
        return cateKey;
    }

    public void setCateKey(String cateKey) {
        this.cateKey = cateKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
