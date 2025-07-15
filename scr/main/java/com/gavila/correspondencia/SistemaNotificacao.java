  package com.gavila.correspondencia;

  import com.edifice.correspondencia.model.Apartamento;
  import com.edifice.correspondencia.model.Correspondencia;

  import java.time.LocalDate; // Para trabalhar com datas de forma mais robusta
  import java.time.format.DateTimeFormatter; // Para formatar a data
  import java.util.HashMap;    // Importa a classe HashMap
  import java.util.Map;        // Importa a interface Map
  import java.util.Scanner;    // Para ler a entrada do usuário

public class SistemaNotificacao{
  //map rastreia chaves para valores
  private Map<Integer, Apartamento> apartamentos;

    //contrutor da classe  SistemaNotificacao
  public SistemaNotificacao(){
    this.apartamento = new HashMap<>();
  }

  public Apartamento adicionarApartamento(int numeroApartamento){
    //se nao existir cria e adiciona
    partamentos.putIfAbsent(numeroApartamento, new Apartamento(numeroApartamento));
    //retorna o ap novo ou ja existente
    return apartamentos.get(numeroApartamento)
  }

  //Registra uma noca correspondencia para um ap
  public void resgistrarCorrespondencia(int numeroApartamento, String tipo, String remetente){
    //obtem o apartamento, cria se nao exeistir
    Apartamento apto = adicionarApartamento(numeroApartamento);
    
    //obtem a data atual do sistema no dd/mm/yyyy
    String dataAtual = LocalDate.now().formate(DateTimeFormatter.ofPattern("dd/MM/yyyy"));//localdate.now obtem a data atual, depois .format() utiliza o datetimeformatter para configurar no padrao informado.
    
    Correspondencia novaCorrespondencia = new Correspondencia(tipo, remetente, dataAtual);

    //adiciona correspondencia e imprime uma mensagem confirmação
    apto.adicionarCorrespondencia(novaCorrespondencia);
    System.out.println("Correspondencia ('" + tipo + "' de '" + remetente + "') registrada para o Apt. " + numeroApartamento + ".");
  }

  //lista todas as correspondencias recebida por um apartamento
  public void listarCorrespondenciasApartamento(int numeroApartamento){
    if (apartamentos.containsKey(numeroApartamento)){ //verifica se o apto existe
      Apartamento apto == apartamentos.get(numeroApartamento);
      List<Correspondencia> correspondencias = apto.getCorrespondencias();

      System.out.println("\n--- Correspondencias para o Apartamento " + numeroApartamento + " ---");
      if (correspondencias.isEmpty()){
        System.out.println("Nenhuma correspondencia registrada para este apartamento.");
      }else{
        for(correspondencia c : correspondencias){
          System.out.println("- " + c);
        }
      }
      System.out.println("----------------------------------------------");
    }else{
      System.out.println("Apartamento " + numeroApartamento + " não encontrado no sistema.");
    }
  }
}