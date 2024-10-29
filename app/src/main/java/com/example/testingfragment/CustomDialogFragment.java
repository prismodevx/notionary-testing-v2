package com.example.testingfragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class CustomDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Material_Dialog_Alert);
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        return dialog;
//    }

    @Override
    public void onStart() {
        super.onStart();
        // Set dialog width and height if needed
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent); // or your custom color
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Animation slideIn = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
        view.startAnimation(slideIn);

        Button closeButton = view.findViewById(R.id.btn_close);
        closeButton.setOnClickListener(v -> dismiss());

//        Button closeButton = view.findViewById(R.id.btn_close);
//        closeButton.setOnClickListener(v -> dismiss());
    }

    public void dismissDialog(View view) {
        dismiss();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if (getDialog() != null) {
//            getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        }
//    }
}