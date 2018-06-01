package com.matheuseamanda.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_calorias_resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorias_resultado);

        final TextView result = (TextView) findViewById(R.id.resultado);

        result.setText(String.format("%.2f", Calculo_Calorias.TMB));
    }
}
