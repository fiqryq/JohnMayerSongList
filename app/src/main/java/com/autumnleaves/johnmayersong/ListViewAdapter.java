package com.autumnleaves.johnmayersong;

import android.content.Context;
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

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private ArrayList<Song> listsong;
    public ListViewAdapter(ArrayList<Song> list){this.listsong = list;}

    @NonNull
    @Override
    public ListViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_listview_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.ViewHolder holder, int position) {
        Song song = listsong.get(position);
        Glide.with(holder.itemView.getContext())
                .load(song.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvTitle.setText(song.getTitle());
        holder.tvAlbum.setText(song.getAlbum());
    }

    @Override
    public int getItemCount() {
        return listsong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvAlbum;
        ViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.content_image);
            tvTitle = itemView.findViewById(R.id.content_textview_title);
            tvAlbum = itemView.findViewById(R.id.content_textview_album);
        }
    }
}
