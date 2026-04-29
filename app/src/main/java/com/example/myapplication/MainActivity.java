package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText edpeso, edaltura;
    TextView tvIMC;
    ImageView imageView;
    TextView editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        edaltura=findViewById(R.id.edAltura);
        edpeso=findViewById(R.id.edPeso);
        tvIMC = findViewById(R.id.tvIMC);
        imageView = findViewById(R.id.imageView);

        b.setOnClickListener((v -> {
            String strPeso = edpeso.getText().toString();
            String strAltura = edaltura.getText().toString();

            if(strPeso.isEmpty()){
                edpeso.setError("Informe o peso");
                edpeso.requestFocus();
                return;
            }

            if(strAltura.isEmpty()){
                edaltura.setError("Informe a altura");
                edaltura.requestFocus();
                return;
            }

            Double peso= Double.parseDouble(strPeso);
            Double altura= Double.parseDouble(strAltura);
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            i.putExtra("pesoUsr", peso);
            i.putExtra("alturaUsr", altura);
            startActivity(i);
        }));


    }
}