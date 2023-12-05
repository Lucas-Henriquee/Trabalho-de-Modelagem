package View;

import java.awt.*;
import javax.swing.*;

public class TelaEntrada {

     private JPanel jpFundo;
     private JPanel jpPlano;
     private JLabel jlImagemFundo;
     private JLabel jlImagemLogotipo;

     public TelaEntrada() {

          inicializa();
     }

     private void inicializa() {

          SpringLayout layout = new SpringLayout();

          jpFundo = new JPanel(layout);
          jpPlano = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 210));

          jpFundo.setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          jpPlano.setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));

          jpPlano.setBackground(new Color(0, 0, 0, 0));
          jpFundo.setBackground(new Color(0, 0, 0, 0));

          jlImagemFundo = new JLabel(new ImageIcon("src/main/java/Images/tela_entrada.png"));
          jlImagemLogotipo = new JLabel(new ImageIcon("src/main/java/Images/Logotipo.png"));

          jpPlano.add(jlImagemLogotipo, 0);
          jpFundo.add(jlImagemFundo);
          jpFundo.add(jpPlano);
          jpFundo.setComponentZOrder(jpPlano, 0);

          Tela.visor.add(jpFundo);
          Tela.visor.setOpacity(1f);
          Tela.visor.setVisible(true);

          try {
               Thread.sleep(4500);
          } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
          }

          new TelaLogin();

     }

}
