package com.example.tpintegrador3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText precioEnDolares;
    private EditText precioEnEuros;
    private RadioButton desdeDolar;
    private RadioButton desdeEuro;
    private RadioGroup radios;
    private Button convertir;
    private TextView precioConvertido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor);
        precioEnDolares = findViewById(R.id.etDolares);
        precioEnEuros = findViewById(R.id.etEuros);
        radios = findViewById(R.id.rgRadios);
        desdeDolar = findViewById(R.id.rbDesdeDolar);
        desdeEuro = findViewById(R.id.rbDesdeEuro);
        convertir = findViewById(R.id.btConvertir);
        precioConvertido = findViewById(R.id.tvPrecioConvertido);
        precioEnEuros.setEnabled(false);
        desdeDolar.setChecked(true);
        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(desdeDolar.isChecked()) {
                    precioEnEuros.setEnabled(false);
                    precioEnEuros.setText("");
                    precioEnDolares.setEnabled(true);
                    precioConvertido.setText("");
                } else {
                    precioEnDolares.setEnabled(false);
                    precioEnDolares.setText("");
                    precioEnEuros.setEnabled(true);
                    precioConvertido.setText("");
                }
            }
        });


    }
    public void Convertir(View view) {
            if(desdeDolar.isChecked()) {
                double precio = Double.parseDouble(precioEnDolares.getText().toString()) * 0.85;
                DecimalFormat df = new DecimalFormat("#.##");
                precioConvertido.setText(df.format(precio).toString());
            } else {
                double precio = Double.parseDouble(precioEnEuros.getText().toString()) * 1.18;
                DecimalFormat df = new DecimalFormat("#.##");
                precioConvertido.setText(df.format(precio).toString());
            }

    }

}