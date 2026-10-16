import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Parede {
    private Posicao posicaoOrigem;
    private Image imagem;

    public Parede(Posicao posicao) {
        this.posicaoOrigem = posicao;
        imagem = new ImageIcon(getClass().getResource("/Imagens/tijolo.png")).getImage();
    }

    public Posicao getPosicaoOrigem() {
        return posicaoOrigem;
    }

    public Image getImagem(){
        return imagem;
    }

}
