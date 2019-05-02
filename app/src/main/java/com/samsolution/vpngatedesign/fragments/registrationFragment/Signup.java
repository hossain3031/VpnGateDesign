package com.samsolution.vpngatedesign.fragments.registrationFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.ServerListActivity;
import com.samsolution.vpngatedesign.fragments.HomePageFragment;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class Signup extends Fragment implements View.OnClickListener {

    Fragment fragment;

    public Signup() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        Button gotoSignUpBtn = view.findViewById(R.id.gotoLoginPage);

        Button createIdBtn = view.findViewById(R.id.createId);

        createIdBtn.setOnClickListener(this);
        gotoSignUpBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        /*Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.registrationContainer, new PremiumServerFragment());
        transaction.commit();*/
        fragment = new Login();
        //fragment2 = new Signup();

        switch (v.getId()) {
            case R.id.createId:
                Toast.makeText(getActivity(), "Creating an Id", Toast.LENGTH_SHORT).show();

                break;
            case R.id.gotoLoginPage:
                //gotoCreateID();

                startActivity(new Intent(getContext(), ServerListActivity.class).putExtra("PAGER",true));

                /*FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.registrationContainer, new Login());
                transaction.commit();
                Log.i(TAG, "onClick: loginpage");*/
                break;
        }

    }
}
