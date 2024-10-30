package com.example.testingfragment;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavOptions.Builder optionsBuilder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(navController.getGraph().getStartDestinationId(), false);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            NavOptions options;
            if(item.getItemId() == R.id.notesFragment) {
                options = optionsBuilder
                        .build();
                navController.navigate(R.id.notesFragment, null, options);
                return true;
            }
            if(item.getItemId() == R.id.remindersFragment) {
                options = optionsBuilder
                        .build();
                navController.navigate(R.id.remindersFragment, null, options);
                return true;
            }
            if(item.getItemId() == R.id.settingsFragment) {
                options = optionsBuilder
                        .build();
                navController.navigate(R.id.settingsFragment, null, options);
                return true;
            }
            return true;
        });
    }
}