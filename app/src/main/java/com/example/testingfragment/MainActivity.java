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
//                .setEnterAnim(R.anim.slide_in_right)
//                .setExitAnim(R.anim.slide_out_left)
//                .setPopEnterAnim(R.anim.slide_in_left)
//                .setPopExitAnim(R.anim.slide_out_right)
                .setPopUpTo(navController.getGraph().getStartDestinationId(), false);
//                .build();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            NavOptions options;
            if(item.getItemId() == R.id.firstFragment) {
                options = optionsBuilder
                        .setEnterAnim(R.anim.slide_in_left)   // Enter from left
                        .setExitAnim(R.anim.slide_out_right)  // Exit to right
                        .setPopEnterAnim(R.anim.slide_in_right) // Coming back, enter from right
                        .setPopExitAnim(R.anim.slide_out_left) // Exit to left
                        .build();
                navController.navigate(R.id.firstFragment, null, options);
                return true;
            }
            if(item.getItemId() == R.id.secondFragment) {
                options = optionsBuilder
                        .setEnterAnim(R.anim.slide_in_right)  // Enter from right
                        .setExitAnim(R.anim.slide_out_left)   // Exit to left
                        .setPopEnterAnim(R.anim.slide_in_left) // Coming back, enter from left
                        .setPopExitAnim(R.anim.slide_out_right) // Exit to right
                        .build();
                navController.navigate(R.id.secondFragment, null, options);
                return true;
            }
            if(item.getItemId() == R.id.thirdFragment) {
                options = optionsBuilder
                        .setEnterAnim(R.anim.slide_in_right)  // Enter from right
                        .setExitAnim(R.anim.slide_out_left)   // Exit to left
                        .setPopEnterAnim(R.anim.slide_in_left) // Coming back, enter from left
                        .setPopExitAnim(R.anim.slide_out_right) // Exit to right
                        .build();
                navController.navigate(R.id.thirdFragment, null, options);
                return true;
            }
            return true;
        });

//        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}