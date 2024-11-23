import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPilha {
    public static void main(String[] args) {

        Imagem imagem = new Imagem("Imagem/imagem.png");
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica(imagem, "Exibindo Imagem Original");

        Pilha pilha = new Pilha(imagem.getAltura() * imagem.getLargura());

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
        pilha.push(cordenada);

        Cordenada[] listaAuxiliar = new Cordenada[4];

        listaAuxiliar[0] = new Cordenada(0, 1);
        listaAuxiliar[1] = new Cordenada(0, -1);
        listaAuxiliar[2] = new Cordenada(1, 0);
        listaAuxiliar[3] = new Cordenada(-1, 0);


        while (!pilha.isEmpty()) {
            Cordenada cordenadaPop = pilha.pop();

            imagem.setCorPixel(cordenadaPop, corEscolhida);
            for (Cordenada c : listaAuxiliar) {
                Cordenada cord = cordenadaPop.soma(c);
                if (cord.getX() < imagem.getLargura() && cord.getX() >= 0 &&
                        cord.getY() >= 0 && cord.getY() < imagem.getAltura() && imagem.getCorPixel(cord) == corInicial ) {
                    pilha.push(cord);
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
