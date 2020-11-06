package com.example.miapp.Retrofit;

import android.util.Log;

import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Api {
    String baseUrl="https://api2.moodi.org";


    // /user
    @GET("/user/{id}")
    Call<User> getUser(@Path("id") String gID);

    @POST("/user/create")
    Call<NewReg> postJson(@Body NewReg body);


    @GET("/miapp/events")
    Call<List<AllEvents>> getAllEvent();

    @GET("/miapp/events/likes/{id}")
    Call<List<Event>> getEvents(@Path("id") String gID);


//

}
