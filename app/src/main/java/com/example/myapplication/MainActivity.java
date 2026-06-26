package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class  MainActivity extends AppCompatActivity {
    Button buttonMudaCor;
    SimplePaint simplePaint;
    ImageView buttonCirculo, buttonLivre, buttonQuadrado, buttonLinha;
    public void mudaCor(ColorEnvelope envelope){
        simplePaint.mudaCor(envelope.getColor());
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonMudaCor = findViewById(R.id.buttonMudaCor);
        simplePaint = findViewById(R.id.simplePaint);
        buttonCirculo = findViewById(R.id.imageCirculo);
        buttonLivre = findViewById(R.id.imageTraco);
        buttonQuadrado = findViewById(R.id.imageQuadrado);
        buttonLinha = findViewById(R.id.imageLinha);

        buttonLivre.setOnClickListener(v -> {simplePaint.mudarParaLivre();});
        buttonCirculo.setOnClickListener(v -> {simplePaint.mudarParaCirculo();});
        buttonQuadrado.setOnClickListener(v -> {simplePaint.mudarParaQuadrado();});
        buttonLinha.setOnClickListener(v -> {simplePaint.mudarParaLinha();});

        buttonMudaCor.setOnClickListener(v -> {
            new ColorPickerDialog.Builder(this)
                    .setTitle("Selecione a cor do desenho")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Confirmar",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    mudaCor(envelope);
                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true)
                    .attachBrightnessSlideBar(true)
                    .setBottomSpace(12)
                    .show();
        });

    }
}