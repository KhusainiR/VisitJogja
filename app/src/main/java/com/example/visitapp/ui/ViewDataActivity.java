package com.example.visitapp.ui;

import static com.example.visitapp.database.db.MyApp.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.visitapp.R;
import com.example.visitapp.adapter.RecyclerViewAdapter;
import com.example.visitapp.common.DataListListener;
import com.example.visitapp.database.db.AppDatabase;
import com.example.visitapp.database.db.MyApp;
import com.example.visitapp.database.entity.Wisata;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ViewDataActivity extends AppCompatActivity {
    RecyclerView myRecycleview;
    RecyclerViewAdapter recyclerAdapter;
    List<Wisata> listWisata = new ArrayList<>();
    FloatingActionButton fabAdd;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);


        myRecycleview = findViewById(R.id.myRecyclerview);
        fabAdd = findViewById(R.id.fabAdd);

        adapter = new RecyclerViewAdapter();
        myRecycleview.setAdapter(adapter);

        adapter.setRemoveListener(new DataListListener() {
            @Override
            public void onRemoveClick(Wisata wisata) {
                adapter.removeData(wisata);
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewDataActivity.this, AddDataActivity.class));
            }
        });
//        fetchDataFromRoom();
//        initRecycleView();
//        setAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Wisata> datas = MyApp.getInstance().getDatabase().userDao().getAll();
        adapter.setData(datas);
    }

//    private void fetchDataFromRoom(){
//        db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "wisata").allowMainThreadQueries().build();
//        listWisata = db.wstDao().getAll();
//
//        //just check data from db
//        for (int i = 0 ; i <listWisata.size();i++){
//            Log.e("Aplikasi", listWisata.get(i).getJudul()+i);
//            Log.e("Aplikasi", listWisata.get(i).getLokasi()+i);
//            Log.e("Aplikasi", listWisata.get(i).getDeskripsi()+i);
//            Log.e("Aplikasi", listWisata.get(i).getFoto()+i);
//            Log.e("Aplikasi", listWisata.get(i).getMaps()+i);
//
//        }
//    }
//
//    public void initRecycleView(){
//        myRecycleview.setHasFixedSize(true);
//        LinearLayoutManager llm = new  LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        myRecycleview.setLayoutManager(llm);
//        recyclerAdapter = new RecyclerViewAdapter(this, listWisata);
//    }
//
//    private void setAdapter(){
//        myRecycleview.setAdapter(recyclerAdapter);
//    }
}