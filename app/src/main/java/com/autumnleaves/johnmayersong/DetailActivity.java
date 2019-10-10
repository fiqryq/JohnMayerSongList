package com.autumnleaves.johnmayersong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getDataFromDataSong();
    }

    public void getDataFromDataSong(){
        String titlesong = getIntent().getStringExtra("title");
        String albumsong = getIntent().getStringExtra("album");
        int imagealbum = getIntent().getIntExtra("photo",0);

        detail(titlesong,albumsong,imagealbum);
    }

    public void detail(String titlesong,String albumsong , int imgalbum){
        TextView title = findViewById(R.id.content_textview_title);
        title.setText(titlesong);
        TextView album = findViewById(R.id.content_textview_album);
        album.setText(albumsong);
        ImageView img = findViewById(R.id.photo);
        Glide.with(this).asBitmap().load(imgalbum).into(img);

    }
}
