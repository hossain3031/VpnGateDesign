package com.samsolution.vpngatedesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.ServerListActivity;

import java.util.Objects;


public class HomePageFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).hide();*/
        setHasOptionsMenu(true);


        View v = inflater.inflate(R.layout.fragment_home_page, container, false);

        ImageView img = v.findViewById(R.id.clickme);
        img.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), ServerListActivity.class));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.country:
                startActivity(new Intent(getActivity(), ServerListActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item); // important line
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();    //remove all items
        Objects.requireNonNull(getActivity()).getMenuInflater().inflate(R.menu.menu, menu);
    }

}
