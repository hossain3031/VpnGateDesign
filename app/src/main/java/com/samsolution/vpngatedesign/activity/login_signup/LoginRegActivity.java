package com.samsolution.vpngatedesign.activity.login_signup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.samsolution.vpngatedesign.R;
import com.samsolution.vpngatedesign.fragments.registrationFragment.Login;
import com.samsolution.vpngatedesign.fragments.registrationFragment.Signup;

public class LoginRegActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_reg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();


        addFragment();
    }

    private void addFragment() {
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.registrationContainer);
        if (fragment instanceof Signup){
            fragment = new Login();
        } else {
            fragment = new Signup();
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.registrationContainer, fragment, "demoFragment");    //It will replace the old fragment with the new one
        fragmentTransaction.commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
