package com.naridsara.myapplication_test.model;

public class Restaurants {
    private int restaurantsId;
    private String restaurantsName;
    private double restaurantsLatitude;
    private double restaurantsLongitude;
    private String restaurantsImage;

    public Restaurants(int restaurantsId, String restaurantsName, double restaurantsLatitude, double restaurantsLongitude, String restaurantsImage) {
        this.restaurantsId = restaurantsId;
        this.restaurantsName = restaurantsName;
        this.restaurantsLatitude = restaurantsLatitude;
        this.restaurantsLongitude = restaurantsLongitude;
        this.restaurantsImage = restaurantsImage;
    }

    public int getRestaurantsId() {
        return restaurantsId;
    }

    public void setRestaurantsId(int restaurantsId) {
        this.restaurantsId = restaurantsId;
    }

    public String getRestaurantsName() {
        return restaurantsName;
    }

    public void setRestaurantsName(String restaurantsName) {
        this.restaurantsName = restaurantsName;
    }

    public double getRestaurantsLatitude() {
        return restaurantsLatitude;
    }

    public void setRestaurantsLatitude(double restaurantsLatitude) {
        this.restaurantsLatitude = restaurantsLatitude;
    }

    public double getRestaurantsLongitude() {
        return restaurantsLongitude;
    }

    public void setRestaurantsLongitude(double restaurantsLongitude) {
        this.restaurantsLongitude = restaurantsLongitude;
    }

    public String getRestaurantsImage() {
        return restaurantsImage;
    }

    public void setRestaurantsImage(String restaurantsImage) {
        this.restaurantsImage = restaurantsImage;
    }
}
