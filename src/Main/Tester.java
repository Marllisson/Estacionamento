
package Main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import conexoes.ConexaoBD;

import desenvolvimento.*;


public class Tester {
    public static void main(String[] args) {

        Estacionamento estacionamento = new Estacionamento();
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        
        
        do {
            System.out.println("---------------------");
            System.out.println("Menu:");
            System.out.println("1-Entrada Veículo");
            System.out.println("2-Saída Veículo");
            System.out.println("3-Listar Veículos");
            System.out.println("4-Finalizar");
            System.out.println("5-Teste do banco");
            System.out.println("Informe a opção: ");
            menu = scan.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Entrada de Veículo: ");

                    /**
                     * Informações do veículo que serão solicitadas 
                     * Placa 
                     * Modelo
                     * Tipo
                     */
                    String placaEntrada, modelo;
                    String tipo = "";
                    int opcao;
                    boolean flagPlaca, flagTipo;
                    
                    flagPlaca=false;
                    do{
                        //Área que recebe a placa e verifica se está em conformidade
                    scan.nextLine();
                    System.out.println(" Placa do Veículo: ");
                    System.out.println("Padrão (3 letras e 4 numeros - não utilize espaços ou travesão)");
                    System.out.println("Exemplo Padrão: LLLNNNN");
                    System.out.println("Digite a Placa do veículo: ");
                    placaEntrada = scan.nextLine();
                    
                    placaEntrada = placaEntrada.toUpperCase();
                    //Validado simples para avaliar apenas o tamanho da placa
                    if(placaEntrada.length() == 7 ){
                        flagPlaca=true;
                        System.out.println("Placa está OK");
                    }else if (placaEntrada.length() < 7 || placaEntrada.length() > 7){
                        flagPlaca=false;
                        System.out.println("Erro Placa nformada fora do padrão especificado LLLNNNN");
                    }
                    
                    }while(!flagPlaca);
                    
                    //Solicita o tipo do veículo
                    
                    flagTipo=false;
                    do{
                    System.out.println("Tipo do Veículo digite ");
                    System.out.println("1 - CARRO");
                    System.out.println("2 - MOTO");
                    System.out.println("Informe a Opção: ");
                    opcao = scan.nextInt();
                    if(opcao == 1 )  {
                        tipo = "CARRO";
                        flagTipo = true;
                    }else if(opcao == 2){
                        tipo = "MOTO";
                        flagTipo = true;
                    }else{
                        System.out.println("");
                        System.out.println("Opção inválida Digite 1=CARRO e 2=MOTO");
                        System.out.println("");
                    }
                    }while(!flagTipo);
                    
                    //Solicita modelo do veículo
                    scan.nextLine();
                    System.out.println("Informe Modelo: ");
                    modelo = scan.nextLine();
                    modelo = modelo.toUpperCase();
                    
                    System.out.println(estacionamento.entraVeiculo(placaEntrada,modelo, Tipo.valueOf(tipo)));
                    //mostra entrada do veículo
                    estacionamento.pesquisaVeiculo(placaEntrada);
                    break;

                case 2:
                    String placaSaida;

                    System.out.println("Saída de Veículo: ");
                    System.out.println("------");
                    scan.nextLine();
                    
                    System.out.println("Informar placa");
                    placaSaida=scan.nextLine();
                    placaSaida = placaSaida.toUpperCase();
                    

                    Calendar c = Calendar.getInstance();
                    System.out.println("Data/Hora atual: "+c.getTime());

                    System.out.print("Valor a pagar: R$");
                    System.out.println(estacionamento.saiVeiculo(placaSaida));
                    
                    
                    break;

                case 3:

                    System.out.println("Listar Veículos no Estacionamento");
                    ArrayList<Veiculo> lista = estacionamento.listaEstacionados();
                    for (int i = 0; i < lista.size(); i++)
                        System.out.println(lista.get(i).getPlaca());
                    break;
                case 4:
                    //Finaliza Sistema opção4
                    System.out.println("Finalizando programa");
                    System.exit(0);
                    break;
                    
                case 5:
                    //Teste de conexão do banco 
                    ConexaoBD conexaoBancoDados = new ConexaoBD();
                    conexaoBancoDados.conectat();
                    conexaoBancoDados.desconectar();
                    
                    
                default:
                    System.out.println("Opção invalida! ");
            }


        } while (menu != 4);
    }
}
