package com.example.visitapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visitapp.DetailActivity;
import com.example.visitapp.R;
import com.example.visitapp.common.DataListListener;
import com.example.visitapp.database.entity.Ulasan;
import com.example.visitapp.database.entity.Wisata;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewAdapterUlasan extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context mContext;
    private List<Ulasan> dataList ;
    private DataListListener listener;

    public void RecyclerViewAdapter(Context mContext, List<Ulasan> dataList){
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ulasan, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        final Ulasan data = dataList.get(position);
//        holder.nama.setText(data.getIduser());
//        holder.review.setText(data.getReview());

    }

    private class MyViewHolder extends RecyclerViewAdapter.ViewHolder {
        TextView nama, review;

        public MyViewHolder(View v) {
            super(v);

            nama = v.findViewById(R.id.nama);
            review = v.findViewById(R.id.review);

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
