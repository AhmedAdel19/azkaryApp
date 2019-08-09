package com.example.azkary;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AzkarElMasaaActivity extends AppCompatActivity {

    private RecyclerView AzkarElMasaaRecyclerView ;
    private CustomAdapterAzkarElmasaa customAdapter;
    private ArrayList<AzkarContent> AzkarElMasaArrayList ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_el_masaa);




        AzkarElMasaArrayList =new ArrayList<>();
        AzkarElMasaaRecyclerView =findViewById(R.id.azkarElMasaaListId);
        customAdapter =new CustomAdapterAzkarElmasaa(AzkarElMasaaActivity.this,R.layout.activity_zekr_elmasaa, AzkarElMasaArrayList);

        AzkarElMasaaRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext() ,RecyclerView.VERTICAL ,false));
        AzkarElMasaaRecyclerView.setHasFixedSize(true);

        loadAzkarElMasaa();
    }



    private void loadAzkarElMasaa() {
        ApiInterface apiInterface =RetrofitClient.getAzkarElMasaa().create(ApiInterface.class);

        Call<ListOfAzkar> call = apiInterface.getAzkarElMasa2();

        call.enqueue(new Callback<ListOfAzkar>() {
            @Override
            public void onResponse(Call<ListOfAzkar> call, Response<ListOfAzkar> response) {

                if (response.isSuccessful())
                {
                    ListOfAzkar listOfAzkar=response.body();
                    AzkarElMasaArrayList.addAll(listOfAzkar.getContent());
                    AzkarElMasaaRecyclerView.setAdapter(customAdapter);
                    customAdapter.notifyDataSetChanged();


                }
                else
                {
                    int statusCode =response.code();
                    String responseMsg =response.message();

                    Toast.makeText(AzkarElMasaaActivity.this, ""+statusCode, Toast.LENGTH_SHORT).show();
                    Toast.makeText(AzkarElMasaaActivity.this, ""+responseMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ListOfAzkar> call, Throwable t) {

                Log.e("msgError", ""+t.getMessage());

            }
        });

    }
}
