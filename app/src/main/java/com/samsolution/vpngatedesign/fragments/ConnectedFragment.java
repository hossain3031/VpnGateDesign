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
import android.widget.Toast;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



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
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.country_flag:

                startActivity(new Intent(getActivity(), ServerListActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item); // important line
    }


    /*@Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();    //remove all items
        getActivity().getMenuInflater().inflate(R.menu.menu_flag, menu);
    }*/

    /*We need to call onPrepareOptionsMenu(Menu menu) to add, remove and modify menu items.*/
   /* @Override
    public void onPrepareOptionsMenu(Menu menu) {

        MenuItem country_flag_menu = menu.findItem(R.id.country_flag);

        country_flag_menu.setIcon(flagRes.get(position));


        if (green.getTitle() != "Green Text") {
            // If green menu item title not updated then update/change it
            green.setTitle("Green Text");
            Toast.makeText(mContext, "Green MenuItem Edited", Toast.LENGTH_SHORT).show();
        }

    }*/
}
