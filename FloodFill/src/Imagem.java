import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Imagem {
    BufferedImage imagem;
    int largura;
    int altura;
    String caminho;

    public Imagem (String caminho) {
        try {
            this.imagem = ImageIO.read(new File(caminho));
            this.largura = imagem.getWidth();
            this.altura = imagem.getHeight();
            this.caminho = caminho;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public int getCorPixel (Cordenada cordenada) {
        return imagem.getRGB(cordenada.getX(), cordenada.getY());
    }

    public void setCorPixel (Cordenada cordenada, int cor) {
        imagem.setRGB(cordenada.getX(), cordenada.getY(), cor);
    }

    public BufferedImage getImagem () {
        return imagem;
    }

    public int getLargura () {
        return largura;
    }

    public int getAltura () {
        return altura;
    }

}
