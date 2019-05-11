package com.samsolution.vpngatedesign.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.samsolution.vpngatedesign.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView flagImageView;
    public TextView countryName;
   // public TextView countryNameSmallTV;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        flagImageView = itemView.findViewById(R.id.flagImageId);
        countryName = itemView.findViewById(R.id.countryNameId);
        //countryNameSmallTV = itemView.findViewById(R.id.countryNameSmall);




        //freePaid = itemView.findViewById(R.id.freePaid);

    }
}
