  package com.gavila.correspondencia;

  import com.gavila.correspondencia.model.Apartamento;
  import com.gavila.correspondencia.model.Correspondencia;

  import java.time.LocalDate; // Para trabalhar com datas de forma mais robusta
  import java.time.format.DateTimeFormatter; // Para formatar a data
  import java.util.HashMap;    // Importa a classe HashMap
  import java.util.Map;        // Importa a interface Map
  import java.util.Scanner;    // Para ler a entrada do usuário
  import java.util.List;       // Para u=importar a classe list

public class SistemaNotificacao{
  //map rastreia chaves para valores
  private Map<Integer, Apartamento> apartamentos;

    //contrutor da classe  SistemaNotificacao
  public SistemaNotificacao(){
    this.apartamentos = new HashMap<>();
  }

  public Apartamento adicionarApartamento(int numeroApartamento){
    //se nao existir cria e adiciona
    apartamentos.putIfAbsent(numeroApartamento, new Apartamento(numeroApartamento));
    //retorna o ap novo ou ja existente
    return apartamentos.get(numeroApartamento);
  }

  //Registra uma noca correspondencia para um ap
  public void registrarCorrespondencia(int numeroApartamento, String tipo, String remetente){
    //obtem o apartamento, cria se nao exeistir
    Apartamento apto = adicionarApartamento(numeroApartamento);
    
    //obtem a data atual do sistema no dd/mm/yyyy
    String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));//localdate.now obtem a data atual, depois .format() utiliza o datetimeformatter para configurar no padrao informado.
    
    Correspondencia novaCorrespondencia = new Correspondencia(tipo, remetente, dataAtual);

    //adiciona correspondencia e imprime uma mensagem confirmação
    apto.adicionarCorrespondencia(novaCorrespondencia);
    System.out.println("Correspondencia ('" + tipo + "' de '" + remetente + "') registrada para o Apt. " + numeroApartamento + ".");
  }

  //lista todas as correspondencias recebida por um apartamento
  public void listarCorrespondenciasApartamento(int numeroApartamento){
    if (apartamentos.containsKey(numeroApartamento)){ //verifica se o apto existe
      Apartamento apto = apartamentos.get(numeroApartamento);
      List<Correspondencia> correspondencias = apto.getCorrespondencias();

      System.out.println("\n--- Correspondencias para o Apartamento " + numeroApartamento + " ---");
      if (correspondencias.isEmpty()){
        System.out.println("Nenhuma correspondencia registrada para este apartamento.");
      }else{
        for(Correspondencia c : correspondencias){
          System.out.println("- " + c);
        }
      }
      System.out.println("----------------------------------------------");
    }else{
      System.out.println("Apartamento " + numeroApartamento + " não encontrado no sistema.");
    }
  }

  //metodo principal de execucao
  public static void main(String[] args){
    SistemaNotificacao sistema = new SistemaNotificacao();
    Scanner input = new Scanner(System.in);
    int opcao;

    //enqanto opcao for diferente de 0
    do{
      System.out.println("\n--- Menu do Sistema --");
      System.out.println("1. Registrar nova correspondencia");
      System.out.println("2. Listar correspondencias de um Apto");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");

      try{
        opcao = Integer.parseInt(input.nextLine()); //le a opcao como string e convrte para int
        switch (opcao){
          case 1:
            System.out.print("Digite o numero do apartamento: ");
            int aptoRegistro = Integer.parseInt(input.nextLine());
            System.out.print("Digite o tipo da correspondencia (Ex: Carta, Pacote): ");
            String tipoCorrespondencia = input.nextLine();
            System.out.print("Digite o remetente: ");
            String remetenteCorrespondencia = input.nextLine();
            sistema.registrarCorrespondencia(aptoRegistro, tipoCorrespondencia, remetenteCorrespondencia);
            break;
          case 2:
            System.out.println("Digite o numero do apartamento para listar: ");
            int aptoLista = Integer.parseInt(input.nextLine());
            sistema.listarCorrespondenciasApartamento(aptoLista);
            break;
          case 0:
            System.out.println("Saindo do sistema!");
            break;
          default:
            System.out.println("opção invalida. Por Favor, digite um numeri.");
        }
      }catch (NumberFormatException e){
        System.out.println("Entrada invalida. Por favor, digite um numero.");
        opcao = -1;
      }catch (Exception e){
        System.out.println("Ocorreu um erro inesperado: " + e.getMessage()); //retorna descricao textual do erro
        opcao = -1;
      }
    }while(opcao != 0);
    input.close();//feha  input(scanner) e libera recurso
  }
}

