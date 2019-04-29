package com.samsolution.vpngatedesign.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.viewholder.MyViewHolder;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Integer> flagId;
    ArrayList<String> countryName;
    ArrayList<String> freeOrPaidList;
    Context context;

    public MyAdapter(Context context, ArrayList<Integer> flagId, ArrayList<String> countryName, ArrayList<String> freeOrPaidList) {
        this.context = context;
        this.flagId = flagId;
        this.countryName = countryName;
        this.freeOrPaidList = freeOrPaidList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Inflate the child layout
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.flagImageView.setImageResource((flagId.get(position)));
        holder.countryName.setText(countryName.get(position));
        holder.freePaid.setText(freeOrPaidList.get(position));




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Country: " + countryName.get(position)+ "Free/Paid: "+ freeOrPaidList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryName.size();
    }
}
