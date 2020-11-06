package com.example.miapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class NewReg {

    private Integer id;
    private String name;//
    private String email;//
    private String mobile_number;//
    private String present_college;//
    private String present_city;//
    private String zip_code;//
    private String gender;//
    private String google_id;//
    private String year_of_study;//
    private String status;

    public NewReg(String name, String email, String mobile_number, String present_college, String present_city, String zip_code, String gender, String google_id, String year_of_study, String status){
        this.name=name;
        this.email=email;
        this.mobile_number=mobile_number;
        this.present_college=present_college;
        this.present_city=present_city;
        this.zip_code=zip_code;
        this.gender=gender;
        this.google_id=google_id;
        this.year_of_study=year_of_study;
        this.status=status;
    }

}


