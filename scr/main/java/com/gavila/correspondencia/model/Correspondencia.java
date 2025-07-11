package com.gavila.correpondencia.model;

public void Correspondencia(){
  private String tipo; //Pode ser pacote, carta, documento
  private String remetente; //Quem enviou, mercado livre, amazom ou fulano de tal
  private String dataChegada;// quando chegou

  //metodo construtor correspondencia
  public Correspondencia(String tipo, String remetente, String, dataChegada){
    this.tipo = tipo;
    this.remetente = remetente;
    this.dataChegada = dataChegada;
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

  //metodo de apresentacao
  public String toString(){
    return "Tipo: " + tipo + ", Remetente: " + remetente + ", Chegada: " + dataChegada;
  }




}