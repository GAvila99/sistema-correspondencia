package com.gavila.correspondencia.model;

public class Correspondencia{
  private String tipo; //Pode ser pacote, carta, documento
  private String remetente; //Quem enviou, mercado livre, amazom ou fulano de tal
  private String dataChegada;// quando chegou
  private String horaChegada; //hora que chegou

  //metodo construtor correspondencia
  public Correspondencia(String tipo, String remetente, String dataChegada, String horaChegada){
    this.tipo = tipo;
    this.remetente = remetente;
    this.dataChegada = dataChegada;
    this.horaChegada = horaChegada;
  }

  //metodos de acesso aos atributos
  public String getTipo(){
    return tipo;
  }
  public String getRemetente(){
    return remetente;  
  }
  public String getDataChegada(){
    return dataChegada;
  }
  public String getHoraChegada(){
    return this.horaChegada;
  }

  //metodo de apresentacao
  public String toString(){
    return "Tipo: " + tipo + ", Remetente: " + remetente + ", Chegada: " + dataChegada + " " + horaChegada;
  }




}