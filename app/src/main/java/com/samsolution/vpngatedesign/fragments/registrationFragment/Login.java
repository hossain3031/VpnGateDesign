package com.samsolution.vpngatedesign.fragments.registrationFragment;

import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public Login() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button accountCreationBtn = view.findViewById(R.id.createAccount);
        Button loginBtn = view.findViewById(R.id.loginBtn);
        accountCreationBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.loginBtn:
                Toast.makeText(getActivity(), "Login Button pressed...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.createAccount:
                //gotoCreateID();
                createFragmentAdd();
                Toast.makeText(getActivity(), "Create Account Working...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void createFragmentAdd() {

        fragmentManager = getActivity().getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.registrationContainer);

        if (fragment instanceof Login){
            fragment = new Signup();
        } else {
            fragment = new Login();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.fragmentContainer, fragment, "DemoFragment");    // It will add fragments
        //fragmentTransaction.replace(R.id.fragmentContainer, fragment, "DemoFragment");    //It will replace the old fragment with the new one
        fragmentTransaction.replace(R.id.registrationContainer, fragment, "demoFragment");    //It will replace the old fragment with the new one
        // fragmentTransaction.addToBackStack(null);
        fragmentTransaction.addToBackStack("Replace" + fragment.toString());
        fragmentTransaction.commit();





        //Working
        /*Fragment newFragment = new Signup();
        fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.registrationContainer, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();*/
    }




}
