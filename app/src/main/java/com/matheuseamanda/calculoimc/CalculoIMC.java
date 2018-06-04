package com.matheuseamanda.calculoimc;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.Scanner;

public class CalculoIMC extends AppCompatActivity {
    public static double resultadoFinal;
    public String classficacao;

    BancoDeDados db = new BancoDeDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        final TextInputEditText pegarPeso = (TextInputEditText) findViewById (R.id.pegarPeso);
        final TextInputEditText pegarAltura = (TextInputEditText) findViewById(R.id.pegarAltura);

        Button calcular = (Button) findViewById(R.id.ButtonCalcular);

        //Botao de calcular
        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c)
            {
                try {
                    double peso = Double.parseDouble(pegarPeso.getText().toString());
                    double altura = Double.parseDouble(pegarAltura.getText().toString());

                    resultadoFinal = peso / (altura * altura);

                    if(resultadoFinal <= 18.5)
                    {
                        classficacao = "Abaixo do peso";
                    }
                    if(resultadoFinal >= 18 && resultadoFinal <= 24.9)
                    {
                        classficacao = "Peso Ideal";
                    }
                    if(resultadoFinal >= 25 && resultadoFinal <= 29.9)
                    {
                        classficacao = "Acima do peso";
                    }
                    if(resultadoFinal >= 30 && resultadoFinal <= 34.9)
                    {
                        classficacao = "Obesidade";
                    }
                    if(resultadoFinal >= 35 && resultadoFinal <= 40)
                    {
                        classficacao = "Obesidade Severa";
                    }
                    if(resultadoFinal > 40)
                    {
                        classficacao = "Obesidade mórbida";
                    }

                    db.addIMC(new imcSQL(peso, altura, resultadoFinal, classficacao));
                    Toast.makeText(CalculoIMC.this, "Inserido com sucesso", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(CalculoIMC.this, resultado.class);
                    startActivity(it);

                }catch (ArithmeticException e){
                    Toast.makeText(CalculoIMC.this, "Por favor. Insira os valores corretamente. ", Toast.LENGTH_LONG).show();
                }catch (Exception ex){
                    Toast.makeText(CalculoIMC.this, "Por favor. Insira os valores corretamente. ", Toast.LENGTH_LONG).show();
                }
            }
        });

       /* imcSQL imcsql = new imcSQL();
        imcsql.setCodigo(1);
        db.apagarIMC(imcsql);
        Toast.makeText(CalculoIMC.this, "Apagado com sucesso", Toast.LENGTH_LONG).show();
        */

        /*imcSQL imcsql = new imcSQL();
        imcsql.setCodigo(1);
        db.selecionarIMC(imcsql);

        Log.d("Selecionado", "Codigo: "+ imcsql.getCodigo() + "Peso: " + imcsql.getPeso() + "Altura: " + imcsql.getAltura()
        + "Resultado: " + imcsql.getResultado());*/
    }

}
