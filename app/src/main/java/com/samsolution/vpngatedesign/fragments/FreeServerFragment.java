package com.samsolution.vpngatedesign.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.MainActivity;
import com.samsolution.vpngatedesign.adapter.MyAdapter;
import com.samsolution.vpngatedesign.model.Post;
import com.samsolution.vpngatedesign.model.Result;
import com.samsolution.vpngatedesign.model.ServerResponse;
import com.samsolution.vpngatedesign.network.ApiInterface;

import java.util.ArrayList;
import android.util.Base64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FreeServerFragment extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    ArrayList<String> data = new ArrayList<>();
    public static ArrayList<String> flagLink = new ArrayList<>();
    ProgressBar progressBar;
    public static final String TAG = "FreeServerFragment";
    public FreeServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_free_server, container, false);

        progressBar = v.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = v.findViewById(R.id.recyclerViewId);

        String testValue = getResources().getString(R.string.token);

        byte[] encodeValue = Base64.encode(testValue.getBytes(), Base64.DEFAULT);   //Store the value here

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson)) //Here we are using the GsonConverterFactory to directly convert json data to object
                .baseUrl(ApiInterface.BASE_URL)
                .build();

        setHasOptionsMenu(true);

        ViewPager viewpager = v.findViewById(R.id.viewpager);
        LinearLayout linearLayout = v.findViewById(R.id.clickThis);
        linearLayout.setOnClickListener(this);

        ApiInterface api = retrofit.create(ApiInterface.class);
        Call<ServerResponse> call = api.getServerResult(new String(encodeValue));


        Log.i(TAG, "onCreateView: " + new String(encodeValue));

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(@NonNull Call<ServerResponse> call, @NonNull Response<ServerResponse> response) {

                Log.i(TAG, "onResponse: " + response.message());
                progressBar.setVisibility(View.GONE);
                ServerResponse server = response.body();

                if (server != null) {
                    for (Result result : server.getResults()) {
                       /* Log.i("server", result.getHostName());
                        Log.i("server", result.getIP());
                        Log.i("server", result.getScore());
                        Log.i("server", result.getLatency());
                        Log.i("server", result.getCountryLong());
                        Log.i("server", result.getCountryShort());*/

                        data.add(result.getCountryLong());
                        progressBar.setVisibility(View.GONE);
                        flagLink.add("http://v4v.info/countryflag/" + result.getCountryShort().toLowerCase() + ".png");
                    }

                    Log.i(TAG, "onResponse: " + flagLink);

                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    MyAdapter adapter = new MyAdapter(getActivity(), data, flagLink);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ServerResponse> call, @NonNull Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "On Processing", Toast.LENGTH_SHORT).show();
    }
}
