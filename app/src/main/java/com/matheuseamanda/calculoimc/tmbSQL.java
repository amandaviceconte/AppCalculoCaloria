package com.matheuseamanda.calculoimc;

public class tmbSQL {
    int codigo;
    double peso;
    double altura;
    int idade;
    String sexo;
    double resultado;

    public tmbSQL() {

    }

    public tmbSQL(int _codigo, double _peso, double _altura, int _idade, String _sexo, double _resultado)
    {
        this.peso = _peso;
        this.altura = _altura;
        this.idade = _idade;
        this.sexo = _sexo;
        this.resultado = _resultado;
    }

    public tmbSQL(double _peso, double _altura, int _idade, String _sexo, double _resultado)
    {
        this.peso = _peso;
        this.altura = _altura;
        this.idade = _idade;
        this.sexo = _sexo;
        this.resultado = _resultado;
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

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
