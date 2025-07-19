package com.gavila.correspondencia.model;

public class Morador {
    private String nome;
    private String telefone; //telefone que sera usado para notificar

    public Morador(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }

    public String toString(){
        return "Nome: " + nome + ", Telefone: " + telefone;
    }



}
