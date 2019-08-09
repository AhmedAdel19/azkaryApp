package com.example.azkary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.azkary.Adapters.Azkar_sabah_fav_Adapter;
import com.example.azkary.Database.DB;

import java.util.ArrayList;

public class Azkar_Sabah_Favourites extends AppCompatActivity
{
    ArrayList<AzkarContent> Azkar_sabah_fav_list;
    Azkar_sabah_fav_Adapter azkar_sabah_fav_adapter = null;
    LinearLayoutManager linearLayoutManager;
    RecyclerView Azkar_sabah_fav_rec;
    public static DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar__sabah__favourites);

        Azkar_sabah_fav_list = new ArrayList<>();
        azkar_sabah_fav_adapter = new Azkar_sabah_fav_Adapter(Azkar_Sabah_Favourites.this , R.layout.one_item_favourite_zekr , Azkar_sabah_fav_list);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext() , RecyclerView.VERTICAL , false);
        Azkar_sabah_fav_rec = findViewById(R.id.recyclerView_azkar_El_sabah_Id_fav);
        Azkar_sabah_fav_rec.setHasFixedSize(true);
        Azkar_sabah_fav_rec.setItemAnimator(new DefaultItemAnimator());
        Azkar_sabah_fav_rec.setLayoutManager(linearLayoutManager);

        Azkar_sabah_fav_rec.setAdapter(azkar_sabah_fav_adapter);
        azkar_sabah_fav_adapter.notifyDataSetChanged();

        db = new DB(this , "AzkaryApp.sqlite" , null , 1);

        try
        {
            Cursor zekrCursor = db.getData("SELECT * FROM AZKAR_SABAH");
            Azkar_sabah_fav_list.clear();

            if(zekrCursor.moveToFirst())
            {
                do{
                    int zekrId = zekrCursor.getInt(0);
                    String zekrContent = zekrCursor.getString(1);
                    String zekrBless = zekrCursor.getString(2);
                    int zekrRebeat = zekrCursor.getInt(3);

                    Azkar_sabah_fav_list.add(new AzkarContent(zekrContent , zekrBless , zekrRebeat));

                }while (zekrCursor.moveToNext());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart()
    {
        azkar_sabah_fav_adapter.notifyDataSetChanged();
        super.onStart();
    }
}
