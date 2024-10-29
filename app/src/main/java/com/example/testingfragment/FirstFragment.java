package com.example.testingfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        FloatingActionButton fabOpenFullscreen = view.findViewById(R.id.fab);
        fabOpenFullscreen.setOnClickListener(v -> {
            CustomDialogFragment dialogFragment = new CustomDialogFragment();
            dialogFragment.show(getParentFragmentManager(), "CustomDialogFragment");
        });

        return view;
    }

}