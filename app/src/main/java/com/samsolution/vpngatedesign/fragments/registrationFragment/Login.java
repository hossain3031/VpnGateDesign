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
public class Login extends Fragment implements View.OnClickListener {


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button accountCreationBtn = view.findViewById(R.id.createAccount);
        accountCreationBtn.setOnClickListener(this);
        
        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
    }
}
