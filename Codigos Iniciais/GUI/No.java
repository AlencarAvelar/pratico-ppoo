public class No {

    private Posicao posicao;
    private No pai;

    private int custoG;
    private int custoH;

    public No(Posicao posicao, No pai, int custoG, int custoH) {
        this.posicao = posicao;
        this.pai = pai;
        this.custoG = custoG;
        this.custoH = custoH;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public No getPai() {
        return pai;
    }

    public int getCustoG() {
        return custoG;
    }

    public int getCustoH() {
        return custoH;
    }

    public int getCustoF() {
        return custoG + custoH;
    }
}
