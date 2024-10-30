package com.example.testingfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.testingfragment.databinding.FragmentSettingsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.btn_to_ajustes);
        linearLayout.setOnClickListener(v -> {
            AjustesFragment dialogFragment = new AjustesFragment();
            dialogFragment.show(getParentFragmentManager(), "AjustesFragment");
        });

        return view;
    }
}