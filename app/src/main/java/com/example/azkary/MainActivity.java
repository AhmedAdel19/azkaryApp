package com.example.azkary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button azkarElsabah_btn ,azkarElMasaa_btn , azkarb3dElSalah_btn ,azkarFavourites_btn , AwqatElSalah_btn ,qur2an_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      /*_______________________________AzkarElSabahBtn ___________________________________*/
        azkarElsabah_btn=findViewById(R.id.azkarElSabahBtn);
        azkarElsabah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent azkarElSabahIntent = new Intent(getApplicationContext(),Azkar_sabah_Activity.class);
                startActivity(azkarElSabahIntent);
            }
        });

        /*_______________________________AzkarElMasaaBtn ___________________________________*/

        azkarElMasaa_btn=findViewById(R.id.azkarElMasaaBtn);

        azkarElMasaa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent azkarElMasaaIntent = new Intent(getApplicationContext(),AzkarElMasaaActivity.class);
                startActivity(azkarElMasaaIntent);

            }
        });


        /*_______________________________AzkarB3dElSalahBtn ___________________________________*/

        azkarb3dElSalah_btn=findViewById(R.id.azkarb3dElSalahBtn);

        azkarb3dElSalah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent azkarB3dElsalahIntent = new Intent(getApplicationContext(),AzkarB3dElSalahActivity.class);
                startActivity(azkarB3dElsalahIntent);

            }
        });

        /*_______________________________AwqatElSalahBtn ___________________________________*/

        AwqatElSalah_btn=findViewById(R.id.W2tBtn);

        AwqatElSalah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aw2atElSalahIntent = new Intent(getApplicationContext(),AwqatElSalahActivity.class);
                startActivity(aw2atElSalahIntent);

            }
        });

        /*_______________________________Qur2anBtn ___________________________________*/

        qur2an_btn=findViewById(R.id.qor2anBtn);

        qur2an_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qur2anIntent = new Intent(getApplicationContext(),Qur2anActivity.class);
                startActivity(qur2anIntent);

            }
        });

        /*_______________________________AzkarFavouritesBtn ___________________________________*/

        azkarFavourites_btn=findViewById(R.id.azkarFavouritesBtn);

        azkarFavourites_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favourites_activity = new Intent(getApplicationContext(),Favourites_Activity.class);
                startActivity(favourites_activity);

            }
        });
    }
}
