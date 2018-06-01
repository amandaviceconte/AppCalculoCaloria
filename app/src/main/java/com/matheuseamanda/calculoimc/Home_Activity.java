package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);


        Button TelaHomeImcButton = (Button) findViewById(R.id.CalculoImcButton);
        TelaHomeImcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Home_Activity.this, Activity_IMC.class);
                startActivity(it);
            }
        });

        Button TelaHomeTaxaButton = (Button) findViewById(R.id.CalculoCaloriaButton);
        TelaHomeTaxaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Home_Activity.this, Calculo_Calorias.class);
                startActivity(it);
            }
        });

    }
}
