package com.matheuseamanda.calculoimc;

public class imcSQL
{
    int codigo;
    double peso;
    double altura;
    double resultado;
    String classificacao;

    public imcSQL()
    {

    }

    public imcSQL(int _codigo, double _peso, double _altura, double _resultado, String _classificacao)
    {
        this.peso = _peso;
        this. altura = _altura;
        this.resultado = _resultado;
        this.classificacao = _classificacao;
    }

    public imcSQL(double _peso, double _altura, double _resultado, String _classificacao)
    {
        this.peso = _peso;
        this. altura = _altura;
        this.resultado = _resultado;
        this.classificacao = _classificacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
