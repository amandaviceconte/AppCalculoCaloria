package com.matheuseamanda.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class historico_tmb extends AppCompatActivity {
    BancoDeDados db = new BancoDeDados(this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_tmb);

        listarTMB();
    }

    public void listarTMB()
    {
        ListView ListViewTMB = findViewById(R.id.listViewTMB);

        List<tmbSQL> tmbsqls = db.listaTodosTMB();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(historico_tmb.this, android.R.layout.simple_list_item_1, arrayList);

        ListViewTMB.setAdapter(adapter);

        for(tmbSQL i : tmbsqls){
            arrayList.add(i.getCodigo() + " - " + i.getPeso() + " - " + i.getAltura() + " - " + i.getIdade() + " - " + i.getSexo()
            + " - " + i.getResultado());
            adapter.notifyDataSetChanged();
        }
    }



}
