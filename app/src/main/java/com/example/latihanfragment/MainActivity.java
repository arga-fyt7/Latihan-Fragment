package com.example.latihanfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        navigationListener();

        // Tampilkan fragmen Home saat aplikasi pertama kali dibuka
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new HomeFragment()).commit();
    }

    private void init() {
        navigation = findViewById(R.id.navigation);
    }

    private void navigationListener() {
        navigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.nav_home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.nav_search) {
                    selectedFragment = new SearchFragment();
                } else if (item.getItemId() == R.id.nav_notification) {
                    selectedFragment = new NotificationFragment();
                } else if (item.getItemId() == R.id.nav_account) {
                    selectedFragment = new AccountFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, selectedFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }


}