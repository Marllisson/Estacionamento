
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBD {
   private Connection conexao;
   
   //Método que cria o banco de dados e cria o banco caso não exista
   public boolean conectat(){
       
       try{
           String url = "jdbc:sqlite:banco_de_dados/banco_estacionamento.bd"; //Caminho do local que está o banco 
           this.conexao = DriverManager.getConnection(url);
       }catch(SQLException e) {
           System.err.println(e.getMessage());
           return false;
       }
       
       System.out.println("Conectado ao Banco");
       return true;
   }
   
   //Método para desconectar do banco de dados
   public boolean desconectar(){
       try{
           //Compara se método isClosed() é falso então utiliza o métod close() para fechar
          if(this.conexao.isClosed() == false) {
              this.conexao.close();
          }
          
       }catch (SQLException e){
           System.err.println(e.getMessage());
           return false;
           
       }
       
       System.out.println("Desconectado do banco");
       return true;
   }
   
   public Connection getConexao(){
       return this.conexao;
   }
   
   /**
     * Cria os Statement para que o SQL seja execuatado
     * Statement é o reposnsável por executar os comandos sql
     * 
     * @return 
     */
   
   public Statement criarStatement(){
       try{
           return this.conexao.createStatement();
           
       }catch (SQLException e){
           return null;
       }
   }
   
   
}
