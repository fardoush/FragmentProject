package com.example.sherin.fragmentproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    long fastTime, lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new FragmentOne());
    }

    public void selectFragment(View view) {

        switch (view.getId()) {

            case R.id.frag1:
                // --- select button one
                //Toast.makeText(this, "Button One", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentOne());
                break;

            case R.id.frag2:
                // --- select button two
                // Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentTwo());
                break;

            case R.id.frag3:
                // --- select button three
                // Toast.makeText(this, "Button 3", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentThree());
                break;

        }

    }


    public void addFragment(Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();


        transaction.replace(R.id.fragment_place, fragment);
        transaction.commit();


    }


    @Override
    public void onBackPressed() {

        lastTime = fastTime;
        fastTime = System.currentTimeMillis();

        if (fastTime - lastTime < 250) {

            finish();
        } else {
            Toast.makeText(this, "press double click to exit", Toast.LENGTH_SHORT).show();
        }


    }
}