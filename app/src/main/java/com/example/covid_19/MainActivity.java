package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.covid_19.ui.kasusHarian.FragmentKasus;
import com.example.covid_19.ui.rsRujukan.FragmentRS;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView main_navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_navbar = findViewById(R.id.main_navbar);
        main_navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(new FragmentKasus());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.kasus:
                fragment = new FragmentKasus();
                break;
            case R.id.rsrujukan:
                fragment = new FragmentRS();
                break;
        }
        return loadFragment(fragment);
    }


}