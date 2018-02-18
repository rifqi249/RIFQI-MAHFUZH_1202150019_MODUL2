package com.example.rifqi.tugas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;



//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> namaList; //Digunakan untuk Judul
    private ArrayList<String> hargaList; //Digunakan untuk Judul
    private ArrayList<String> keteranganList; //Digunakan untuk Judul
    private ArrayList<Integer> imageList; //Digunakan untuk Image/Gambar

    //Membuat Konstruktor pada Class RecyclerViewAdapter
    RecyclerViewAdapter(ArrayList<String> namaList, ArrayList<String> hargaList ,ArrayList<String> keteranganList , ArrayList<Integer> imageList){
        this.namaList = namaList;
        this.hargaList = hargaList;
        this.keteranganList = keteranganList;
        this.imageList = imageList;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nama, harga;
        private ImageView gambar;
        private RelativeLayout ItemList;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            nama = itemView.findViewById(R.id.txt_makanan);
            harga = itemView.findViewById(R.id.txt_harga);
            gambar = itemView.findViewById(R.id.gambar_makanan);
            ItemList = itemView.findViewById(R.id.item_list);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu
        final String Nama = namaList.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        final String komposisi = keteranganList.get(position);
        final int setGambar=imageList.get(position);
        final String Harga = hargaList.get(position);
        holder.nama.setText(Nama);
        holder.harga.setText(Harga);
        holder.gambar.setImageResource(imageList.get(position)); // Mengambil gambar sesuai posisi yang telah ditentukan
        //Membuat Aksi Saat Judul Pada List ditekan

        holder.nama.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, String.valueOf(setGambar), Snackbar.LENGTH_SHORT).show();
             Bundle b = new Bundle();
                Intent intent = new Intent(view.getContext(), DetailMenu.class);
                b.putString("Nama",Nama);
                b.putString("Harga",Harga);
                b.putString("Keterangan",komposisi);
                b.putInt("Gambar",setGambar);
                intent.putExtras(b);
                view.getContext().startActivity(intent);
            }
        });
        //Membuat Aksi Saat List Ditekan
     holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                Intent intent = new Intent(view.getContext(), DetailMenu.class);
                b.putString("Nama",Nama);
                b.putString("Harga",Harga);
                b.putString("Keterangan",komposisi);
                b.putInt("Gambar",setGambar);
                intent.putExtras(b);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return namaList.size();
    }
    public void getIntent(){

    }

}