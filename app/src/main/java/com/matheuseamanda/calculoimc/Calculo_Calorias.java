package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class Calculo_Calorias extends AppCompatActivity {
    public static double TMB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo__calorias);

        final RadioGroup sexoOptions = (RadioGroup) findViewById(R.id.SexoOptions);
        final RadioButton homem = (RadioButton) findViewById(R.id.HomemOption);
        final RadioButton mulher = (RadioButton) findViewById(R.id.MulherOption);

        final EditText pesoText = (EditText) findViewById(R.id.pesoID);
        final EditText alturaText = (EditText) findViewById(R.id.alturaID);
        final EditText idadeText = (EditText) findViewById(R.id.idadeID);

        final Button calcular = (Button) findViewById(R.id.buttonCalcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(mulher.isChecked())
                {
                    double peso = Double.parseDouble(pesoText.getText().toString());
                    double altura = Double.parseDouble(alturaText.getText().toString());
                    double idade = Double.parseDouble(idadeText.getText().toString());

                    TMB = 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
                    Intent it = new Intent(Calculo_Calorias.this, activity_calorias_resultado.class);
                    startActivity(it);
                }
                if(homem.isChecked())
                {
                    double peso = Double.parseDouble(pesoText.getText().toString());
                    double altura = Double.parseDouble(alturaText.getText().toString());
                    double idade = Double.parseDouble(idadeText.getText().toString());

                    TMB = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
                    Intent it = new Intent(Calculo_Calorias.this, activity_calorias_resultado.class);
                    startActivity(it);
                }
            }
        });
    }
}
