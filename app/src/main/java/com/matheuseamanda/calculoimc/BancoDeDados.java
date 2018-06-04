package com.matheuseamanda.calculoimc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 2;
    private static final String BANCO_IMC = "BD_IMC";

    private static final String TABELA_IMC = "tb_imc2";

    private static final String COLUNA_CODIGO = "cod";
    private static final String COLUNA_PESO = "peso";
    private static final String COLUNA_ALTURA = "altura";
    private static final String COLUNA_RESULTADO = "resultado";
    private static final String COLUNA_CLASS = "classificacao";
    private static final String COLUNA_DATA = "data";


    public BancoDeDados(Context context) {
        super(context, BANCO_IMC, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String QUERY_COLUNA = "CREATE TABLE " + TABELA_IMC + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_PESO + " DOUBLE, "
                + COLUNA_ALTURA + " DOUBLE, " + COLUNA_RESULTADO + " DOUBLE, "
                + COLUNA_CLASS + " TEXT, " + COLUNA_DATA + " DATETIME DEFAULT CURRENT_TIMESTAMP )";

        db.execSQL(QUERY_COLUNA);

        /*
        String QUERY_COLUNA = "CREATE TABLE " + TABELA_IMC + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_PESO + " DOUBLE, "
                + COLUNA_ALTURA + " DOUBLE, " + COLUNA_RESULTADO + " DOUBLE, " + COLUNA_DATA + " DATETIME DEFAULT CURRENT_TIMESTAMP )";
                */
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

   /* imcSQL selecionarIMC(imcSQL imcsql)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_IMC, new String[] {COLUNA_CODIGO,
        COLUNA_PESO, COLUNA_ALTURA, COLUNA_RESULTADO}, COLUNA_CODIGO + " = ?",
                new String[] {String.valueOf(imcsql.getCodigo())}, null, null, null, null);

        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        imcSQL imcsql1 = new imcSQL(Integer.parseInt(cursor.getString(0)),
                cursor.getDouble(1), cursor.getDouble(2), cursor.getDouble(3));

        return imcsql;
    }*/

}
