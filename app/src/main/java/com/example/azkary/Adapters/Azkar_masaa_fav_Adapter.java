package com.example.azkary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azkary.AzkarContent;
import com.example.azkary.Database.DB;
import com.example.azkary.R;

import java.util.ArrayList;

public class Azkar_masaa_fav_Adapter extends RecyclerView.Adapter<Azkar_masaa_fav_Adapter.MyViewHolder>
{
    private Context mContext;
    private int layout;
    private ArrayList<AzkarContent> AzkarMasaaFavList = new ArrayList<>();

    public static DB db;

    public Azkar_masaa_fav_Adapter(Context mContext, int layout, ArrayList<AzkarContent> azkarMasaaFavList)
    {
        this.mContext = mContext;
        this.layout = layout;
        AzkarMasaaFavList = azkarMasaaFavList;
    }

    @NonNull
    @Override
    public Azkar_masaa_fav_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View item_view = LayoutInflater.from(parent.getContext()).inflate(layout , parent , false);
        return new Azkar_masaa_fav_Adapter.MyViewHolder(item_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

        final AzkarContent content = AzkarMasaaFavList.get(position);
        holder.zekrContent.setText(content.getZekr());
        holder.zekrBless.setText(content.getBless());
        holder.zekrRebeat.setText(Integer.toString(content.getRepeat()));
    }


    @Override
    public int getItemCount()
    {
        return AzkarMasaaFavList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView zekrContent , zekrBless , zekrRebeat;
        Button zekrRemoveBtn;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);


            zekrContent = itemView.findViewById(R.id.zekr_content_view_fav);
            zekrBless = itemView.findViewById(R.id.zekr_body_Txt_Id_fav);
            zekrRebeat = itemView.findViewById(R.id.zeker_counter_view_fav);
            zekrRemoveBtn = itemView.findViewById(R.id.removeZekrBtnId_fav);


        }
    }
}
