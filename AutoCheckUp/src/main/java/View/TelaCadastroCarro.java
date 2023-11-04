package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TelaCadastroCarro implements MouseListener {

     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;
     private JPanel jpPanel4;
     private JPanel jpPanel5;
     private JPanel jpPanel6;
     private JPanel jpPanel7;
     private JPanel jpPanel8;
     private JPanel jpPanel9;

     private JLabel jlVoltar;
     private JLabel jlCadastrarCarro;

     public TelaCadastroCarro() {

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

          painel7();

          painel8();

          painel9();

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

          layout.gridy = 6;
          jpPlano.add(jpPanel7, layout);

          layout.gridy = 7;
          jpPlano.add(jpPanel8, layout);

          layout.gridy = 8;
          jpPlano.add(jpPanel9, layout);

          new TelaFundo(jpPlano);

     }

     private void painel1() {

          jpPanel1 = new JPanel(new GridBagLayout());
          jpPanel1.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(90, 45, 15, 180);

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
          layout.insets = new Insets(3, 41, 0, 180);

          JLabel jlCadastro = new JLabel("Cadastro do veículo");
          jlCadastro.setForeground(Color.black);
          jlCadastro.setFont(new Font("Arial", 0, 30));

          JLabel jlEntreDados = new JLabel("Entre com os dados do seu veículo");
          jlEntreDados.setForeground(Color.black);
          jlEntreDados.setFont(new Font("Arial", 0, 16));

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
          layout.insets = new Insets(8, 40, 0, 0);

          JLabel jlEspaco = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco.setForeground(new Color(0, 0, 0, 0));
          jlEspaco.setFont(new Font("Arial", 0, 17));

          JLabel jlDNome = new JLabel("Digite o nome*");
          jlDNome.setForeground(Color.black);
          jlDNome.setFont(new Font("Arial", 1, 13));

          JTextField jtfNome = new JTextField("Nome do veículo");
          jtfNome.setForeground(Color.GRAY);
          jtfNome.setFont(new Font("Arial", 0, 19));
          jtfNome.setPreferredSize(new Dimension(340, 40));
          jtfNome.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfNome.getText().equals("Nome do veículo")) {
                         jtfNome.setText("");
                         jtfNome.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfNome.getText().isEmpty()) {
                         jtfNome.setText("Nome do veículo");
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

          JTextField jtfEspaco = new JTextField();
          jtfEspaco.setForeground(Color.black);
          jtfEspaco.setFont(new Font("Arial", 0, 19));
          jtfEspaco.setPreferredSize(new Dimension(0, 0));

          layout.gridy = 0;
          jpPanel3.add(jlEspaco, layout);

          layout.gridy = 1;
          jpPanel3.add(jlDNome, layout);

          layout.gridy = 2;
          jpPanel3.add(jtfNome, layout);

          layout.gridy = 3;
          jpPanel3.add(jtfEspaco, layout);

     }

     private void painel4() {

          jpPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 8));
          jpPanel4.setBackground(new Color(0, 0, 0, 0));

          JLabel jlDAno = new JLabel("Digite o ano*");
          jlDAno.setForeground(Color.black);
          jlDAno.setFont(new Font("Arial", 1, 13));

          JLabel jlDEspaco = new JLabel("");
          jlDEspaco.setForeground(Color.white);
          jlDEspaco.setFont(new Font("Arial", 0, 13));

          JLabel jlDKm = new JLabel("            Digite a quilometragem*");
          jlDKm.setForeground(Color.black);
          jlDKm.setFont(new Font("Arial", 1, 13));

          jpPanel4.add(jlDAno, 0);
          jpPanel4.add(jlDEspaco, 1);
          jpPanel4.add(jlDKm, 2);

     }

     private void painel5() {

          jpPanel5 = new JPanel(new GridBagLayout());
          jpPanel5.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 40, 8, 0);

          JTextField jtfAno = new JTextField("Ano do veículo");
          jtfAno.setForeground(Color.GRAY);
          jtfAno.setFont(new Font("Arial", 0, 19));
          jtfAno.setPreferredSize(new Dimension(150, 40));
          jtfAno.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfAno.getText().equals("Ano do veículo")) {
                         jtfAno.setText("");
                         jtfAno.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfAno.getText().isEmpty()) {
                         jtfAno.setText("Ano do veículo");
                         jtfAno.setForeground(Color.GRAY);
                    }
               }
          });
          jtfAno.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfAno.getText().isEmpty()) {
                         jtfAno.setForeground(Color.GRAY);
                    } else {
                         jtfAno.setForeground(Color.BLACK);
                    }
               }
          });

          JTextField jtfKm = new JTextField("Km atual");
          jtfKm.setForeground(Color.GRAY);
          jtfKm.setFont(new Font("Arial", 0, 19));
          jtfKm.setPreferredSize(new Dimension(150, 40));
          jtfKm.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfKm.getText().equals("Km atual")) {
                         jtfKm.setText("");
                         jtfKm.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfKm.getText().isEmpty()) {
                         jtfKm.setText("Km atual");
                         jtfKm.setForeground(Color.GRAY);
                    }
               }
          });
          jtfKm.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfKm.getText().isEmpty()) {
                         jtfKm.setForeground(Color.GRAY);
                    } else {
                         jtfKm.setForeground(Color.BLACK);
                    }
               }
          });

          layout.gridx = 0;
          jpPanel5.add(jtfAno, layout);

          layout.gridx = 1;
          jpPanel5.add(jtfKm, layout);

     }

     private void painel6() {

          jpPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 8));
          jpPanel6.setBackground(new Color(0, 0, 0, 0));

          JLabel jlDM = new JLabel("       Digite a data da última manutenção");
          jlDM.setForeground(Color.black);
          jlDM.setFont(new Font("Arial", 1, 13));

          JLabel jlDP = new JLabel("Digite a placa*");
          jlDP.setForeground(Color.black);
          jlDP.setFont(new Font("Arial", 1, 13));

          jpPanel6.add(jlDM, 0);
          jpPanel6.add(jlDP, 1);

     }

     private void painel7() {

          jpPanel7 = new JPanel(new GridBagLayout());
          jpPanel7.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 40, 8, 0);

          JTextField jtfM = new JTextField("DD/MM/AA");
          jtfM.setForeground(Color.GRAY);
          jtfM.setFont(new Font("Arial", 0, 19));
          jtfM.setPreferredSize(new Dimension(150, 40));
          jtfM.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfM.getText().equals("DD/MM/AA")) {
                         jtfM.setText("");
                         jtfM.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfM.getText().isEmpty()) {
                         jtfM.setText("DD/MM/AA");
                         jtfM.setForeground(Color.GRAY);
                    }
               }
          });
          jtfM.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfM.getText().isEmpty()) {
                         jtfM.setForeground(Color.GRAY);
                    } else {
                         jtfM.setForeground(Color.BLACK);
                    }
               }
          });

          JTextField jtfP = new JTextField("Placa");
          jtfP.setForeground(Color.GRAY);
          jtfP.setFont(new Font("Arial", 0, 19));
          jtfP.setPreferredSize(new Dimension(150, 40));
          jtfP.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfP.getText().equals("Placa")) {
                         jtfP.setText("");
                         jtfP.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfP.getText().isEmpty()) {
                         jtfP.setText("Placa");
                         jtfP.setForeground(Color.GRAY);
                    }
               }
          });
          jtfP.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfP.getText().isEmpty()) {
                         jtfP.setForeground(Color.GRAY);
                    } else {
                         jtfP.setForeground(Color.BLACK);
                    }
               }
          });

          layout.gridx = 0;
          jpPanel7.add(jtfM, layout);

          layout.gridx = 1;
          jpPanel7.add(jtfP, layout);

     }

     private void painel8() {

          jpPanel8 = new JPanel(new GridBagLayout());
          jpPanel8.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(8, 40, 0, 0);

          JLabel jlDNome = new JLabel("Digite uma observação");
          jlDNome.setForeground(Color.black);
          jlDNome.setFont(new Font("Arial", 1, 13));

          JTextField jtfNome = new JTextField("OBS:");
          jtfNome.setForeground(Color.GRAY);
          jtfNome.setFont(new Font("Arial", 0, 19));
          jtfNome.setPreferredSize(new Dimension(340, 150));
          jtfNome.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfNome.getText().equals("OBS:")) {
                         jtfNome.setText("");
                         jtfNome.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfNome.getText().isEmpty()) {
                         jtfNome.setText("OBS:");
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

          JTextField jtfEspaco = new JTextField();
          jtfEspaco.setForeground(Color.black);
          jtfEspaco.setFont(new Font("Arial", 0, 19));
          jtfEspaco.setPreferredSize(new Dimension(0, 0));

          layout.gridy = 0;
          jpPanel8.add(jlDNome, layout);

          layout.gridy = 1;
          jpPanel8.add(jtfNome, layout);

          layout.gridy = 2;
          jpPanel8.add(jtfEspaco, layout);

     }

     private void painel9() {

          jpPanel9 = new JPanel(new GridBagLayout());
          jpPanel9.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(15, 120, 0, 0);

          jlCadastrarCarro = new JLabel(new ImageIcon("src/main/java/Images/botao-cadastrar-carro.png"));
          jlCadastrarCarro.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlCadastrarCarro.addMouseListener(this);

          layout.gridy = 0;
          jpPanel9.add(jlCadastrarCarro, layout);

     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               new TelaMenu();
          }

          if (e.getSource() == jlCadastrarCarro) {

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
