package com.matheuseamanda.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView ExibirResultado = (TextView) findViewById(R.id.FinalResult);

        ExibirResultado.setText(String.format("%.2f", CalculoIMC.resultadoFinal));
    }
}
