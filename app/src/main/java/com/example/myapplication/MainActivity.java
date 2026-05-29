package com.example.myapplication;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class  MainActivity extends AppCompatActivity {

    ListView lv;
    String nomes [] = new String[] {"João", "Hudson", "Maria"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);

        //configurando adaptador (contexto, layout, id dentro do layout, dados)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(((parent, view, position, id) -> {
            Toast.makeText(this, nomes[position], Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), ActivityExibeDados.class);
            i.putExtra("user", nomes[position]);
            startActivity(i);
        }));
    }
}