package com.example.visitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        TextView username = findViewById(R.id.tvUsername);
        TextView password = findViewById(R.id.tvPassword);
        TextView logout = findViewById(R.id.tvLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilActivity.this, login_activity.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);
            }
        });
        username.setText(sharedPrefManager.getUsername());
        password.setText(sharedPrefManager.getPassword());
    }
}