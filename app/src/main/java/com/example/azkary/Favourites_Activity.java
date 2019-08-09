package com.example.azkary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Favourites_Activity extends AppCompatActivity
{
    private Button azkar_sabah_fav_btn , azkar_masaa_fav_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites_);

        azkar_sabah_fav_btn = findViewById(R.id.azkar_sabah_fav);
        azkar_masaa_fav_btn = findViewById(R.id.azkar_masaa_fav);

        azkar_sabah_fav_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent azkar_sabah_fav_intent = new Intent(Favourites_Activity.this  , Azkar_Sabah_Favourites.class);
                startActivity(azkar_sabah_fav_intent);

            }
        });

        azkar_masaa_fav_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent azkar_masaa_fav_intent = new Intent(Favourites_Activity.this , Azkar_Masaa_Favourites.class);
                startActivity(azkar_masaa_fav_intent);
            }
        });
    }
}
