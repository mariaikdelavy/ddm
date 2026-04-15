package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText edpeso, edaltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.layout.button);
        edaltura=findViewById(R.id.edAltura);
        edpeso=findViewById(R.id.edPeso);

        b.setOnClickListener((v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            //passar os dados para o bundle
            float peso = Float.parseFloat(edpeso.getText().toString());
            float altura = Float.parseFloat(edaltura.getText().toString());

        }));


    }
}