package com.naridsara.myapplication_test.model;

public class Restaurants {
    private int restaurantsId;
    private String restaurantsName;
    private Double restaurantsLatitude;
    private Double restaurantsLongitude;
    private String restaurantsImage;

    public Restaurants(int restaurantsId, String restaurantsName, Double restaurantsLatitude, Double restaurantsLongitude, String restaurantsImage) {
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

    public Double getRestaurantsLatitude() {
        return restaurantsLatitude;
    }

    public void setRestaurantsLatitude(Double restaurantsLatitude) {
        this.restaurantsLatitude = restaurantsLatitude;
    }

    public Double getRestaurantsLongitude() {
        return restaurantsLongitude;
    }

    public void setRestaurantsLongitude(Double restaurantsLongitude) {
        this.restaurantsLongitude = restaurantsLongitude;
    }

    public String getRestaurantsImage() {
        return restaurantsImage;
    }

    public void setRestaurantsImage(String restaurantsImage) {
        this.restaurantsImage = restaurantsImage;
    }
}
