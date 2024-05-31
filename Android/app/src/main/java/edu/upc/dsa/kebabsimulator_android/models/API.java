package edu.upc.dsa.kebabsimulator_android.models;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.POST;
import retrofit2.http.Path;


import android.util.Log;

public interface API {
    String BASE_URL = "http://10.0.2.2:8080/dsaApp/";

    @GET("weapons/getWeapons")
    Call<List<Weapon>> weapons();

    @GET("users/getUsers")
    Call<List<User>> users();

    @POST("users/newUser")
    Call<User> addUser(@Body User user);

    @POST("forms/submit-form")
    Call<FormResponse> submitForm(@Body FormData formData);

    @GET("prueba/{userId}/badges")
    Call<List<Badge>> getUserBadges(@Path("userId") String userId);

    @GET("messages")
    Call<List<Message>> getMessages();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    API apiService = retrofit.create(API.class);
}


