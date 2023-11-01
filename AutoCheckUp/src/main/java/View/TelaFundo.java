package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class TelaFundo {

     private JPanel jpFundo;
     private JLabel jlImagemFundo;

     public TelaFundo(JPanel jp1) {

          inicializa(jp1);

     }

     private void inicializa(JPanel jp1) {

          SpringLayout layout = new SpringLayout();

          jpFundo = new JPanel(layout);
          jpFundo.setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));

          jpFundo.setBackground(new Color(0, 0, 0, 0));
          jp1.setBackground(new Color(0, 0, 0, 0));

          jlImagemFundo = new JLabel(new ImageIcon("src/main/java/Images/telaPrincipal.png"));

          jpFundo.add(jlImagemFundo);
          jpFundo.add(jp1);
          jpFundo.setComponentZOrder(jp1, 0);

          Tela.visor.getContentPane().removeAll();
          Tela.visor.add(jpFundo);
          Tela.visor.setOpacity(1f);
          Tela.visor.setVisible(true);

     }
}
