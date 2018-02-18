package com.example.rifqi.tugas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

public class DaftarMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> namaList;
    private ArrayList<String> hargaList;
    private ArrayList<String> keteranganList;
    private ArrayList<Integer> imageList;
    //Daftar makanan
    private String[] Makanan = {"Seblak", "Indomie", "Telurgulung"};
    //Daftar Harga
    private String[] Harga = {"Rp.10000","Rp.5000","Rp.2000"};
    private String[] Keterangan = {"Mie Kuning","indomie goreng dan telur","telur"};
    //Daftar Gambar
    private int[] Gambar = {R.drawable.seblak, R.drawable.indomie, R.drawable.telurgulung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);
        namaList = new ArrayList<>();
        hargaList = new ArrayList<>();
        keteranganList = new ArrayList<>();
        imageList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(namaList, hargaList, keteranganList, imageList);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }

    //Mengambil data dari Varibale Gambar dan Judul, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void DaftarItem(){
        for (int w=0; w<Makanan.length; w++){
            namaList.add(Makanan[w]);
            hargaList.add(Harga[w]);
            keteranganList.add(Keterangan[w]);
            imageList.add(Gambar[w]);
        }
    }
}

