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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.adapter.MyAdapter;
import com.samsolution.vpngatedesign.model.Result;
import com.samsolution.vpngatedesign.model.ServerResponse;
import com.samsolution.vpngatedesign.network.ApiInterface;

import java.util.ArrayList;

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
    //ArrayList<String> shortName = new ArrayList<>();
    public static ArrayList<String> flagLink = new ArrayList<>();

    public static final String TAG = "FreeServerFragment";
   /* ArrayList<Integer> flagRes = new ArrayList<>(Arrays.asList(
            R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag,
            R.drawable.al, R.drawable.am, R.drawable.ao, R.drawable.ar,
            R.drawable.at, R.drawable.au, R.drawable.az, R.drawable.ba,
            R.drawable.bb, R.drawable.bd, R.drawable.be, R.drawable.bf,
            R.drawable.bg, R.drawable.in, R.drawable.us, R.drawable.vn));*/

    public FreeServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_free_server, container, false);

        recyclerView = v.findViewById(R.id.recyclerViewId);

        String encodedToken = "QklseUVlTHRYTTdEUThYTTdEUThiZVA1Unh5RWVMdHdBQUFBRXdBQUFBRUdiZVA1UnhHQkls";

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
        Call<ServerResponse> call = api.getServerResult(encodedToken);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(@NonNull Call<ServerResponse> call, @NonNull Response<ServerResponse> response) {

                Log.i(TAG, "onResponse: " + response.message());

                ServerResponse server = response.body();

                if (server != null) {
                    for (Result result : server.getResults()) {
                       // Log.i("server", result.getHostName());
                       // Log.i("server", result.getIP());
                        Log.i("server", result.getScore());
                       // Log.i("server", result.getLatency());
                       //  Log.i("server", result.getCountryLong());
                       // Log.i("server", result.getCountryShort());*/

                        data.add(result.getCountryLong());
                        //shortName.add(result.getCountryShort().toLowerCase());

                        flagLink.add("http://v4v.info/countryflag/" + result.getCountryShort().toLowerCase() + ".png");
                    }

                    Log.i(TAG, "onResponse: " + flagLink);

                    // Log.i(TAG, "onResponse: " + flagName.toString());
                    // = Integer.parseInt(flagName);
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
