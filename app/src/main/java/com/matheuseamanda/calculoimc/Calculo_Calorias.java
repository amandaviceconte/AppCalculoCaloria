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
    public static int altura;
    public static int idade;

    private double pesoTemp;
    private double alturaTemp;
    private int idadeTemp;

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
                        if (peso < 800) {
                            pesoTemp = peso;
                        } else {
                            Toast.makeText(Calculo_Calorias.this, "Peso deve ser menor que 800kg.", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException();
                        }
                        altura = Integer.parseInt(alturaText.getText().toString());
                        if(altura < 280)
                        {
                            alturaTemp = altura;
                        } else {
                            Toast.makeText(Calculo_Calorias.this, "Altura deve ser menor que 280cm.", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException();
                        }
                        idade = Integer.parseInt(idadeText.getText().toString());
                        if(idade < 150)
                        {
                            idadeTemp = idade;
                        } else {
                            Toast.makeText(Calculo_Calorias.this, "Idade deve ser menor que 150.", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException();
                        }

                        TMB = 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
                        BigDecimal bd = new BigDecimal(TMB).setScale(1, RoundingMode.HALF_EVEN);
                        TMBFormatado = bd.doubleValue();

                        Intent it = new Intent(Calculo_Calorias.this, activity_calorias_resultado.class);
                        startActivity(it);

                        db.addTMB(new tmbSQL(pesoTemp, alturaTemp, idadeTemp, "M", TMBFormatado));

                        // Caso haja algum erro a aplicação gera uma excessão e um mensagem de erro//
                    }catch (IllegalArgumentException ia){
                        Toast.makeText(Calculo_Calorias.this, "Por favor, insira um valor válido.", Toast.LENGTH_LONG).show();
                    }catch (ArithmeticException e){
                        Toast.makeText(Calculo_Calorias.this, "Por favor, insira um valor válido.", Toast.LENGTH_LONG).show();
                    }catch (Exception ex){
                        Toast.makeText(Calculo_Calorias.this, "Por favor, insira um valor válido.", Toast.LENGTH_LONG).show();
                    }
                    radio = true;
                }

                if(homem.isChecked()) {
                    try {
                        peso = Double.parseDouble(pesoText.getText().toString());
                        if (peso < 800) {
                            pesoTemp = peso;
                        } else {
                            Toast.makeText(Calculo_Calorias.this, "Peso deve ser menor que 800kg.", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException();
                        }

                        altura = Integer.parseInt(alturaText.getText().toString());
                        if(altura < 280)
                        {
                            alturaTemp = altura;
                        } else {
                            Toast.makeText(Calculo_Calorias.this, "Altura deve ser menor que 280cm.", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException();
                        }
                        idade = Integer.parseInt(idadeText.getText().toString());
                        if(idade < 150)
                        {
                            idadeTemp = idade;
                        }else{
                            Toast.makeText(Calculo_Calorias.this, "Idade deve ser menor que 150.", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException();
                        }

                        TMB = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
                        BigDecimal bd = new BigDecimal(TMB).setScale(1, RoundingMode.HALF_EVEN);
                        TMBFormatado = bd.doubleValue();

                        db.addTMB(new tmbSQL(pesoTemp, alturaTemp, idadeTemp, "H", TMBFormatado));

                        Intent it = new Intent(Calculo_Calorias.this, activity_calorias_resultado.class);
                        startActivity(it);

                        // Caso haja algum erro a aplicação gera uma excessão e um mensagem de erro//
                    }catch (IllegalArgumentException ia){
                        Toast.makeText(Calculo_Calorias.this, "Insira um valor válido.", Toast.LENGTH_LONG).show();
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
