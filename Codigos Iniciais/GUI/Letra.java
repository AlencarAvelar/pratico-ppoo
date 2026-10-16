import java.awt.*;
import java.awt.image.BufferedImage;

public class Letra {
    private Posicao posicaoOrigem;
    private Image imagem;

    public Letra(Posicao posicao, char letra) {
        this.posicaoOrigem = posicao;
        imagem = charParaImagem(letra);
    }

    public Posicao getPosicaoOrigem() {
        return posicaoOrigem;
    }

    public Image getImagem(){
        return imagem;
    }

    public Image charParaImagem(char c) {
        int largura = 40;
        int altura = 40;

        BufferedImage imagem = new BufferedImage(
            largura,
            altura,
            BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g = imagem.createGraphics();

        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.BLACK);

        g.drawString(String.valueOf(c), 5, 30);

        g.dispose();

        return imagem;
    }
    
}
