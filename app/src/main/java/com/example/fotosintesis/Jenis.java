package com.example.fotosintesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Jenis extends Fragment {

    Fragment me = this;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jenis, container, false);

        Button btnclose = (Button) view.findViewById(R.id.close);
        Button btnKloropas = (Button) view.findViewById(R.id.btn_kloropas);
        Button btnKlorofil = (Button) view.findViewById(R.id.btn_klorofil);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(me).commit();
            }
        });

        btnKloropas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), JenisActivity.class);
                startActivity(intent);
            }
        });

        btnKlorofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Jenis2Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}