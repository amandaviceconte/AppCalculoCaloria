package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculo_Calorias extends AppCompatActivity {
    public static double TMB;
    public static double peso;
    public static double altura;
    public static int idade;

    public boolean radio = false;

    public static double TMBFormatado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo__calorias);

        final BancoDeDados db = new BancoDeDados(this);

        final RadioButton homem = findViewById(R.id.radioHomem);
        final RadioButton mulher = findViewById(R.id.radioMulher);

        final TextInputEditText pesoText =  findViewById(R.id.txtPeso);
        final TextInputEditText alturaText = findViewById(R.id.txtAltura);
        final TextInputEditText idadeText = findViewById(R.id.txtIdade);

        final Button calcular = findViewById(R.id.btnCalcular);

        calcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mulher.isChecked())
                {
                    try
                    {
                        //Adicionando o valor digitado pelo usuário à variável peso e altura//
                        peso = Double.parseDouble(pesoText.getText().toString());
                        altura = Double.parseDouble(alturaText.getText().toString());
                        idade = Integer.parseInt(idadeText.getText().toString());

                        TMB = 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
                        BigDecimal bd = new BigDecimal(TMB).setScale(1, RoundingMode.HALF_EVEN);
                        TMBFormatado = bd.doubleValue();

                        Intent it = new Intent(Calculo_Calorias.this, activity_calorias_resultado.class);
                        startActivity(it);

                        db.addTMB(new tmbSQL(peso, altura, idade, "M",  bd.doubleValue()));

                        // Caso haja algum erro a aplicação gera uma excessão e um mensagem de erro//
                        }catch (ArithmeticException e){
                            Toast.makeText(Calculo_Calorias.this, "Por favor. Insira os valores corretamente. ", Toast.LENGTH_LONG).show();
                        }catch (Exception ex){
                            Toast.makeText(Calculo_Calorias.this, "Por favor. Insira os valores corretamente. ", Toast.LENGTH_LONG).show();
                    }
                    radio = true;
                }

                if(homem.isChecked())
                {
                    try
                    {
                        peso = Double.parseDouble(pesoText.getText().toString());
                        altura = Double.parseDouble(alturaText.getText().toString());
                        idade = Integer.parseInt(idadeText.getText().toString());

                        TMB = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
                        BigDecimal bd = new BigDecimal(TMB).setScale(1, RoundingMode.HALF_EVEN);
                        TMBFormatado = bd.doubleValue();

                        Intent it = new Intent(Calculo_Calorias.this, activity_calorias_resultado.class);
                        startActivity(it);

                        db.addTMB(new tmbSQL(peso, altura, idade, "M", bd.doubleValue()));

                        // Caso haja algum erro a aplicação gera uma excessão e um mensagem de erro//
                        }catch (ArithmeticException e){
                            Toast.makeText(Calculo_Calorias.this, "Por favor. Insira os valores corretamente. ", Toast.LENGTH_LONG).show();
                        }catch (Exception ex){
                            Toast.makeText(Calculo_Calorias.this, "Por favor. Insira os valores corretamente. ", Toast.LENGTH_LONG).show();
                    }
                    radio = true;
                }
                if(radio == false)
                {
                    Toast.makeText(Calculo_Calorias.this, "Por favor. Insira seu sexo", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
