package com.matheuseamanda.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;

public class Historico_IMC extends AppCompatActivity {
    BancoDeDados db = new BancoDeDados(this);

    ArrayAdapter<String> adapter;
    ArrayList <String> arrayList;

    //ListView ListViewIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico__imc);

        listarIMC();
    }

    public void listarIMC()
    {
        ListView ListViewIMC = (ListView)findViewById(R.id.listViewIMC);

        List<imcSQL> imcsqls = db.listaTodosIMC();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(Historico_IMC.this, android.R.layout.simple_list_item_1, arrayList);

        ListViewIMC.setAdapter(adapter);

        for(imcSQL i : imcsqls){
            arrayList.add(i.getCodigo() + "  -  " + i.getPeso() + "   -  " + i.getAltura() + "    -     " + i.getResultado() + "   -  " + i.getClassificacao());
            adapter.notifyDataSetChanged();
        }
    }
}
