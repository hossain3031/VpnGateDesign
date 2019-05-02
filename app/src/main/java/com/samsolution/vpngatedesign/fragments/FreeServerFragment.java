package com.samsolution.vpngatedesign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public FreeServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.fragment_free_server, container, false);
        ViewPager viewpager = (ViewPager) v.findViewById(R.id.viewpager);
        LinearLayout linearLayout = v.findViewById(R.id.clickThis);
        linearLayout.setOnClickListener(this);
        // Inflate the layout for this fragment

        String[] cName = getResources().getStringArray(R.array.country_name);
        List<String> cNameList = Arrays.asList(cName);
        ArrayList<String> countryName = new ArrayList<>(cNameList);

        String[] pFree = getResources().getStringArray(R.array.paidOrFree);
        List<String> l = Arrays.asList(pFree);
        ArrayList<String> freePaid = new ArrayList<>(l);


        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter adapter = new MyAdapter(getActivity(), flagRes, countryName, freePaid);
        recyclerView.setAdapter(adapter);


        return v;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "On Processing", Toast.LENGTH_SHORT).show();
    }
}
