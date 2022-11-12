package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomBarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBarId = findViewById(R.id.bottomBarId);


        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutId,new HomeFragment()).commit();
        }

        bottomBarId.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                if (item.getItemId() == R.id.HomeId) {
                    fragment = new HomeFragment();
                }

                if (item.getItemId() == R.id.ProfileId){
                    fragment = new ProfileFragment();
                }

                if (item.getItemId() == R.id.SettingId){
                    fragment = new SettingFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutId,fragment).commit();

                return false;
            }
        });
    }
}