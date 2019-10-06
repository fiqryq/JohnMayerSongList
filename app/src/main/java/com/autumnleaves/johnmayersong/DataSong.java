package com.autumnleaves.johnmayersong;
import java.util.ArrayList;
public class DataSong {
    private static String[] titleSong = {
            "Gravity",
            "XO"
    };

    private static String [] songAlbum = {
            "Quantum",
            "Paredise Valley"
    };

    private static int[] songImage = {
            R.drawable.songgravity,
            R.drawable.xo
    };

    static ArrayList<Song> getListData(){
        ArrayList<Song> list = new ArrayList<>();
        for (int position = 0; position < titleSong.length; position++){
            Song song = new Song();
            song.setTitle(titleSong[position]);
            song.setAlbum(songAlbum[position]);
            song.setPhoto(songImage[position]);
            list.add(song);
        }
        return list;
    }
}
