package View;

import java.awt.*;
import javax.swing.*;

public class TelaMenu {

     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;
     private JPanel jpPanel4;
     private JPanel jpPanel5;

     public TelaMenu() {

          inicializa();
     }

     private void inicializa() {

          jpPlano = new JPanel(new GridBagLayout());
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 0, 0, 0);

          painel1();

          painel2();

          painel3();

          painel4();

          painel5();

          layout.gridy = 0;
          jpPlano.add(jpPanel1, layout);

          layout.gridy = 1;
          jpPlano.add(jpPanel2, layout);

          layout.gridy = 2;
          jpPlano.add(jpPanel3, layout);

          layout.gridy = 3;
          jpPlano.add(jpPanel4, layout);

          layout.gridy = 4;
          jpPlano.add(jpPanel5, layout);

          new TelaFundo(jpPlano);

     }

     private void painel1() {

          jpPanel1 = new JPanel(new GridBagLayout());
          jpPanel1.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(90, 40, 0, 190);

          JLabel jlUsuario = new JLabel(new ImageIcon("src/main/java/Images/usuario.png"));
          jlUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));

          JLabel jlMenu = new JLabel(new ImageIcon("src/main/java/Images/menu.png"));
          jlMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));

          layout.gridx = 1;
          jpPanel1.add(jlUsuario, layout);

          layout.gridx = 0;
          jpPanel1.add(jlMenu, layout);

     }

     private void painel2() {

          jpPanel2 = new JPanel(new GridBagLayout());
          jpPanel2.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(100, 0, 20, 0);

          JLabel jlAuto = new JLabel("     Auto CheckUp");
          jlAuto.setForeground(Color.black);
          jlAuto.setFont(new Font("Arial", 1, 42));

          JLabel jlMCarros = new JLabel("                Meus Carros");
          jlMCarros.setForeground(Color.black);
          jlMCarros.setFont(new Font("Arial", 0, 28));

          layout.gridy = 0;
          layout.gridx = 0;
          jpPanel2.add(jlAuto, layout);

          layout.gridy = 1;
          layout.gridx = 0;
          jpPanel2.add(jlMCarros, layout);

     }

     private void painel3() {

          jpPanel3 = new JPanel(new GridBagLayout());
          jpPanel3.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 48, 0, 0);

          JLabel jlCarro = new JLabel(new ImageIcon("src/main/java/Images/carro.png"));

          layout.gridy = 0;
          jpPanel3.add(jlCarro, layout);

     }

     private void painel4() {

          jpPanel4 = new JPanel(new GridBagLayout());
          jpPanel4.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(20, 125, 0, 0);

          JLabel jlCarro = new JLabel("Nenhum carro cadastrado");
          jlCarro.setForeground(Color.black);
          jlCarro.setFont(new Font("Arial", 0, 14));

          layout.gridy = 0;
          jpPanel4.add(jlCarro, layout);

     }

     private void painel5() {

          jpPanel5 = new JPanel(new GridBagLayout());
          jpPanel5.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(30, 132, 0, 0);

          JLabel jlAcoes = new JLabel(new ImageIcon("src/main/java/Images/botaoAcoes.png"));
          jlAcoes.setCursor(new Cursor(Cursor.HAND_CURSOR));

          layout.gridy = 0;
          jpPanel5.add(jlAcoes, layout);

     }

}
