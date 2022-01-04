package com.example.visitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visitapp.database.dao.UlasanDao;
import com.example.visitapp.database.dao.WisataDao;
import com.example.visitapp.database.db.MyApp;
import com.example.visitapp.database.entity.Ulasan;
import com.example.visitapp.database.entity.Wisata;

public class UlasanActivity extends AppCompatActivity {
    TextView judul, lokasi, idWisata;
    EditText  idUser, review;
    ImageView fotoWisata, ivMaps;
    public final static String TAG_DATA_INTENT = "data_wisata";
    private WisataDao dao;
    private UlasanDao daou;
    Ulasan ulasan;
    Wisata wisata;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasan);

        SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        dao = MyApp.getInstance().getDatabase().userDao();
        daou = MyApp.getInstance().getDatabase().ulasDao();
        if (getIntent() != null) {
            int id = getIntent().getIntExtra(TAG_DATA_INTENT, 0);
            wisata = dao.findById(id);
        }
        fotoWisata = findViewById(R.id.fotoWisata);
        judul = findViewById(R.id.judul);
        lokasi = findViewById(R.id.lokasi);
        review = findViewById(R.id.review);
        btnSubmit = findViewById(R.id.btnSubmit);
//        idWisata = findViewById(R.id.idWisata);
        idUser = findViewById(R.id.idUser);

        String namaImage =(wisata.getFoto()) ;
        String uri = "@drawable/"+namaImage;  // where myresource (without the extension) is the file

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        fotoWisata.setImageDrawable(res);

        judul.setText(wisata.getJudul());
        lokasi.setText(wisata.getLokasi());
//        idWisata.setText(getString(wisata.getId()));
        idUser.setText(sharedPrefManager.getId());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ulasan = new Ulasan();
//                ulasan.setIdwisata(getString(wisata.getId()));
                ulasan.setReview(review.getText().toString());
                ulasan.setIduser(idUser.getText().toString());
                daou.insertAll(ulasan);

                Intent intent = new Intent(UlasanActivity.this, UlasanActivity.class);
                finishAffinity();
                startActivity(intent);
            }
        });

    }
}