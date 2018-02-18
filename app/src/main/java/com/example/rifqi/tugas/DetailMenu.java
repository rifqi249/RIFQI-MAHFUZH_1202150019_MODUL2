package com.example.rifqi.tugas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        Bundle b = getIntent().getExtras();
        //membuat obyek dari widget textview
        TextView Judul = (TextView) findViewById(R.id.txt_makanan);
        TextView harga = (TextView) findViewById(R.id.txt_harga);
        TextView keterangan = (TextView) findViewById(R.id.txt_komposisi);
        ImageView gambar = (ImageView) findViewById(R.id.gambar_makanan);
        //menset nilai dari widget textview
        Judul.setText(b.getCharSequence("Nama"));
        harga.setText(b.getCharSequence("Harga"));
        gambar.setImageResource(b.getInt("Gambar"));
        keterangan.setText(b.getCharSequence("Keterangan"));

    }

}
