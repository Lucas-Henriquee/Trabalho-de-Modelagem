package View;

import java.awt.*;

import javax.swing.*;

public class TelaLogin {

     private JPanel jpPlano;

     private JLabel jlVoltar;

     public TelaLogin() {

          inicializa();
     }

     private void inicializa() {

          jpPlano = new JPanel(new GridBagLayout());
          jpPlano.setSize(new Dimension(420, 860));

          jlVoltar = new JLabel(new ImageIcon("src/main/java/Images/botao-voltar.png"));
          jlVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));

          new TelaFundo(jpPlano);

          try {
               Thread.sleep(10000);
          } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
          }

          Tela.visor.dispose();
          Runtime.getRuntime().exit(0);

     }
}
