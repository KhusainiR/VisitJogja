package com.example.visitapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visitapp.ui.ViewDataActivity;


public class HomeFragment extends Fragment {
    public final static String TAG_DATA_INTENT = "data_wisata";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ImageView ivPantai = (ImageView) getView().findViewById(R.id.ivPantai);
        ImageView ivAir = (ImageView) getView().findViewById(R.id.ivAir);
        ImageView ivMuseum = (ImageView) getView().findViewById(R.id.ivMuseum);
        ImageView ivCandi = (ImageView) getView().findViewById(R.id.ivCandi);

        ivPantai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kat = "pantai";
                Intent intent = new Intent(getActivity(), KategoriActivity.class);
                intent.putExtra(DetailActivity.TAG_DATA_INTENT, kat);
                startActivity(intent);
            }
        });

        ivAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kat = "air terjun";
                Intent intent = new Intent(getActivity(), KategoriActivity.class);
                intent.putExtra(DetailActivity.TAG_DATA_INTENT, kat);
                startActivity(intent);
            }
        });

        ivMuseum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kat = "museum";
                Intent intent = new Intent(getActivity(), KategoriActivity.class);
                intent.putExtra(DetailActivity.TAG_DATA_INTENT, kat);
                startActivity(intent);
            }
        });

        ivCandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kat = "candi";
                Intent intent = new Intent(getActivity(), KategoriActivity.class);
                intent.putExtra(DetailActivity.TAG_DATA_INTENT, kat);
                startActivity(intent);
            }
        });

    }


}