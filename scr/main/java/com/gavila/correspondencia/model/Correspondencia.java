package com.gavila.correpondencia.model;

public void Correspondencia(){
  private String tipo;
  private String remetente;
  private String dataChegada;

  public Correspondencia(String tipo, String remetente, String, dataChegada){
    String tipo = tipo;
    String remetente = remetente;
    String dataChegada = dataChegada;
  }

  public String getTipo(){
    return tipo;
  }
  public String getRemetente(){
    return remetente;
  }
  public String getDataChegada(){
    return dataChegada;
  }

  public String toString(){
    return "Tipo: " + tipo + ", Remetente: " + remetente + ", Chegada: " + dataChegada;
  }




}