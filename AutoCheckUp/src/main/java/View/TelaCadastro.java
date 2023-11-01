package View;

import java.awt.*;
import javax.swing.*;

public class TelaCadastro {

     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;

     public TelaCadastro() {

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

          layout.gridy = 0;
          jpPlano.add(jpPanel1, layout);

          layout.gridy = 1;
          jpPlano.add(jpPanel2, layout);

          layout.gridy = 2;
          jpPlano.add(jpPanel3, layout);

          new TelaFundo(jpPlano);

     }

     private void painel1() {

          jpPanel1 = new JPanel(new GridBagLayout());
          jpPanel1.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(90, 45, 15, 180);

          JLabel jlVoltar = new JLabel(new ImageIcon("src/main/java/Images/botao-voltar.png"));
          jlVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));

          layout.gridy = 0;
          jpPanel1.add(jlVoltar, layout);

     }

     private void painel2() {

          jpPanel2 = new JPanel(new GridBagLayout());
          jpPanel2.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(3, 41, 0, 180);

          JLabel jlCadastro = new JLabel("Cadastro do veículo");
          jlCadastro.setForeground(Color.black);
          jlCadastro.setFont(new Font("Arial", 0, 30));

          JLabel jlEntreDados = new JLabel("Entre com os dados do seu veículo");
          jlEntreDados.setForeground(Color.black);
          jlEntreDados.setFont(new Font("Arial", 0, 15));

          layout.gridy = 0;
          jpPanel2.add(jlCadastro, layout);

          layout.gridy = 1;
          jpPanel2.add(jlEntreDados, layout);

     }

     private void painel3() {

          jpPanel3 = new JPanel(new GridBagLayout());
          jpPanel3.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(5, 40, 0, 180);

          JLabel jlEspaco = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco.setForeground(new Color(0, 0, 0, 0));
          jlEspaco.setFont(new Font("Arial", 0, 15));

          JLabel jlDNome = new JLabel("Digite o nome*");
          jlDNome.setForeground(Color.black);
          jlDNome.setFont(new Font("Arial", 0, 11));

          JTextField jtfNome = new JTextField(20);
          jtfNome.setForeground(Color.black);
          jtfNome.setFont(new Font("Arial", 0, 20));

          layout.gridy = 0;
          jpPanel3.add(jlEspaco, layout);

          layout.gridy = 1;
          jpPanel3.add(jlDNome, layout);

          layout.gridy = 2;
          jpPanel3.add(jtfNome, layout);

     }

}
