package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class resultado extends AppCompatActivity {

    BancoDeDados db = new BancoDeDados(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView ExibirResultado = (TextView) findViewById(R.id.FinalResult);

        ExibirResultado.setText("" + CalculoIMC.resultadoConcatenado);

       // imcSQL imcsql = db.selecionarIMC(1);

        /*Toast.makeText(resultado.this,"Codigo: "+ imcsql.getCodigo() + "Peso: " + imcsql.getPeso() + "Altura: " + imcsql.getAltura()
                + "Resultado: " + imcsql.getResultado() + "Classificação" + imcsql.getClassificacao() , Toast.LENGTH_LONG).show();*/
        Button btnIMCVoltarMenu = (Button) findViewById(R.id.voltarMenuButton);
        btnIMCVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(resultado.this, Home_Activity.class);
                startActivity(it);
            }
        });
    }
}
