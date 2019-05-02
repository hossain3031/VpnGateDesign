package com.samsolution.vpngatedesign.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.activity.login_signup.LoginRegActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PremiumServerFragment extends Fragment implements View.OnClickListener {

    public PremiumServerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_premium_server, container, false);

        Button createAccountBtn = view.findViewById(R.id.createAccount);
        createAccountBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), LoginRegActivity.class));
    }

}
