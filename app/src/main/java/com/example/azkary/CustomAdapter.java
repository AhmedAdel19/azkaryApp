package com.example.azkary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azkary.Database.DB;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

   private ArrayList<AzkarContent> AzkarList = new ArrayList<>();
   private Context mContext;
   private int layout;
   public static DB db;


    public CustomAdapter(Context context ,int layout,ArrayList<AzkarContent> azkarList)
    {

        AzkarList =  azkarList  ;
        this.mContext = context;
        this.layout  =layout;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout , parent ,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        final AzkarContent azkarContent = AzkarList.get(position);

        holder.title.setText(azkarContent.getZekr());
        holder.body.setText(azkarContent.getBless());
        holder.repeat.setText(Integer.toString(azkarContent.getRepeat()));

        holder.saveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db = new DB(mContext , "AzkaryApp.sqlite" , null , 1);
                db.QueryData("CREATE TABLE IF NOT EXISTS AZKAR_SABAH (ZekrId INTEGER PRIMARY KEY AUTOINCREMENT , ZekrContent VARCHAR , ZekrBless VARCHR , ZekrRebeat INTEGER)");

                try
                {
                    db.InsetrNewZekr
                            (
                                    "AZKAR_SABAH",
                                    azkarContent.getZekr(),
                                    azkarContent.getBless(),
                                    azkarContent.getRepeat()
                            );
                    Toast.makeText(mContext, "Zekr Add to your favourites successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return AzkarList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title , body , repeat;
        Button saveBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title =itemView.findViewById(R.id.zekr_content_view);
            body =itemView.findViewById(R.id.zekr_body_Txt_Id);
            repeat =itemView.findViewById(R.id.zeker_counter_view);
            saveBtn = itemView.findViewById(R.id.saveZekrBtnId);


        }

    }
}
