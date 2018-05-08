package com.matheuseamanda.calculoimc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class CalculoIMC extends AppCompatActivity {

   /* public double peso;
    public double altura;*/
    public static double resultadoFinal;

    //EditText editnumber1, editnumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        final EditText pegarPeso = (EditText) findViewById (R.id.pegarPeso);
        final EditText pegarAltura = (EditText) findViewById(R.id.pegarAltura);
        final TextView result = (TextView) findViewById(R.id.resultadoTeste);

        Button calcular = (Button) findViewById(R.id.ButtonCalcular);


        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c)
            {


                double peso = Double.parseDouble(pegarPeso.getText().toString());
                double altura = Double.parseDouble(pegarAltura.getText().toString());

                resultadoFinal = peso / (altura * altura);
               // result.setText(String.format("%.2f", resultadoFinal));

                 Intent it = new Intent(CalculoIMC.this, resultado.class);
                 startActivity(it);

            }
        });


    }

}
