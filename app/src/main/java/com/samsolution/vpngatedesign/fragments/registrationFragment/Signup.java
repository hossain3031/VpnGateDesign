package com.samsolution.vpngatedesign.fragments.registrationFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.samsolution.vpngatedesign.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Signup extends Fragment implements View.OnClickListener {


    public Signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        Button gotoLoginPageBtn = view.findViewById(R.id.gotoLoginPage);
        gotoLoginPageBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
    }
}
