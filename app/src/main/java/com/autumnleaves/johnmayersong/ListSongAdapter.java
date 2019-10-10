package com.autumnleaves.johnmayersong;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ViewHolder> {
    private ArrayList<Song> listSong;
    Context context;

    public ListSongAdapter(ArrayList<Song> listSong, Context context) {
        this.listSong = listSong;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Song song = listSong.get(position);
        Glide.with(holder.itemView.getContext())
                .load(song.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.photo);
        holder.tvTitle.setText(song.getTitle());
        holder.tvAlbum.setText(song.getAlbum());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", song.getTitle());
                intent.putExtra("album", song.getAlbum());
                intent.putExtra("photo", song.getPhoto());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView tvTitle,tvAlbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            tvTitle = itemView.findViewById(R.id.content_textview_title);
            tvAlbum = itemView.findViewById(R.id.content_textview_album);
        }
    }
}
