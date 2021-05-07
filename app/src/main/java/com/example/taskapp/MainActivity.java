package com.example.taskapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.taskapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final String SIMPLE_FRAGMENT_TAG = "myfragmenttag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindview(savedInstanceState);
    }

    private void bindview(Bundle savedInstanceState) {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        showFragment(new PersonFragment());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

             switch (menuItem.getItemId()){

                 case R.id.person: {

                         showFragment(new PersonFragment());
                     break;
                 }

                 case R.id.home:{

                     showFragment(new HomeFragment());
                     break;
                 }

                 case R.id.settings:{
                     showFragment(new SettingFragment());
                     break;
                 }
             }
                return true;
            }
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_layout, fragment)
                .commit();
    }


}
