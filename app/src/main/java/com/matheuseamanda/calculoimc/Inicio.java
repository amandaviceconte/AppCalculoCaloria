package com.matheuseamanda.calculoimc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


       // Troca de tela da tela inicial pra calcular imc;
       Button TelaCalcularButton = (Button) findViewById(R.id.TelaCalcular);
       TelaCalcularButton.setOnClickListener(new View.OnClickListener(){

           public void onClick(View v)
           {
                Intent it = new Intent(Inicio.this, CalculoIMC.class);
                startActivity(it);
           }
        }); //Fim da troca de tela;




    }
}
