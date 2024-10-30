package com.example.testingfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class AjustesFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ajustes, container, false);

//        setupOnBackPressed();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Material_Dialog_Alert);
        setupOnBackPressed();
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_Dialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            getDialog().getWindow().setDimAmount(0.25f);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Animation slideIn = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
        view.startAnimation(slideIn);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        // Desactivar el título del Toolbar
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        ImageButton closeButton = view.findViewById(R.id.btn_back);
        closeButton.setOnClickListener(v -> animateDismiss());

        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Log.d("AjustesFragment", "Back pressed");
                animateDismiss(); // Llama a la animación de cierre
            }
        });
//        closeButton.setOnClickListener(v -> {
//            Animation slideOut = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
//            slideOut.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {}
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    dismiss();
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {}
//            });
//            view.startAnimation(slideOut);
//        });
    }

    public void animateDismiss() {
        Animation slideOut = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
        View view = getView(); // Obtén la vista del fragmento
        if (view != null) {
            view.startAnimation(slideOut);
            slideOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    dismiss(); // Cierra el diálogo después de la animación
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        } else {
            dismiss(); // Si no hay vista, cierra directamente
        }
    }

    private void setupOnBackPressed() {
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Log.d("AjustesFragment", "aaaaaa");
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}