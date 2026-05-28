package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class  MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    FragmentoA fragmentoA;
    FragmentoB fragmentoB;
    Button buttonA, buttonB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);

        //Inicialização gerenciador de fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Inicia uma transação com FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Adicionamos o container e o objeto do nosso fragmentoA para exibir
        transaction.add(R.id.frameLayout, new FragmentoA());

        //Finalizamos a transação do fragment com commit
        transaction.commit();

        buttonA.setOnClickListener(v -> {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.frameLayout, new FragmentoA());
            ft.commit();
        });

        buttonB.setOnClickListener(v -> {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.frameLayout, new FragmentoB());
            ft.commit();
        });
    }
}