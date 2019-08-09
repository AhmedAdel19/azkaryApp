package com.example.azkary;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Azkar_sabah_Activity extends AppCompatActivity {


        ArrayList<AzkarContent> AzkarList;
        CustomAdapter azkar_sabah_adapter = null;
        RecyclerView zekrRecView;
        LinearLayoutManager linearLayoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_azkar_el_sabah);

            AzkarList = new ArrayList<>();

            azkar_sabah_adapter = new CustomAdapter(Azkar_sabah_Activity.this , R.layout.activity_zekr , AzkarList);
            linearLayoutManager = new LinearLayoutManager(getApplicationContext() , RecyclerView.VERTICAL , false);
            zekrRecView = findViewById(R.id.recyclerView_azkar_El_sabah_Id);
            zekrRecView.setHasFixedSize(true);
            zekrRecView.setItemAnimator(new DefaultItemAnimator());
            zekrRecView.setLayoutManager(linearLayoutManager);

            returnAllItems();
        }

        public void returnAllItems()
        {
            ApiInterface api_interface = RetrofitClient.getClient().create(ApiInterface.class);
            Call<ListOfAzkar> call = api_interface.getAzkar();
            call.enqueue(new Callback<ListOfAzkar>() {
                @Override
                public void onResponse(Call<ListOfAzkar> call, Response<ListOfAzkar> response) {
                    if (response.isSuccessful()) {
                        ListOfAzkar azkar_contents = response.body();
                        AzkarList.clear();

                        AzkarList.addAll(azkar_contents.getContent());
                        zekrRecView.setAdapter(azkar_sabah_adapter);
                        azkar_sabah_adapter.notifyDataSetChanged();

//                    for(int i = 0 ; i < AzkarList.size() ; i++)
//                    {
//                        Log.v("Azkarrrrrrrrrrrrr" , AzkarList.get(i).getZekr());
//                        Toast.makeText(Azkar_sabah_Activity.this,AzkarList.get(i).getZekr() , Toast.LENGTH_SHORT).show();
//                    }


                    } else {
                        int statusCode = response.code();
                        String messageCode = response.message();

                        Toast.makeText(Azkar_sabah_Activity.this, "code : " + String.valueOf(statusCode), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Azkar_sabah_Activity.this, "Message : " + messageCode, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ListOfAzkar> call, Throwable t) {
                    Log.e("error message is", t.getMessage());

                }
            });


    }
    @Override
    protected void onStart()
    {
        super.onStart();
        azkar_sabah_adapter.notifyDataSetChanged();
    }
}
