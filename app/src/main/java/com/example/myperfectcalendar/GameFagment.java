package com.example.myperfectcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameFagment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View y = inflater.inflate(R.layout.fragment_game, container, false);

        Button GO = (Button) y.findViewById(R.id.go_game);
        GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Get! Set!! Go!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), GameActivity.class));

            }
        });

        return y;
    }
}
