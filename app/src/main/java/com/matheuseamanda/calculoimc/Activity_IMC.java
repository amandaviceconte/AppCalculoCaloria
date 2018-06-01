package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_IMC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__imc);

        Button TelaCalcularButton = (Button) findViewById(R.id.TelaCalcular);
        TelaCalcularButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent it = new Intent(Activity_IMC.this, CalculoIMC.class);
                startActivity(it);
            }
        });
    }

}