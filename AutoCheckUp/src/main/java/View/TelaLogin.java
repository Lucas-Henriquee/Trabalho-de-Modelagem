package View;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

import Conect.Conexao;
import Conect.Criptografia;
import Obj.Cliente;
import Obj.Stream;

public class TelaLogin implements MouseListener {

     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;
     private JPanel jpPanel4;
     private JPanel jpPanel5;
     private JPanel jpPanel6;

     private JLabel jlVoltar;
     private JLabel jlEsqueci;
     private JLabel jlCadastrar;
     private JLabel jlAcessar;
     private JLabel jlAcessarOffline;

     private JCheckBox jcbSenha;

     private JPasswordField passwordField;
     private JTextField jtfEmail;

     public TelaLogin() {

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

          painel6();

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

          layout.gridy = 5;
          jpPlano.add(jpPanel6, layout);

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
          layout.insets = new Insets(12, 30, 0, 180);

          JLabel jlLogin = new JLabel("Login");
          jlLogin.setForeground(Color.black);
          jlLogin.setFont(new Font("Arial", 0, 25));

          JLabel jlEntre = new JLabel("Entre com e-mail e senha");
          jlEntre.setForeground(Color.black);
          jlEntre.setFont(new Font("Arial", 1, 13));

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

          JLabel jlEmail = new JLabel("Digite o seu e-mail");
          jlEmail.setForeground(Color.black);
          jlEmail.setFont(new Font("Arial", 1, 11));

          jtfEmail = new JTextField("E-mail");
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

          JLabel jlEspaco2 = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco2.setForeground(new Color(0, 0, 0, 0));
          jlEspaco2.setFont(new Font("Arial", 0, 12));

          JLabel jlSenha = new JLabel("Digite a sua senha");
          jlSenha.setForeground(Color.black);
          jlSenha.setFont(new Font("Arial", 1, 11));

          passwordField = new JPasswordField();
          passwordField.setText("Senha   ");
          passwordField.setForeground(Color.GRAY);
          passwordField.setFont(new Font("Arial", 0, 15));
          passwordField.setPreferredSize(new Dimension(277, 33));

          passwordField.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (String.valueOf(passwordField.getPassword()).equals("Senha   ")) {
                         passwordField.setText("");
                         passwordField.setForeground(Color.BLACK);
                    }
               }

