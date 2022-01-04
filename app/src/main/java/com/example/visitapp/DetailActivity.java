package com.example.visitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.visitapp.database.dao.WisataDao;
import com.example.visitapp.database.db.MyApp;
import com.example.visitapp.database.entity.Wisata;

public class DetailActivity extends AppCompatActivity {
    TextView judul, lokasi, deskripsi, foto, maps;
    ImageView fotoWisata, ivUlasan, foto1, foto2;
    public final static String TAG_DATA_INTENT = "data_wisata";
    private WisataDao dao;
    Wisata wisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dao = MyApp.getInstance().getDatabase().userDao();

        if (getIntent() != null) {
            int id = getIntent().getIntExtra(TAG_DATA_INTENT, 0);
            wisata = dao.findById(id);
        }

        fotoWisata = findViewById(R.id.fotoWisata);
        judul = findViewById(R.id.judul);
        lokasi = findViewById(R.id.lokasi);
        deskripsi = findViewById(R.id.deskripsi);
        foto1 = findViewById(R.id.foto1);
        foto2 = findViewById(R.id.foto2);
//        foto = findViewById(R.id.foto);
//        maps = findViewById(R.id.maps);
        ivUlasan = findViewById(R.id.ivUlasan);

        String namaImage =(wisata.getFoto()) ;
        String uri = "@drawable/"+namaImage;  // where myresource (without the extension) is the file
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        fotoWisata.setImageDrawable(res);
        foto1.setImageDrawable(res);
        foto2.setImageDrawable(res);



        judul.setText(wisata.getJudul());
        lokasi.setText(wisata.getLokasi());
        deskripsi.setText(wisata.getDeskripsi());
//        foto.setText(wisata.getFoto());
//        maps.setText(wisata.getMaps());


//        judul = findViewById(R.id.judul);
//        lokasi = findViewById(R.id.lokasi);
//        deskripsi = findViewById(R.id.deskripsi);
//
//        wisata.setJudul(judul.getText().toString());
//        wisata.setLokasi(lokasi.getText().toString());
//        wisata.setDeskripsi(deskripsi.getText().toString());
        ivUlasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UlasanActivity.class);
                intent.putExtra(DetailActivity.TAG_DATA_INTENT, wisata.getId());
                finishAffinity();
                startActivity(intent);
            }
        });

    }
}