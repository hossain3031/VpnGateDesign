package com.samsolution.vpngatedesign.fragments;

import android.os.Bundle;
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

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.adapter.MyAdapter;
import com.samsolution.vpngatedesign.model.ServerResponse;
import com.samsolution.vpngatedesign.network.ApiInterface;
import com.samsolution.vpngatedesign.network.RetrofitApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FreeServerFragment extends Fragment implements View.OnClickListener {

    ArrayList<Integer> flagRes = new ArrayList<>(Arrays.asList(
            R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag,
            R.drawable.al, R.drawable.am, R.drawable.ao, R.drawable.ar,
            R.drawable.at, R.drawable.au, R.drawable.az, R.drawable.ba,
            R.drawable.bb, R.drawable.bd, R.drawable.be, R.drawable.bf,
            R.drawable.bg, R.drawable.in, R.drawable.us, R.drawable.vn));
    String encodedToken;


    //New Data
    ArrayList<String> countryNameLong = new ArrayList<>();
    ArrayList<String> countryNameShort = new ArrayList<>();
    ArrayList<String> speed = new ArrayList<>();
    ServerResponse serverResponses;

    public FreeServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        serverResponses = new ServerResponse();
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.fragment_free_server, container, false);
        ViewPager viewpager = (ViewPager) v.findViewById(R.id.viewpager);
        LinearLayout linearLayout = v.findViewById(R.id.clickThis);
        linearLayout.setOnClickListener(this);
        // Inflate the layout for this fragment

        String[] cName = getResources().getStringArray(R.array.country_name);
        List<String> cNameList = Arrays.asList(cName);
        ArrayList<String> countryName = new ArrayList<>(cNameList);



        /*String[] pFree = getResources().getStringArray(R.array.paidOrFree);
        List<String> l = Arrays.asList(pFree);
        ArrayList<String> freePaid = new ArrayList<>(l);*/

        String tokenValue = getResources().getString(R.string.token);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encodedToken = Base64.getEncoder().encodeToString(tokenValue.getBytes());
        }


        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        Call<ServerResponse> call = apiInterface.getIp(encodedToken);


        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {


                    //Toast.makeText(getActivity(), "" + response.body().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "" + response.isSuccessful(), Toast.LENGTH_SHORT).show();



                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = new JSONObject();

                    Log.i(TAG, "onResponse: " + jsonArray.getJSONArray(0).getJSONObject(0).getString("Speed"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

            }
        });

        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter adapter = new MyAdapter(getActivity(), flagRes, countryName);
        recyclerView.setAdapter(adapter);


        return v;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "On Processing", Toast.LENGTH_SHORT).show();
    }


}
