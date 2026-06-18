package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActivityFormularioLinear extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextEndereco;
    private EditText editTextCidade;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private Spinner spinnerEstado;
    private EditText editTextCep;
    private EditText editTextAniversario;
    private ImageButton imageButtonCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_formulario_linear);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        editTextCidade = findViewById(R.id.editTextCidade);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        spinnerEstado = findViewById(R.id.spinnerEstado);
        editTextCep = findViewById(R.id.editTextCep);
        editTextAniversario = findViewById(R.id.editTextAniversario);
        imageButtonCalendario = findViewById(R.id.imageButtonCalendario);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.estados_brasil,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstado.setAdapter(adapter);

        imageButtonCalendario.setOnClickListener(v -> abrirDatePicker());

        }

    private void abrirDatePicker() {
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                this,
                (view, anoSelecionado, mesSelecionado, diaSelecionado) -> {
                    String data = String.format("%02d/%02d/%04d", diaSelecionado, mesSelecionado + 1, anoSelecionado);
                    editTextAniversario.setText(data);
                },
                ano, mes, dia
        );
        dialog.show();
    }

}