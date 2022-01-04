package com.example.visitapp.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ulasan {
    @PrimaryKey(autoGenerate = true)
    private int id = 0 ;

    @ColumnInfo(name = "id_wisata")
    private String idwisata ="";

    @ColumnInfo(name = "id_user")
    private String iduser ="";

    @ColumnInfo(name = "tanggal")
    private String tanggal ="";

    @ColumnInfo(name = "review")
    private String review ="";

    @ColumnInfo(name = "rate")
    private String rate ="";

////////////////////

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id =id;
    }

    public String getIdwisata() {
        return idwisata;
    }
    public void setIdwisata(String idwisata) {
        this.idwisata =idwisata;
    }


    public String getIduser() {
        return iduser;
    }
    public void setIduser(String iduser) {
        this.iduser =iduser;
    }


    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal =tanggal;
    }


    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review =review;
    }


    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate =rate;
    }
}
