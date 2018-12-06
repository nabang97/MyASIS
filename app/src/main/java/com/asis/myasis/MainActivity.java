package com.asis.myasis;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AbsenAdapter.OnItemClick {

    RecyclerView recyclerView;
    AbsenAdapter absenAdapter;
    List<Absensi> absensiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        absensiList = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        absensiList.add(
                new Absensi(
                        "Syifa Chairunnisa Delivia Akbar",
                        "1511521013",
                        R.drawable.nutcracker));
        absensiList.add(
                new Absensi(
                        "10 Desember 2010",
                        "11.00 WIB",
                        R.drawable.nutcracker));
        absensiList.add(
                new Absensi(
                        "19 Desember 2010",
                        "10.00 WIB",
                        R.drawable.nutcracker));
        absensiList.add(
                new Absensi(
                        "12 Oktober 2010",
                        "10.23 WIB",
                        R.drawable.nutcracker));
        absensiList.add(
                new Absensi(
                        "12 Oktober 2010",
                        "10.23 WIB",
                        R.drawable.nutcracker));
        absensiList.add(
                new Absensi(
                        "12 Oktober 2010",
                        "10.23 WIB",
                        R.drawable.nutcracker));
        absensiList.add(
                new Absensi(
                        "12 Oktober 2010",
                        "10.23 WIB",
                        R.drawable.nutcracker));


       AbsenAdapter adapter = new AbsenAdapter(this, absensiList);
       adapter.setHandler(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void click(Absensi m) {
        Intent detailActivityIntent = new Intent(this, DetailActivity.class);
        detailActivityIntent.putExtra("movie_extra_key", (Parcelable) m);
        startActivity(detailActivityIntent);
    }

    //menampilkan menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addAbsen:
                    Intent addDataActivityIntent = new Intent(MainActivity.this, AddDataActivity.class);
                    startActivity(addDataActivityIntent);
                break;

            case R.id.refreshAbsen:

                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
