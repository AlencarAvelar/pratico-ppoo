import java.util.List;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Jogador jogador;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    
    public Simulacao(){ 
        mapa = new Mapa();
        jogador = new Jogador();//Cria jogador
        janelaSimulacao = new JanelaSimulacao(mapa);
    }
    
    public void executarSimulacao(Posicao origem, Posicao destino){
        jogador.setPosicaoOrigem(origem);//Define a posicao origem do jogador
        jogador.setPosicaoDestino(destino);//Define a posicao destino do jogador
        mapa.adicionarItem(jogador);//Inicializando o mapa com o jogador
        janelaSimulacao.executarAcao();
        List<Posicao> caminho = mapa.encontrarCaminho(jogador.getPosicaoOrigem(), jogador.getPosicaoDestino());
        if (caminho != null) {
            for (int i = 0; i < caminho.size(); i++) {
                executarUmPasso(caminho.get(i));
                esperar(100);
            }
            mapa.removerItem(jogador);
        }else{
            System.out.println("Não foi possível encontrar um caminho para o destino.");
        }
        System.out.println("Movimentação concluída.");
    }

    private void executarUmPasso(Posicao proximaLocalizacao) {
        mapa.removerItem(jogador);
        jogador.executarAcao(proximaLocalizacao);
        mapa.adicionarItem(jogador);
        janelaSimulacao.executarAcao();
    }
    
    private void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
}
