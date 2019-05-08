package com.samsolution.vpngatedesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.ServerListActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectedFragment extends Fragment implements View.OnClickListener {

    ArrayList<Integer> flagRes = new ArrayList<>(Arrays.asList(
            R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag,
            R.drawable.al, R.drawable.am, R.drawable.ao, R.drawable.ar,
            R.drawable.at, R.drawable.au, R.drawable.az, R.drawable.ba,
            R.drawable.bb, R.drawable.bd, R.drawable.be, R.drawable.bf,
            R.drawable.bg, R.drawable.in, R.drawable.us, R.drawable.vn));
    //int position = getActivity().getIntent().getIntExtra("POSITION",0);
    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        pos = getActivity().getIntent().getIntExtra("POSITION", 1);
        //Toast.makeText(getActivity(), " " + pos, Toast.LENGTH_SHORT).show();       //position showing
        getActivity().setTitle("VPN Gate");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_connected, container, false);
        setHasOptionsMenu(true);
        ImageView imageView = v.findViewById(R.id.disconnectMe);
        imageView.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.connectedActivity, new HomePageFragment());
        transaction.commit();
    }

    //Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_flag, menu);
        MenuItem menuItem = null;
        if (menuItem != null) {
            menuItem.setIcon(flagRes.get(pos));
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.country_flag) {
            startActivity(new Intent(getActivity(), ServerListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item); // important line
    }

    //Change Icon in Runtime
    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        MenuItem settingsItem = menu.findItem(R.id.country_flag);
        // set your desired icon here based on a flag if you like
        settingsItem.setIcon(ContextCompat.getDrawable(getContext(), flagRes.get(pos)));
    }
}
