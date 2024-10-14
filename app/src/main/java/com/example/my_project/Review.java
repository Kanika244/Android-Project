package com.example.myapplication;

public class Review {
    private String userName;
    private float rating;
    private String text;

    public Review(String userName, float rating, String text) {
        this.userName = userName;
        this.rating = rating;
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public float getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }
}
