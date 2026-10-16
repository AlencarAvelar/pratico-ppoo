import java.util.List;

/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private Jogador[][] jogador;
    private Parede[][] parede;
    private Letra[][] letreiro;
    private int largura;
    private int altura;
    
    private static final int LARGURA_PADRAO = 20;
    private static final int ALTURA_PADRAO = 17;
    
    /**
     * Cria mapa para alocar itens da simulacao.
     * @param largura: largura da área de simulacao.
     * @param altura: altura da área de simulação.
     */
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        jogador = new Jogador[largura][altura];
        parede = new Parede[largura][altura];
        letreiro = new Letra[largura][altura];
        adicionarParede();
        adicionarLetreiro();
    }

    private void adicionarLetreiro() {
        // Adiciona letras do letreiro
        Posicao[] posicoes = {
            //QUARTO 1
            new Posicao(1, 2), new Posicao(2, 2), new Posicao(3, 2),
            new Posicao(4, 2), new Posicao(5, 2), new Posicao(6, 2),
            new Posicao(7, 2),
            //QUARTO 2
            new Posicao(12, 2), new Posicao(13, 2), new Posicao(14, 2),
            new Posicao(15, 2), new Posicao(16, 2), new Posicao(17, 2),
            new Posicao(18, 2),
            //WC 1
            new Posicao(2, 6), new Posicao(3, 6),
            new Posicao(4, 6), 
            //WC 2
            new Posicao(14, 6),
            new Posicao(15, 6), new Posicao(16, 6),
            //SALA JANTAR
            new Posicao(2, 9), new Posicao(3, 9), new Posicao(4, 9), new Posicao(5, 9),
            new Posicao(1, 10), new Posicao(2, 10), new Posicao(3, 10),
            new Posicao(4, 10), new Posicao(5, 10), new Posicao(6, 10),
            // COZINHA
            new Posicao(12, 10), new Posicao(13, 10), new Posicao(14, 10),
            new Posicao(15, 10), new Posicao(16, 10), new Posicao(17, 10),
            new Posicao(18, 10),
            //SALA TV
            new Posicao(1, 14), new Posicao(2, 14), new Posicao(3, 14), new Posicao(4, 14), 
            new Posicao(6, 14), new Posicao(7, 14),
            //AREA SERVIÇO
            new Posicao(14, 13), new Posicao(15, 13), new Posicao(16, 13), new Posicao(17, 13),
            new Posicao(12, 14), new Posicao(13, 14), new Posicao(14, 14), new Posicao(15, 14),new Posicao(16, 14),new Posicao(17, 14),new Posicao(18, 14),
            //CORREDOR
            new Posicao(9, 2),new Posicao(9, 3),new Posicao(9, 4), new Posicao(9, 5), new Posicao(9, 6), new Posicao(9, 7), new Posicao(9, 8),new Posicao(9, 9)

        };

        char[] letras = {'Q', 'U', 'A', 'R', 'T', 'O', '1','Q', 'U', 'A', 'R', 'T', 'O', '2','W','C','1','W','C','2','S','A','L','A','J', 'A', 'N', 'T', 'A', 'R', 'C', 'O', 'Z', 'I', 'N', 'H', 'A', 'S', 'A', 'L', 'A','T','V','A','R','E','A','S','E','R','V','I','Ç','O','C', 'O', 'R', 'R', 'E', 'D', 'O', 'R'};

        for (int i = 0; i < posicoes.length; i++) {
            letreiro[posicoes[i].getX()][posicoes[i].getY()] = new Letra(posicoes[i], letras[i]);
        }
    }

    private void adicionarParede() {
        // Adiciona paredes
        Posicao[] posicoes2 = {
            new Posicao(0,0), new Posicao(1,0), new Posicao(2,0), new Posicao(3,0),
            new Posicao(4,0), new Posicao(5,0), new Posicao(6,0), new Posicao(7,0),
            new Posicao(8,0), new Posicao(9,0), new Posicao(10,0), new Posicao(11,0),
            new Posicao(12,0), new Posicao(13,0), new Posicao(14,0), new Posicao(15,0),
            new Posicao(16,0), new Posicao(17,0), new Posicao(18,0), new Posicao(19,0),

            new Posicao(0,1), new Posicao(7,1), new Posicao(12,1), new Posicao(19,1),

            new Posicao(0,2), new Posicao(19,2),

            new Posicao(0,3), new Posicao(7,3), new Posicao(12,3), new Posicao(19,3),

            new Posicao(0,4), new Posicao(1,4), new Posicao(2,4), new Posicao(3,4),
            new Posicao(4,4), new Posicao(5,4), new Posicao(6,4), new Posicao(7,4),
            new Posicao(12,4), new Posicao(13,4), new Posicao(14,4), new Posicao(15,4),
            new Posicao(16,4), new Posicao(17,4), new Posicao(18,4), new Posicao(19,4),

            new Posicao(0,5), new Posicao(7,5), new Posicao(12,5), new Posicao(19,5),

            new Posicao(0,6), new Posicao(19,6),

            new Posicao(0,7), new Posicao(7,7), new Posicao(12,7), new Posicao(19,7),

            new Posicao(0,8), new Posicao(1,8), new Posicao(2,8), new Posicao(3,8),
            new Posicao(4,8), new Posicao(5,8), new Posicao(6,8), new Posicao(7,8),
            new Posicao(12,8), new Posicao(13,8), new Posicao(14,8),
            new Posicao(15,8), new Posicao(16,8), new Posicao(17,8),
            new Posicao(18,8), new Posicao(19,8),

            new Posicao(0,9), new Posicao(7,9), new Posicao(12,9), new Posicao(19,9),

            new Posicao(0,10), new Posicao(19,10),

            new Posicao(0,11), new Posicao(7,11), new Posicao(12,11), new Posicao(19,11),

            new Posicao(0,12), new Posicao(1,12),
            new Posicao(7,12), new Posicao(8,12),
            new Posicao(9,12), new Posicao(10,12), new Posicao(11,12),
            new Posicao(12,12), new Posicao(18,12), new Posicao(19,12),

            new Posicao(0,13), new Posicao(9,13), new Posicao(19,13),

            new Posicao(0,14), new Posicao(9,14),new Posicao(19,14),

            new Posicao(0,15), new Posicao(9,15), new Posicao(19,15),

            new Posicao(0,16), new Posicao(1,16), new Posicao(2,16),
            new Posicao(3,16), new Posicao(4,16), new Posicao(5,16),
            new Posicao(6,16), new Posicao(7,16), new Posicao(8,16),
            new Posicao(9,16), new Posicao(10,16), new Posicao(11,16),
            new Posicao(12,16), new Posicao(13,16), new Posicao(14,16),
            new Posicao(15,16), new Posicao(16,16), new Posicao(17,16),
            new Posicao(18,16), new Posicao(19,16)
        };

        for (Posicao posicao : posicoes2) {
            System.out.println("Adicionando parede em: " + posicao.getX() + ", " + posicao.getY());
            parede[posicao.getX()][posicao.getY()] = new Parede(posicao);
        }
    }
    /**
     * Cria mapa com tamanho padrao.
     */
    public Mapa(){
        this(LARGURA_PADRAO,ALTURA_PADRAO);
    }
    
    public void adicionarItem(Jogador j){
        jogador[j.getPosicaoOrigem().getX()][j.getPosicaoOrigem().getY()] = j;
    }
    
    public void removerItem(Jogador j){
        jogador[j.getPosicaoOrigem().getX()][j.getPosicaoOrigem().getY()] = null;
    }
    
    public void atualizarMapa(Jogador j){
        removerItem(j);
        adicionarItem(j);
    }
    
    public Jogador getJogador(int x, int y){
        return jogador[x][y];
    }

    public Parede getParede(int x, int y){
        return parede[x][y];
    }

    public Letra getLetra(int x, int y){
        return letreiro[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public boolean podePassar(int x, int y) {
        return estaDentro(x, y) && !temParede(x, y);
    }

    private boolean temParede(int x, int y) {
        return parede[x][y] != null;
    }
    public boolean estaDentro(int x, int y) {
        return x >= 0 && x < largura
            && y >= 0 && y < altura;
    }

    public List<Posicao> encontrarCaminho(
            Posicao origem,
            Posicao destino) {

        HeuristicaAEstrela heuristica =
            new HeuristicaAEstrela(this);

        return heuristica.encontrarCaminho(
            origem,
            destino
        );
    }
    
}
