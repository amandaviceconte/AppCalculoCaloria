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
import java.math.*;


public class CalculoIMC extends AppCompatActivity {
    public double peso;
    public double altura;
    public static double resultadoFinal;
    public String classficacao;
    public static double resultadoConcatenado;

    private double pesoTemp;
    private double alturaTemp;


    BancoDeDados db = new BancoDeDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        //Declarando a existencia dos campos de texto peso e altura//
        final TextInputEditText pegarPeso = (TextInputEditText) findViewById (R.id.pegarPeso);
        final TextInputEditText pegarAltura = (TextInputEditText) findViewById(R.id.pegarAltura);

        Button calcular = findViewById(R.id.ButtonCalcular);
        //Botao de calcular
        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c)
            {
                try {
                    //Adicionando o valor digitado pelo usuário à variável peso e altura//
                    double peso = Double.parseDouble(pegarPeso.getText().toString());
                    if (peso < 800) {
                        pesoTemp = peso;
                    } else {
                        Toast.makeText(CalculoIMC.this, "Peso deve ser menor que 800kg", Toast.LENGTH_LONG).show();
                        throw new IllegalArgumentException();
                    }
                    double altura = Double.parseDouble(pegarAltura.getText().toString());
                    if (altura < 280) {
                        alturaTemp = altura;
                    } else {
                        Toast.makeText(CalculoIMC.this, "Altura deve ser menor que 280cm", Toast.LENGTH_LONG).show();
                        throw new IllegalArgumentException();
                    }

                    //Calculando valor do resultado final e formatando para limitar as casas decimais//
                    resultadoFinal = (peso) / ((altura * altura) / 10000);
                    BigDecimal bd = new BigDecimal(resultadoFinal).setScale(1, RoundingMode.HALF_EVEN);

                    /*Não achei nenhuma forma de passar o falor formatado para a activity "resultado"
                    portanto criei uma variavel static que recebe o valor formatado e eu chamo ela na
                    activity "resultado". */
                    resultadoConcatenado = bd.doubleValue();

                    //Definindo a classificação de IMC do usuário de acordo com o valor do resultado final//
                    if (resultadoFinal <= 18.5) {
                        Toast.makeText(CalculoIMC.this, "Abaixo do Peso", Toast.LENGTH_LONG).show();
                        classficacao = "Abaixo do peso";
                    }
                    if (resultadoFinal >= 18 && resultadoFinal <= 24.9) {
                        Toast.makeText(CalculoIMC.this, "Peso Ideal", Toast.LENGTH_LONG).show();
                        classficacao = "Peso Ideal";
                    }
                    if (resultadoFinal >= 25 && resultadoFinal <= 29.9) {
                        Toast.makeText(CalculoIMC.this, "Acima do Peso", Toast.LENGTH_LONG).show();
                        classficacao = "Acima do peso";
                    }
                    if (resultadoFinal >= 30 && resultadoFinal <= 34.9) {
                        Toast.makeText(CalculoIMC.this, "Obesidade", Toast.LENGTH_LONG).show();
                        classficacao = "Obesidade";
                    }
                    if (resultadoFinal >= 35 && resultadoFinal <= 40) {
                        Toast.makeText(CalculoIMC.this, "Obesidade Severa", Toast.LENGTH_LONG).show();
                        classficacao = "Obesidade Severa";
                    }
                    if (resultadoFinal > 40) {
                        Toast.makeText(CalculoIMC.this, "Obesidade Mórbida", Toast.LENGTH_LONG).show();
                        classficacao = "Obesidade Mórbida";
                    }

                    /* Adicionando valores ao banco de dados e exibindo mensagem de sucesso.
                       bd.doubleValue pega o valor do resultado final formatado. */
                    db.addIMC(new imcSQL(pesoTemp, alturaTemp, bd.doubleValue(), classficacao));

                    //Alternando para tela de resultado//
                    Intent it = new Intent(CalculoIMC.this, resultado.class);
                    startActivity(it);

                    // Caso haja algum erro a aplicação gera uma excessão e um mensagem de erro//
                }catch (IllegalArgumentException ia){

                }catch (ArithmeticException e){

                }catch (Exception ex){

                }
            }
        });

        /*imcSQL imcsql = new imcSQL();
        imcsql.setCodigo(1);
        imcsql.setCodigo(2);
        db.apagarIMC(imcsql);
        Toast.makeText(CalculoIMC.this, "Apagado com sucesso", Toast.LENGTH_LONG).show();
        */
    }

}
