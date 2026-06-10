package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etMin, etMax;
    Button btnGerar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMin = findViewById(R.id.etMin);
        etMax = findViewById(R.id.etMax);
        btnGerar = findViewById(R.id.btnGerar);
        tvResultado = findViewById(R.id.tvResultado);

        btnGerar.setOnClickListener(v -> {
            int min = Integer.parseInt(etMin.getText().toString());
            int max = Integer.parseInt(etMax.getText().toString());

            Random random = new Random();
            int numero = random.nextInt(max - min + 1) + min;

            tvResultado.setText("Número gerado: " + numero);
        });
    }
}