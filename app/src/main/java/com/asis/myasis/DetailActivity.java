package com.asis.myasis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
ImageView imgSelfie;
TextView textTanggal;
TextView textWaktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgSelfie = findViewById(R.id.imageView);
        textTanggal = findViewById(R.id.textDetailNama);
        textWaktu = findViewById(R.id.textDetailBp);


        Intent intent = getIntent();
        if (intent != null){
            Absensi absen = intent.getParcelableExtra("movie_extra_key");
            textTanggal.setText(absen.getTangga());
            textWaktu.setText(absen.getWaktu());
            imgSelfie.setImageDrawable(getResources().getDrawable(absen.getImage()));
        }
    }
}
