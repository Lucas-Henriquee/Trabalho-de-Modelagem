package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TelaCadastroUsuario implements MouseListener {

     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;

     private JLabel jlVoltar;
     private JLabel jlCadastrar;

     public TelaCadastroUsuario() {

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
          layout.insets = new Insets(70, 25, 15, 180);

          jlVoltar = new JLabel(new ImageIcon("src/main/java/Images/botao-voltar.png"));
          jlVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlVoltar.addMouseListener(this);

          layout.gridy = 0;
          jpPanel1.add(jlVoltar, layout);

     }

     private void painel2() {

          jpPanel2 = new JPanel(new GridBagLayout());
          jpPanel2.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(10, 30, 0, 180);

          JLabel jlLogin = new JLabel("Cadastrar Usuário");
          jlLogin.setForeground(Color.black);
          jlLogin.setFont(new Font("Arial", 0, 20));

          JLabel jlEntre = new JLabel(" Entre com seus dados");
          jlEntre.setForeground(Color.black);
          jlEntre.setFont(new Font("Arial", 1, 11));

          layout.gridy = 0;
          jpPanel2.add(jlLogin, layout);

          layout.gridy = 1;
          jpPanel2.add(jlEntre, layout);

     }

     private void painel3() {

          jpPanel3 = new JPanel(new GridBagLayout());
          jpPanel3.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(8, 30, 0, 0);

          JLabel jlEspaco = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco.setForeground(new Color(0, 0, 0, 0));
          jlEspaco.setFont(new Font("Arial", 0, 28));

          JLabel jlNome = new JLabel("Digite o seu nome");
          jlNome.setForeground(Color.black);
          jlNome.setFont(new Font("Arial", 1, 11));

          JTextField jtfNome = new JTextField("Nome Completo");
          jtfNome.setForeground(Color.GRAY);
          jtfNome.setFont(new Font("Arial", 0, 15));
          jtfNome.setPreferredSize(new Dimension(277, 33));
          jtfNome.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfNome.getText().equals("Nome Completo")) {
                         jtfNome.setText("");
                         jtfNome.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfNome.getText().isEmpty()) {
                         jtfNome.setText("Nome Completo");
                         jtfNome.setForeground(Color.GRAY);
                    }
               }
          });
          jtfNome.getDocument().addDocumentListener(new DocumentListener() {
               @Override
               public void insertUpdate(DocumentEvent e) {
                    checkText();
               }

               @Override
               public void removeUpdate(DocumentEvent e) {
                    checkText();
               }

               @Override
               public void changedUpdate(DocumentEvent e) {
                    checkText();
               }

               private void checkText() {
                    if (jtfNome.getText().isEmpty()) {
                         jtfNome.setForeground(Color.GRAY);
                    } else {
                         jtfNome.setForeground(Color.BLACK);
                    }
               }
          });

          JLabel jlEspaco2 = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco2.setForeground(new Color(0, 0, 0, 0));
          jlEspaco2.setFont(new Font("Arial", 0, 2));

          JLabel jlEmail = new JLabel("Digite o seu e-mail");
          jlEmail.setForeground(Color.black);
          jlEmail.setFont(new Font("Arial", 1, 11));

          JTextField jtfEmail = new JTextField("E-mail");
          jtfEmail.setForeground(Color.GRAY);
          jtfEmail.setFont(new Font("Arial", 0, 15));
          jtfEmail.setPreferredSize(new Dimension(277, 33));
          jtfEmail.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfEmail.getText().equals("E-mail")) {
                         jtfEmail.setText("");
                         jtfEmail.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfEmail.getText().isEmpty()) {
                         jtfEmail.setText("E-mail");
                         jtfEmail.setForeground(Color.GRAY);
                    }
               }
          });
          jtfEmail.getDocument().addDocumentListener(new DocumentListener() {
               @Override
               public void insertUpdate(DocumentEvent e) {
                    checkText();
               }

               @Override
               public void removeUpdate(DocumentEvent e) {
                    checkText();
               }

               @Override
               public void changedUpdate(DocumentEvent e) {
                    checkText();
               }

               private void checkText() {
                    if (jtfEmail.getText().isEmpty()) {
                         jtfEmail.setForeground(Color.GRAY);
                    } else {
                         jtfEmail.setForeground(Color.BLACK);
                    }
               }
          });

          JLabel jlEspaco3 = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco3.setForeground(new Color(0, 0, 0, 0));
          jlEspaco3.setFont(new Font("Arial", 0, 2));

          JLabel jlSenha1 = new JLabel("Digite a sua senha");
          jlSenha1.setForeground(Color.black);
          jlSenha1.setFont(new Font("Arial", 1, 11));

          JPasswordField passwordField1 = new JPasswordField();
          passwordField1.setText("Senha   ");
          passwordField1.setForeground(Color.GRAY);
          passwordField1.setFont(new Font("Arial", 0, 15));
          passwordField1.setPreferredSize(new Dimension(277, 33));

          passwordField1.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (String.valueOf(passwordField1.getPassword()).equals("Senha   ")) {
                         passwordField1.setText("");
                         passwordField1.setForeground(Color.BLACK);
                    }
               }

               @Override
               public void focusLost(FocusEvent e) {
                    if (String.valueOf(passwordField1.getPassword()).isEmpty()) {
                         passwordField1.setText("Senha   ");
                         passwordField1.setForeground(Color.GRAY);
                    }
               }
          });

          /*
           * SpringLayout layoutSenha = new SpringLayout();
           * 
           * JPanel jpSenha = new JPanel(layoutSenha);
           * 
           * jlImagemSenha1 = new JLabel(new
           * ImageIcon("src/main/java/Images/olho-senha-fechado.png"));
           * 
           * jpSenha.add(jtfSenha1);
           * jpSenha.add(jlImagemSenha1);
           * jpSenha.setComponentZOrder(jlImagemSenha1, 0);
           */

          JLabel jlEspaco4 = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco4.setForeground(new Color(0, 0, 0, 0));
          jlEspaco4.setFont(new Font("Arial", 0, 2));

          JLabel jlSenha2 = new JLabel("Digite novamente a sua senha");
          jlSenha2.setForeground(Color.black);
          jlSenha2.setFont(new Font("Arial", 1, 11));

          JPasswordField passwordField2 = new JPasswordField();
          passwordField2.setText("Senha   ");
          passwordField2.setForeground(Color.GRAY);
          passwordField2.setFont(new Font("Arial", 0, 15));
          passwordField2.setPreferredSize(new Dimension(277, 33));

          passwordField2.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (String.valueOf(passwordField2.getPassword()).equals("Senha   ")) {
                         passwordField2.setText("");
                         passwordField2.setForeground(Color.BLACK);
                    }
               }

               @Override
               public void focusLost(FocusEvent e) {
                    if (String.valueOf(passwordField2.getPassword()).isEmpty()) {
                         passwordField2.setText("Senha   ");
                         passwordField2.setForeground(Color.GRAY);
                    }
               }
          });

          JLabel jlEspaco5 = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco5.setForeground(new Color(0, 0, 0, 0));
          jlEspaco5.setFont(new Font("Arial", 0, 30));

          jlCadastrar = new JLabel(new ImageIcon("src/main/java/Images/botao-cadastrar-usuario-2.png"));
          jlCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlCadastrar.addMouseListener(this);

          layout.gridy = 0;
          jpPanel3.add(jlEspaco, layout);

          layout.gridy = 1;
          jpPanel3.add(jlNome, layout);

          layout.gridy = 2;
          jpPanel3.add(jtfNome, layout);

          layout.gridy = 3;
          jpPanel3.add(jlEspaco2, layout);

          layout.gridy = 4;
          jpPanel3.add(jlEmail, layout);

          layout.gridy = 5;
          jpPanel3.add(jtfEmail, layout);

          layout.gridy = 6;
          jpPanel3.add(jlEspaco3, layout);

          layout.gridy = 7;
          jpPanel3.add(jlSenha1, layout);

          layout.gridy = 8;
          jpPanel3.add(passwordField1, layout);

          layout.gridy = 9;
          jpPanel3.add(jlEspaco4, layout);

          layout.gridy = 10;
          jpPanel3.add(jlSenha2, layout);

          layout.gridy = 11;
          jpPanel3.add(passwordField2, layout);

          layout.gridy = 12;
          jpPanel3.add(jlEspaco5, layout);

          layout.gridy = 13;
          jpPanel3.add(jlCadastrar, layout);

     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlVoltar) {

               new TelaLogin();
          }

          if (e.getSource() == jlCadastrar) {
               // verificar senhas se sao iguais
               // verificar email
               new TelaLogin();
          }
     }

     @Override
     public void mousePressed(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               // faz nada
          }
     }

     @Override
     public void mouseReleased(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               // faz nada
          }
     }

     @Override
     public void mouseEntered(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               // faz nada
          }
     }

     @Override
     public void mouseExited(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               // faz nada
          }
     }
}
