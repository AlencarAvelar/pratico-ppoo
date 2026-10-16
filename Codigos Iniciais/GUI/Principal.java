import java.util.HashMap;
/**
 *
 * @author Luiz Merschmann
 */
public class Principal {

    public static void main(String[] args) {
        HashMap<String, Posicao> referencias = new HashMap<>();
        referencias.put("Quarto 1", new Posicao(4, 2));
        referencias.put("Quarto 2", new Posicao(16, 2));
        referencias.put("WC 1", new Posicao(4, 6));
        referencias.put("WC 2", new Posicao(16, 6));
        referencias.put("Sala de Jantar", new Posicao(4, 10));
        referencias.put("Cozinha", new Posicao(16, 10));
        referencias.put("Sala de TV", new Posicao(4, 14));
        referencias.put("Área de Serviço", new Posicao(16, 14));
        referencias.put("Corredor", new Posicao(9, 6));
        Simulacao sim = new Simulacao();
        
        
        for(String origem: referencias.keySet()){
            for(String destino: referencias.keySet()){
                if(!origem.equals(destino)){
                    System.out.println("Origem: " + origem + "\tDestino: " + destino);
                    System.out.println("Procurando o caminho ...");
                    sim.executarSimulacao(referencias.get(origem),referencias.get(destino));
                }
            }    
        }
        System.out.println("Simulação concluída.");

    }
}
