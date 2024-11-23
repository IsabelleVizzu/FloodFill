import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFila {

    public static void main(String[] args) {

        Imagem imagem = new Imagem("Imagem/imagem3.png");
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica(imagem, "Exibindo Imagem Original");

        Fila fila = new Fila(imagem.getAltura() * imagem.getLargura());


        int x = escolherCoordenada(imagem, "Escolha uma coordenada para o X (dentro do limite 0 à " + (imagem.getLargura() - 1) + "): ", imagem.getLargura());
        int y = escolherCoordenada(imagem, "Escolha uma coordenada para o Y (dentro do limite 0 à " + (imagem.getAltura() - 1) + "): ", imagem.getAltura());

        interfaceGrafica.mostrarImagem();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Cordenada cordenada = new Cordenada(x,y);
        int corInicial = imagem.getCorPixel(cordenada);
        int corEscolhida = new Color(255, 105, 180).getRGB();
        fila.add(cordenada);


        while (!fila.isEmpty()) {
            Cordenada cordenadaPop = fila.remove();
            x = cordenadaPop.getX();
            y = cordenadaPop.getY();


            if (x < imagem.getLargura() && x >= 0 && y >= 0 && y < imagem.getAltura()) {
                if (imagem.getCorPixel(cordenadaPop) == corInicial) {
                    imagem.setCorPixel(cordenadaPop, corEscolhida);

                    fila.add(new Cordenada(x + 1, y));
                    fila.add(new Cordenada(x - 1, y));
                    fila.add(new Cordenada(x, y - 1));
                    fila.add(new Cordenada(x, y + 1));
                }
            }
        }

        InterfaceGrafica interfaceGrafica1 = new InterfaceGrafica(imagem, "Exibindo Imagem Pintada");
        interfaceGrafica1.mostrarImagem();

    }

    public static int escolherCoordenada (Imagem imagem, String mensagem, int limite) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(mensagem);
                int cord = scanner.nextInt();
                if (cord >= 0 && cord < limite) {
                    return cord;
                }
                System.out.println("A coordenada deve estar dentro do limite.");
            }
            catch (InputMismatchException e) {
                System.out.println("A coordenada deve ser um número inteiro!");
                scanner.next();
            }
        }
    }

}
