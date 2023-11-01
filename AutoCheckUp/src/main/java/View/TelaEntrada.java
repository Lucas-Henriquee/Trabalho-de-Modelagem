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
          jpPlano = new JPanel();

          jpFundo.setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));

          jpPlano.setBackground(new Color(0, 0, 0, 0));
          jpFundo.setBackground(new Color(0, 0, 0, 0));

          jlImagemFundo = new JLabel(new ImageIcon("src/main/java/Images/telaEntrada.png"));
          jlImagemLogotipo = new JLabel(new ImageIcon("src/main/java/Images/Logotipo.png"));

          Spring x = layout.getConstraint(SpringLayout.WIDTH, jpFundo);
          Spring y = layout.getConstraint(SpringLayout.HEIGHT, jpFundo);
          SpringLayout.Constraints constraints = layout.getConstraints(jpPlano);
          constraints.setX(Spring.sum(Spring.constant(0),
                    Spring.sum(Spring.scale(x, 0.5f), Spring.scale(Spring.width(jpPlano), -0.5f))));
          constraints.setY(Spring.sum(Spring.constant(0),
                    Spring.sum(Spring.scale(y, 0.5f), Spring.scale(Spring.height(jpPlano), -0.5f))));

          jpPlano.add(jlImagemLogotipo);
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

          // new TelaLogin();
          // new TelaMenu();
          new TelaCadastro();

     }

}
