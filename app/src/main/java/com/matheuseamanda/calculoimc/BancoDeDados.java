package com.matheuseamanda.calculoimc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados extends SQLiteOpenHelper {

    //CRIAÇÃO DO BANCO//
    private static final int VERSAO_BANCO = 2;
    private static final String BANCO_IMC = "BD_IMCTMB";

    //CRIAÇÃO DA TABELA DE IMC//
    private static final String TABELA_IMC = "tb_imc";

    private static final String COLUNA_CODIGO = "cod";
    private static final String COLUNA_PESO = "peso";
    private static final String COLUNA_ALTURA = "altura";
    private static final String COLUNA_RESULTADO = "resultado";
    private static final String COLUNA_CLASS = "classificacao";

    //CRIAÇÃO DA TABELA DE TMB//

    private static final String TABELA_TMB = "tb_tmb";

    private static final String COLUNA_CODIGOTMB = "cod";
    private static final String COLUNA_PESOTMB = "peso";
    private static final String COLUNA_ALTURATMB = "altura";
    private static final String COLUNA_IDADETMB = "idade";
    private static final String COLUNA_SEXOTMB = "sexo";
    private static final String COLUNA_RESULTADOTMB = "resultado";

    public BancoDeDados(Context context) {
        super(context, BANCO_IMC, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String QUERY_COLUNA = "CREATE TABLE " + TABELA_IMC + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_PESO + " DOUBLE, "
                + COLUNA_ALTURA + " DOUBLE, " + COLUNA_RESULTADO + " DOUBLE, "
                + COLUNA_CLASS + " TEXT)";

        db.execSQL(QUERY_COLUNA);

        String QUERY_COLUNA2 = "CREATE TABLE " + TABELA_TMB + "("
                + COLUNA_CODIGOTMB + " INTEGER PRIMARY KEY, " + COLUNA_PESOTMB + " DOUBLE, "
                + COLUNA_ALTURATMB + " DOUBLE, " + COLUNA_IDADETMB + " INT, " + COLUNA_SEXOTMB + " TEXT, "
                + COLUNA_RESULTADOTMB + " DOUBLE)";

        db.execSQL(QUERY_COLUNA2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    void addIMC(imcSQL imcsql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_PESO, imcsql.getPeso());
        values.put(COLUNA_ALTURA, imcsql.getAltura());
        values.put(COLUNA_RESULTADO, imcsql.getResultado());
        values.put(COLUNA_CLASS, imcsql.getClassificacao());

        db.insert(TABELA_IMC, null, values);
        db.close();
    }

    void apagarIMC (imcSQL imcsql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABELA_IMC, COLUNA_CODIGO + " = ?", new String[] { String.valueOf(imcsql.getCodigo())});

        db.close();
    }

    imcSQL selecionarIMC(int codigo)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_IMC, new String[] {COLUNA_CODIGOTMB,
        COLUNA_PESOTMB, COLUNA_ALTURATMB, COLUNA_IDADETMB, COLUNA_RESULTADOTMB}, COLUNA_CODIGO + " = ?",
                new String[] {String.valueOf(codigo)}, null, null, null , null);

        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        imcSQL imcsql = new imcSQL(Integer.parseInt(cursor.getString(0)),
                cursor.getDouble(1), cursor.getDouble(2), cursor.getDouble(3),
                cursor.getString(4));

        return imcsql;
    }

    public List<imcSQL> listaTodosIMC(){
        List<imcSQL> ListaHistorico = new ArrayList<imcSQL>();

        String query = "SELECT * FROM " + TABELA_IMC;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                imcSQL imcsql = new imcSQL();
                imcsql.setCodigo(Integer.parseInt(c.getString(0)));
                imcsql.setPeso(c.getDouble(1));
                imcsql.setAltura(c.getDouble(2));
                imcsql.setResultado(c.getDouble(3));
                imcsql.setClassificacao(c.getString(4));

                ListaHistorico.add(imcsql);
            }while (c.moveToNext());
        }
        return ListaHistorico;
    }

    void addTMB (tmbSQL tmbsql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_PESOTMB, tmbsql.getPeso());
        values.put(COLUNA_ALTURATMB, tmbsql.getAltura());
        values.put(COLUNA_IDADETMB, tmbsql.getIdade());
        values.put(COLUNA_SEXOTMB, tmbsql.getSexo());
        values.put(COLUNA_RESULTADOTMB, tmbsql.getResultado());

        db.insert(TABELA_TMB, null, values);
        db.close();
    }

    void apagarTMB (tmbSQL tmbsql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABELA_TMB, COLUNA_CODIGO + " = ?", new String[] { String.valueOf(tmbsql.getCodigo())});

        db.close();
    }

    tmbSQL selecionarTMB(int codigo)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_TMB, new String[] {COLUNA_CODIGO,
                        COLUNA_PESO, COLUNA_ALTURA, COLUNA_IDADETMB, COLUNA_SEXOTMB, COLUNA_RESULTADOTMB}, COLUNA_CODIGO + " = ?",
                new String[] {String.valueOf(codigo)}, null, null, null , null);

        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        tmbSQL tmbsql = new tmbSQL(Integer.parseInt(cursor.getString(0)),
                cursor.getDouble(1), cursor.getDouble(2), cursor.getInt(3),
                cursor.getString(4), cursor.getDouble(5));

        return tmbsql;
    }

    public List<tmbSQL> listaTodosTMB(){
        List<tmbSQL> ListaHistorico = new ArrayList<tmbSQL>();

        String query = "SELECT * FROM " + TABELA_TMB;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                tmbSQL tmbsql = new tmbSQL();
                tmbsql.setCodigo(Integer.parseInt(c.getString(0)));
                tmbsql.setPeso(c.getDouble(1));
                tmbsql.setAltura(c.getDouble(2));
                tmbsql.setIdade(c.getInt(3));
                tmbsql.setSexo(c.getString(4));
                tmbsql.setResultado(c.getDouble(5));


                ListaHistorico.add(tmbsql);
            }while (c.moveToNext());
        }
        return ListaHistorico;
    }













}
