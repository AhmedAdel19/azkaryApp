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

public class AzkarElSabahActivity extends AppCompatActivity {


    private ArrayList<AzkarContent> azkarList ;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_el_sabah);



        azkarList =new ArrayList<>();
        customAdapter=new CustomAdapter(AzkarElSabahActivity.this ,R.layout.activity_zekr, azkarList);
        recyclerView=findViewById(R.id.recyclerView_azkar_El_sabah_Id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext() ,RecyclerView.VERTICAL ,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);


        loadAzkarElSabah();



    }

    @Override
    protected void onStart() {
        super.onStart();
        customAdapter.notifyDataSetChanged();

    }


    private void loadAzkarElSabah() {
        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        Call<ListOfAzkar> call= apiInterface.getAzkar();
        call.enqueue(new Callback<ListOfAzkar>() {
            @Override
            public void onResponse(Call<ListOfAzkar> call, Response<ListOfAzkar> response) {

                if(response.isSuccessful())
                {
                    ListOfAzkar listOfAzkar =response.body();
                    azkarList.addAll(listOfAzkar.getContent());
                    recyclerView.setAdapter(customAdapter);




                }
                else
                {
                    int statusCode=response.code();
                    String messageCode =response.message();
                    Toast.makeText(AzkarElSabahActivity.this, ""+statusCode, Toast.LENGTH_SHORT).show();
                    Toast.makeText(AzkarElSabahActivity.this, ""+messageCode, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ListOfAzkar> call, Throwable t) {
                Log.i("error message : ",t.getMessage());
                Toast.makeText(AzkarElSabahActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });











    }

    }

