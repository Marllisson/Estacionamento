
package desenvolvimento;

import java.util.*;


public class Estacionamento {
    
    private Veiculo[]vagaCarro = new Veiculo[10];//Vagas do estacionamento Resevadas para carro
    private Veiculo[]vagaMoto = new Veiculo[10];//Vagas do estacionamento Resevadas para moto
    private int numCarro= 0;
    private int numMoto=0;

        public int getNumCarro() {
            return numCarro;
        }
        
        public int getNumMoto(){
            return numMoto;
        }
        
        public void setNumCarro(int numero){
            this.numCarro = numero;
        }
                public void setNumMoto(int numero){
            this.numCarro = numero;
        }
        
        public void incrementaCarro(){
            setNumCarro(getNumCarro()+1);
        }
                
        public void decrementaCarro(){
            setNumCarro(getNumCarro()-1);
        }
                
        public void incrementaMoto(){
            setNumMoto(getNumMoto()+1);
        }

        public void decrementaMoto(){
            setNumCarro(getNumCarro()-1);
        }
            
        

        public boolean entraVeiculo(String placa, String modelo, Tipo tipo){
            
            //Inserindo Carro no estacionamento
            if(tipo.equals(Tipo.CARRO)){//Avalia se o veículo é um carro
                if(getNumCarro()<vagaCarro.length){
                  Automovel carro = new Automovel(placa, modelo, Tipo.CARRO);
                  for(int a=0; a <this.vagaCarro.length; a++){
                       if(this.vagaCarro[a] == null){
                        this.vagaCarro[a] = carro;
                        incrementaCarro();
                        return true;
                       }
                }
                   
                   }else{
                    System.out.println("Estacionamento Lotado");
                    return false;
            }
                //Inserindo moto
                }else if(tipo.equals(Tipo.MOTO)){//Avalia se o veículo é uma Moto
                if(getNumCarro()<vagaMoto.length){
                  Automovel moto = new Automovel(placa, modelo, Tipo.MOTO);
                  for(int m=0; m <this.vagaMoto.length; m++){
                       if(this.vagaMoto[m] == null){
                        this.vagaMoto[m] = moto;
                        incrementaMoto();
                        return true;
                       }
                    }
                   
                   }
                
                }
                
                return false;

            
        }
        


        private void removeVeiculo(int posicao, int codTipo){
            if (codTipo == 1 ){
                this.vagaCarro[posicao] = null;
                decrementaCarro();
            }else{
                this.vagaMoto[posicao] = null;
                decrementaMoto();
            }
        }

        private float calculaConta(int g, int l){
            float total = 0;
            if (this.vaga[g][l] != null){
                Date data = new Date();
                @SuppressWarnings("deprecation")
                int horaAtual = data.getHours();
                int tempo = horaAtual - this.vaga[g][l].getHora();
                if (tempo <= 1) {
                    total = (float) this.vaga[g][l].getCustoInicial();
                } else {
                    total = (float) (((tempo - 1) * this.vaga[g][l].getCustoAdicional()) + this.vaga[g][l].getCustoInicial());
                }
            }
            return total;
        }

        public float saiVeiculo(String placa){
            float conta = 0;
            
            for (int a=0; a < this.vagaCarro.length; a++){
                if (this.vagaCarro[a] != null){
                    if (placa.equals(this.vagaCarro[a].getPlaca())){
                        conta = calculaConta(a);
                        removeVeiculo(a, 1);
                        return conta;
                    }
                } 
            }
            
            for (int m=0; m < this.vagaMoto.length; m++){
                if (this.vagaMoto[m] != null){
                    if (placa.equals(this.vagaMoto[m].getPlaca())){
                        conta = calculaConta(m);
                        removeVeiculo(m, 2);
                        return conta;
                    }
                }
            }
            return conta;
        }

        public ArrayList<Veiculo> listaEstacionados(){
            ArrayList<Veiculo> lista = new ArrayList<>();
            for (int a=0; a < this.vagaCarro.length; a++){
                if (this.vagaCarro[a] != null){
                    lista.add(this.vagaCarro[a]);
                }

            }
            
            for(int m=0; m < this.vagaMoto.length; m++){
                 if (this.vagaMoto[m] != null){
                    lista.add(this.vagaMoto[m]);
                }
            }
            
            return lista;
        }
}
           

