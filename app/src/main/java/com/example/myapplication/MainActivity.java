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

    TextView textView;
    EditText etMin;
    EditText etMax;
    Button button;
    Button btnreset;
    Button btnrnd;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv);
        etMin=findViewById(R.id.etMin);
        etMax=findViewById(R.id.etMax);
        button=findViewById(R.id.button);
        btnreset=findViewById(R.id.btnreset);
        btnrnd=findViewById(R.id.btnrdn);
        textView.setText("0");

        // Botão de incremento
        button.setOnClickListener(v -> {
            c++;
            textView.setText(Integer.toString(c));
        });

        // Botão de reset
        btnreset.setOnClickListener(v -> {
            textView.setText("0");
            c=0;
            etMin.setText("0");
            etMax.setText("100");
        });

        // Botão de número aleatório
        btnrnd.setOnClickListener(v -> {
            String minText = etMin.getText().toString();
            String maxText = etMax.getText().toString();
            int min = Integer.parseInt(etMin.getText().toString());
            int max = Integer.parseInt(etMax.getText().toString());

            Random random = new Random();
            int randomNumber = random.nextInt((max - min) + 1) + min;

            textView.setText(Integer.toString(randomNumber));
            c = randomNumber;
        });
    }
}