               @Override
               public void focusLost(FocusEvent e) {
                    if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                         passwordField.setText("Senha   ");
                         passwordField.setForeground(Color.GRAY);
                    }
               }
          });

          jcbSenha = new JCheckBox("Exibir senha");
          jcbSenha.setPreferredSize(new Dimension(150, 15));
          Font fonte = new Font("Arial", 1, 11);
          jcbSenha.setFont(fonte);
          jcbSenha.setBackground(new Color(0, 0, 0, 0));
          jcbSenha.setOpaque(false);
          jcbSenha.setFocusPainted(false);
          jcbSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));

          jcbSenha.addItemListener(new ItemListener() {
               @Override
               public void itemStateChanged(ItemEvent e) {
                    int state = e.getStateChange();
                    if (state == ItemEvent.SELECTED) {
                         passwordField.setEchoChar((char) 0);
                    } else {
                         passwordField.setEchoChar('\u2022');
                    }
               }
          });

          JLabel jlEspaco3 = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco3.setForeground(new Color(0, 0, 0, 0));
          jlEspaco3.setFont(new Font("Arial", 0, 16));

          layout.gridy = 0;
          jpPanel3.add(jlEspaco, layout);

          layout.gridy = 1;
          jpPanel3.add(jlEmail, layout);

          layout.gridy = 2;
          jpPanel3.add(jtfEmail, layout);

          layout.gridy = 3;
          jpPanel3.add(jlEspaco2, layout);

          layout.gridy = 4;
          jpPanel3.add(jlSenha, layout);

          layout.gridy = 5;
          jpPanel3.add(passwordField, layout);

          layout.gridy = 6;
          jpPanel3.add(jlEspaco3, layout);

     }

     private void painel4() {

          jpPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 11, 7));
          jpPanel4.setBackground(new Color(0, 0, 0, 0));

          JLabel jlDEspaco = new JLabel("");
          jlDEspaco.setForeground(Color.white);
          jlDEspaco.setFont(new Font("Arial", 0, 10));

          jlEsqueci = new JLabel("Esqueci minha senha");
          jlEsqueci.setFont(new Font("Arial", 1, 11));
          jlEsqueci.setCursor(new Cursor(Cursor.HAND_CURSOR));

          jpPanel4.add(jlDEspaco, 0);
          jpPanel4.add(jcbSenha, 1);
          jpPanel4.add(jlEsqueci, 2);

     }

     private void painel5() {

          jpPanel5 = new JPanel();
          FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 9, 30);
          jpPanel5.setLayout(flowLayout);
          jpPanel5.setBackground(new Color(0, 0, 0, 0));

          jlCadastrar = new JLabel(new ImageIcon("src/main/java/Images/botao-cadastrar-usuario.png"));
          jlCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlCadastrar.addMouseListener(this);

          jlAcessar = new JLabel(new ImageIcon("src/main/java/Images/botao-acessar-online.png"));
          jlAcessar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlAcessar.addMouseListener(this);

          JLabel jlDEspaco1 = new JLabel("");
          jlDEspaco1.setForeground(Color.white);
          jlDEspaco1.setFont(new Font("Arial", 0, 2));

          jpPanel5.add(jlDEspaco1, 0);
          jpPanel5.add(jlCadastrar, 1);
          jpPanel5.add(jlAcessar, 2);

     }

     private void painel6() {

          jpPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
          jpPanel6.setBackground(new Color(0, 0, 0, 0));

          jlAcessarOffline = new JLabel(new ImageIcon("src/main/java/Images/botao-acessar-offline.png"));
          jlAcessarOffline.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlAcessarOffline.addMouseListener(this);

          jpPanel6.add(jlAcessarOffline, 0);

     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlVoltar) {

               Tela.visor.dispose();
               Runtime.getRuntime().exit(0);
          }
          if (e.getSource() == jlEsqueci) {

               // colocar o e-mail e enviar o token
          }

          if (e.getSource() == jlAcessar) {
               String password = new String(passwordField.getPassword());
               String email = jtfEmail.getText();
               String password_cript = Criptografia.senha(password);
               Connection con = Conexao.getConnection();
                    String str = "SELECT email,senha,nome FROM usuarios WHERE email = '" + email + "' AND senha = '"+ password_cript+ "'";
                    try {
                         PreparedStatement pstmt = con.prepareStatement(str);
                         ResultSet rs = pstmt.executeQuery();

                         if (rs.next()){
                              Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("senha"), rs.getString("email"));
                              new TelaMenu(cliente);
                         }
                         else{
                              // fail message
                         }
                         con.close();
                    } catch (SQLException ex) {

                    }
               // conferir os dados e entrar
          }

          if (e.getSource() == jlCadastrar) {

               new TelaCadastroUsuario();
          }

          if (e.getSource() == jlAcessarOffline) {
               Object object = null;
               try {
                    object = Stream.load("src/main/java/files/clientInfos.sav");
               } catch (Exception exception) {
                    
               }
               Cliente guest = Cliente.class.cast(object);
               if(guest == null){
                    guest = new Cliente("guest");
               }
               new TelaMenu(guest);
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
     }

     @Override
     public void mouseEntered(MouseEvent e) {
          if (e.getSource() == jlEsqueci) {

               jlEsqueci.setFocusable(false);
          }

          if (e.getSource() == jcbSenha) {

               jcbSenha.setFocusable(false);
          }

     }

     @Override
     public void mouseExited(MouseEvent e) {

     }
}
