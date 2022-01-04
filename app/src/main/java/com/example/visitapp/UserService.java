package com.example.visitapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserService {

   @Headers("Content-Type: application/json")
   @POST("users/login")
   Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

   @Headers("Content-Type: application/json")
   @POST("users/add")
   Call<SignupResponse> userSignup(@Body SignupRequest signupRequest);


}
