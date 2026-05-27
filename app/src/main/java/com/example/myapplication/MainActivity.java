package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class  MainActivity extends AppCompatActivity {
    Button buttonMudaCor;
    SimplePaint simplePaint;
    ImageButton buttonCirculo, buttonLivre;
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

        buttonLivre.setOnClickListener(v -> {simplePaint.mudarParaLivre();});
        buttonCirculo.setOnClickListener(v -> {simplePaint.mudarParaCirculo();});

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
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        });

    }
}