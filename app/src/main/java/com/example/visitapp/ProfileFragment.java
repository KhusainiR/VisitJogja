package com.example.visitapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visitapp.adapter.RecyclerViewAdapter;
import com.example.visitapp.database.db.MyApp;
import com.example.visitapp.database.entity.Ulasan;
import com.example.visitapp.database.entity.Wisata;
import com.example.visitapp.ui.AddDataActivity;
import com.example.visitapp.ui.ViewDataActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    ImageView ivUser;
    TextView tvUsername, tvPassword;
    Button btnLogout, btnEdit, btnInput;

    RecyclerView ulasanRecycleview;
    RecyclerViewAdapter recyclerAdapter;
    List<Ulasan> ulasanList = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_profile,container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SharedPrefManager sharedPrefManager = new SharedPrefManager(getActivity());
        TextView username = (TextView) getView().findViewById(R.id.tvUsername);
        TextView password = (TextView) getView().findViewById(R.id.tvPassword);
        ImageView ivUser = (ImageView) getView().findViewById(R.id.ivUser);
        Button logout = (Button) getView().findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), login_activity.class);
                sharedPrefManager.saveIsLogin(false);
                getActivity().finish();
                startActivity(intent);
            }
        });


        ///Recycler View
        ulasanRecycleview =(RecyclerView)getView().findViewById(R.id.ulasanRecyclerview);

        adapter = new RecyclerViewAdapter();
        ulasanRecycleview.setAdapter(adapter);
        super.onResume();
        List<Wisata> datas = MyApp.getInstance().getDatabase().userDao().getAll();
        adapter.setData(datas);


        //set data ke activity
        username.setText(sharedPrefManager.getUsername());
        password.setText(sharedPrefManager.getPassword());

        String namaImage =(sharedPrefManager.getFoto()) ;
        String uri = "@drawable/"+namaImage;  // where myresource (without the extension) is the file
        int imageResource = getResources().getIdentifier("drawable/" + namaImage , null, getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        ivUser.setImageDrawable(res);


        Button btnInput = (Button) getView().findViewById(R.id.btnInput);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewDataActivity.class);
                startActivity(intent);
            }
        });

        Button btnEdit = (Button) getView().findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditprofilActivity.class);
                startActivity(intent);
            }
        });
    }



}