import javax.swing.*;
import java.awt.*;
import java.io.File;

public class InterfaceGrafica {
    JFrame frame;
    JLabel label;

    public InterfaceGrafica(Imagem imagem, String nome) {
        this.frame = new JFrame(nome);
        this.label = new JLabel(new ImageIcon(imagem.getImagem()));
        frame.add(label);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void mostrarImagem() {
        frame.setVisible(true);
    }

}
