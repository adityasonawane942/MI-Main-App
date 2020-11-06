package com.example.miapp.Retrofit;


public class User {

    private String name;
    private String mi_number;


    public User(String name, String mi_number) {
        this.name=name;
        this.mi_number=mi_number;

    }

    public String getName() {
        return name;
    }

    public String getMi_number() {
        return mi_number;
    }


}