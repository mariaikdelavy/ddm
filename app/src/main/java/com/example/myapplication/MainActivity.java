package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText etNota;
    Button btnAdicionar;
    ArrayList<String> notas = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        etNota = findViewById(R.id.editTextNota);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notas);
        lv.setAdapter(adapter);

        btnAdicionar.setOnClickListener(v -> {
            String texto = etNota.getText().toString().trim();
            if (!texto.isEmpty()) {
                notas.add(texto);
                adapter.notifyDataSetChanged();
                etNota.setText("");
            } else {
                Toast.makeText(this, "Digite algo!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}