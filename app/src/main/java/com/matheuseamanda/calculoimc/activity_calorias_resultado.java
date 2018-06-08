package com.matheuseamanda.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button btnTMBVoltarMenu = (Button) findViewById(R.id.voltarMenuBtn);
        btnTMBVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(activity_calorias_resultado.this, Home_Activity.class);
                startActivity(it);
            }
        });

    }
}
