package com.autumnleaves.johnmayersong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvSongs;
    private ArrayList<Song> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSongs = findViewById(R.id.rv_songs);
        rvSongs.setHasFixedSize(true);

        list.addAll(DataSong.getListData());
        RecyclerList();
    }

    private void RecyclerList(){
        rvSongs.setLayoutManager(new LinearLayoutManager(this));
        ListSongAdapter listSongAdapter = new ListSongAdapter(list,MainActivity.this);
        rvSongs.setAdapter(listSongAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,AboutmeActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}

