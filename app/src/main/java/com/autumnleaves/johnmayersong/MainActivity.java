package com.autumnleaves.johnmayersong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private void RecyclerList() {
        rvSongs.setLayoutManager(new LinearLayoutManager(this));
        ListViewAdapter listViewAdapter = new ListViewAdapter(list);
        rvSongs.setAdapter(listViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectionMode) {
        switch (selectionMode) {
            case R.id.menu_list_view:
                RecyclerList();
                break;
        }
    }
}
