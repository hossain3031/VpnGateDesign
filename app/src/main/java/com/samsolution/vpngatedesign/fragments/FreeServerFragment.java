package com.samsolution.vpngatedesign.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.samsolution.vpngatedesign.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FreeServerFragment extends Fragment implements View.OnClickListener {


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
        return v;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(getActivity(), "On Processing", Toast.LENGTH_SHORT).show();


        //startActivity(new Intent(getActivity(), MainActivity.class));

    }
}
