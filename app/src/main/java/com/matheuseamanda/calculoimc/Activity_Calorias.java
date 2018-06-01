package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Calorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__calorias);

        Button TelaCalcularTaxaButton = (Button) findViewById(R.id.CalcularTaxaButton);
        TelaCalcularTaxaButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent it = new Intent(Activity_Calorias.this, Calculo_Calorias.class);
                startActivity(it);
            }
        });
    }
}
