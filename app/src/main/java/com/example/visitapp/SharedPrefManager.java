package com.example.visitapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefManager(Context context ){
        sharedPreferences = context.getSharedPreferences("Latihan shared_pref", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getUsername(){
        return sharedPreferences.getString("sp_username", "qwerty");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_password", "12345");
    }

    public String getId(){
        return sharedPreferences.getString("sp_id", "1");
    }

    public String getFoto(){
        return sharedPreferences.getString("sp_foto", "prof");
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_islogin", value);
        editor.commit();
    }

    public boolean getIsLogin(){
        return sharedPreferences.getBoolean("sp_islogin", false);
    }
}
