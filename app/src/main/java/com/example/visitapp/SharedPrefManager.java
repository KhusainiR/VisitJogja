package com.example.visitapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefManager(Context context){
        sharedPreferences = context.getSharedPreferences("Latihan shared_pref", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getUsername(){
        return sharedPreferences.getString("sp_username", "latifkhusaini");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_password", "19.01.4383");
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_islogin", value);
        editor.commit();
    }

    public boolean getIsLogin(){
        return sharedPreferences.getBoolean("sp_islogin", false);
    }
}
