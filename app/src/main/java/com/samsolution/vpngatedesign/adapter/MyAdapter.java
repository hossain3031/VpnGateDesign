package com.samsolution.vpngatedesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.ConnectedActivity;
import com.samsolution.vpngatedesign.model.Post;
import com.samsolution.vpngatedesign.network.ApiInterface;
import com.samsolution.vpngatedesign.viewholder.MyViewHolder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<String> flagLink;
    private ArrayList<String> countryName;
    //private ArrayList<String> countryNameSmall;
    private Context context;
    String certificate;
    public static final String TAG = "FreeServerFragment's Adapter";

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


        holder.countryName.setText(countryName.get(position).toString());
        Glide.with(context)
                .load(flagLink.get(position))
                .into(holder.flagImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ConnectedActivity.class).putExtra("POSITION", position).putExtra("VALUE", flagLink));


                String testValue = context.getResources().getString(R.string.token);

                byte[] encodeValue = Base64.encode(testValue.getBytes(), Base64.DEFAULT);   //Store the value here

                Gson gson = new GsonBuilder().setLenient().create();
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson)) //Here we are using the GsonConverterFactory to directly convert json data to object
                        .baseUrl(ApiInterface.BASE_URL)
                        .build();

                ApiInterface apiService = retrofit.create(ApiInterface.class);

                Call<Post> callBack = apiService.getRequest(position, new String(encodeValue));

                callBack.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        Post post = response.body();

                        if (post != null) {
                            Log.i("Server: ", "onResponse: " + post.getServer());
                            Log.i("Success: ", "onResponse: " + post.getSuccess());

                            certificate = post.getServer();
                        }

                        byte[] decodeValue = Base64.decode(certificate, Base64.DEFAULT);

                        Log.i("Decode Message: ", "encodeValue: " + new String(decodeValue));

                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Log.i("Failed: ", "onFailure: " + t.getMessage());
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return countryName.size();
    }


    public ArrayList<String> getFlagLink() {
        return flagLink;
    }
}
