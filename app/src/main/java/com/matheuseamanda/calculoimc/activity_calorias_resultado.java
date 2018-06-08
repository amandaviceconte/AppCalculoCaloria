package com.matheuseamanda.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_calorias_resultado extends AppCompatActivity {
    BancoDeDados db = new BancoDeDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorias_resultado);

        final TextView result = findViewById(R.id.resultado);

        result.setText(String.format(""+ Calculo_Calorias.TMBFormatado));

       tmbSQL tmbsql = db.selecionarTMB(1);

        /*Toast.makeText(activity_calorias_resultado.this, "Codigo: "+ tmbsql.getCodigo() + "Peso: " + tmbsql.getPeso() + "Altura: " + tmbsql.getAltura()
                + "Idade: " + tmbsql.getIdade() + "Resultado: " + tmbsql.getResultado() , Toast.LENGTH_LONG).show();*/


    }
}
