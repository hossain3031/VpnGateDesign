package com.samsolution.vpngatedesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.ConnectedActivity;
import com.samsolution.vpngatedesign.viewholder.MyViewHolder;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<String> flagLink;
    private ArrayList<String> countryName;
    //private ArrayList<String> countryNameSmall;
    private Context context;

    public MyAdapter(Context context, ArrayList<String> countryName, ArrayList<String> flagLink) {
        this.context = context;
        this.flagLink = flagLink;
        this.countryName = countryName;
        //this.countryNameSmall = countryNameSmall;
        //this.freeOrPaidList = freeOrPaidList;
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

        //holder.flagImageView.setImageResource((flagId.get(position)));
        holder.countryName.setText(countryName.get(position).toString());
        //holder.countryNameSmallTV.setText(countryNameSmall.get(position).toString());
        Glide.with(context)
                .load(flagLink.get(position))
                .into(holder.flagImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked on: " + position, Toast.LENGTH_SHORT).show();

                context.startActivity( new Intent(context, ConnectedActivity.class).putExtra("POSITION", position));
                //Toast.makeText(context, "Country: " + countryName.get(position)+ "\nServer: "+ freeOrPaidList.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return countryName.size();
    }
}
