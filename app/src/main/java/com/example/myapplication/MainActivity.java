package com.example.myapplication;

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

            Double peso=Double.parseDouble(strPeso);
            Double altura=Double.parseDouble(strAltura);
            double imc = peso/(altura * altura);
            DecimalFormat dc = new DecimalFormat("##.##");
            tvIMC.setText(dc.format(imc));

            if(imc < 19){
                imageView.setImageResource(R.drawable.abaixopeso);
                return;
            }

            if(imc < 25){
                imageView.setImageResource(R.drawable.normal);
                return;
            }

            if(imc < 30){
                imageView.setImageResource(R.drawable.sobrepeso);
                return;
            }

            if(imc < 34){
                imageView.setImageResource(R.drawable.obesidade1);
                return;
            }

            if(imc < 40){
                imageView.setImageResource(R.drawable.obesidade2);
                return;
            }

            imageView.setImageResource(R.drawable.obesidade3);

        }));


    }
}