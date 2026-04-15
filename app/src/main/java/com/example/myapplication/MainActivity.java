package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonAvancar, buttonVoltar;
    ImageView imageView;
    int imagens[] = new int []{R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho,
            R.drawable.porquinho};

    int posicao = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAvancar=findViewById(R.id.btnAvancar);
        buttonVoltar=findViewById(R.id.btnVoltar);
        imageView=findViewById(R.id.imageView);

        buttonAvancar.setOnClickListener(v -> {
            posicao++;
            if(posicao >= imagens.length){
                posicao = 0;
            }
            imageView.setImageResource(imagens[posicao]);
        });

        buttonVoltar.setOnClickListener(v -> {
            posicao--;
            if(posicao < 0){
                posicao = imagens.length - 1;
            }
            imageView.setImageResource(imagens[posicao]);
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        imageView.setImageResource(imagens[0]);
    }

}