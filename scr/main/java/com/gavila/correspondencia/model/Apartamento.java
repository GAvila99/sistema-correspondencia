package com.gavila.correspondencia.model;

import java.util.List;
import java.util.ArrayList;

public class Apartamento(){
  private int numeroAp  ; //numero do apartamento
  private List<Correspondencia> correspondenciasRecebida;

  //metodo construtor partamento
  public Apartamento(int numeroAp){
    this.numeroAp = numeroAp;
    this.correspondenciasRecebida = new ArrayList<>();//inicia uma lista toda vez que um ap e criado
  }

  //metodo acesso ao atributo
  public int getNumeroAp(){
    return numeroAp;
  }

  //Adiciona uma correspondencia ao apartamento
  public void adicionarCorrespondencia(Correspondencia correspondencia){
    this.correspondenciasRecebidas.add(correspondencia);
    System.out.println("Correspondencia registrada para o Apartamento " +     this.numero + ": " + correspondencia.getTipo());
  }

  //metodo retorna lista de correspondencia
  public List<Correspondencia> getCorrespondencias(){
    return correspondenciasRecebidas;
  }

  //metodo de apresentacao
  public String toString(){
    return "Apartamento " + numeroAp + " (Total de correspondências: " + correspondenciasRecebidas.size() + ")";
  }
  
  



}