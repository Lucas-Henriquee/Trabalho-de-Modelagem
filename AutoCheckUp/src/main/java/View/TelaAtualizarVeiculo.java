package View;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import Obj.Cliente;

public class TelaAtualizarVeiculo implements MouseListener {

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
     private JPanel jpPanel10;
     private JPanel jpPanel11;

     private JLabel jlVoltar;
     private JLabel jlAtualizarKm;
     private JLabel jlAtualizarPlaca;
     private JLabel jlCriarCadastrar;

     private Cliente cliente;

     public TelaAtualizarVeiculo(Cliente cliente) {
          this.cliente = cliente;
          inicializa();
     }

     private void inicializa() {

          jpPlano = new JPanel(new GridBagLayout());
          jpPlano.setBackground(new Color(0, 0, 0, 0));
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

          painel10();

          painel11();

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

          layout.gridy = 9;
          jpPlano.add(jpPanel10, layout);

          layout.gridy = 10;
          jpPlano.add(jpPanel11, layout);

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
          layout.insets = new Insets(8, 30, 0, 180);

          JLabel jlLogin = new JLabel("Atualizar veículo");
          jlLogin.setForeground(Color.black);
          jlLogin.setFont(new Font("Arial", 0, 20));

          JLabel jlEntre = new JLabel("Atualize as informações do seu veículo");
          jlEntre.setForeground(Color.black);
          jlEntre.setFont(new Font("Arial", 1, 11));

          JLabel jlEspaco = new JLabel("aaaaaaaa");
          jlEspaco.setForeground(Color.white);
          jlEspaco.setFont(new Font("Arial", 1, 8));

          JLabel jlKm = new JLabel("Km atual");
          jlKm.setForeground(Color.black);
          jlKm.setFont(new Font("Arial", 1, 11));

          layout.gridy = 0;
          jpPanel2.add(jlLogin, layout);

          layout.gridy = 1;
          jpPanel2.add(jlEntre, layout);

          layout.gridy = 2;
          jpPanel2.add(jlEspaco, layout);

          layout.gridy = 3;
          jpPanel2.add(jlKm, layout);

     }

     private void painel3() {

          jpPanel3 = new JPanel(new GridBagLayout());
          jpPanel3.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(4, 30, 0, 0);

          JTextField jtfKm = new JTextField("Novo Km");
          jtfKm.setForeground(Color.GRAY);
          jtfKm.setFont(new Font("Arial", 0, 15));
          jtfKm.setPreferredSize(new Dimension(155, 32));
          jtfKm.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfKm.getText().equals("Novo Km")) {
                         jtfKm.setText("");
                         jtfKm.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfKm.getText().isEmpty()) {
                         jtfKm.setText("Novo Km");
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

          jlAtualizarKm = new JLabel(new ImageIcon("src/main/java/Images/botao-atualizar.png"));
          jlAtualizarKm.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlAtualizarKm.addMouseListener(this);

          layout.gridx = 0;
          jpPanel3.add(jtfKm, layout);

          layout.gridx = 1;
          jpPanel3.add(jlAtualizarKm, layout);

     }

     private void painel4() {

          jpPanel4 = new JPanel(new GridBagLayout());
          jpPanel4.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(5, 30, 0, 0);

          JLabel jlPlaca = new JLabel("Placa atual");
          jlPlaca.setForeground(Color.black);
          jlPlaca.setFont(new Font("Arial", 1, 11));

          layout.gridy = 0;
          jpPanel4.add(jlPlaca, layout);

     }

     private void painel5() {

          jpPanel5 = new JPanel(new GridBagLayout());
          jpPanel5.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(4, 30, 0, 0);

          JTextField jtfPlaca = new JTextField("Nova placa");
          jtfPlaca.setForeground(Color.GRAY);
          jtfPlaca.setFont(new Font("Arial", 0, 15));
          jtfPlaca.setPreferredSize(new Dimension(155, 32));
          jtfPlaca.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfPlaca.getText().equals("Nova placa")) {
                         jtfPlaca.setText("");
                         jtfPlaca.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfPlaca.getText().isEmpty()) {
                         jtfPlaca.setText("Nova placa");
                         jtfPlaca.setForeground(Color.GRAY);
                    }
               }
          });
          jtfPlaca.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfPlaca.getText().isEmpty()) {
                         jtfPlaca.setForeground(Color.GRAY);
                    } else {
                         jtfPlaca.setForeground(Color.BLACK);
                    }
               }
          });

          jlAtualizarPlaca = new JLabel(new ImageIcon("src/main/java/Images/botao-atualizar.png"));
          jlAtualizarPlaca.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlAtualizarPlaca.addMouseListener(this);

          layout.gridx = 0;
          jpPanel5.add(jtfPlaca, layout);

          layout.gridx = 1;
          jpPanel5.add(jlAtualizarPlaca, layout);
     }

     private void painel6() {

          jpPanel6 = new JPanel(new GridBagLayout());
          jpPanel6.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(13, 30, 2, 0);

          JLabel jlRevisao = new JLabel("        Cadastre um novo serviço");
          jlRevisao.setForeground(Color.black);
          jlRevisao.setFont(new Font("Arial", 1, 14));

          JLabel jlTipo = new JLabel("Tipo de manutenção*");
          jlTipo.setForeground(Color.black);
          jlTipo.setFont(new Font("Arial", 1, 11));

          layout.gridy = 0;
          jpPanel6.add(jlRevisao, layout);

          layout.gridy = 1;
          jpPanel6.add(jlTipo, layout);

     }

     private void painel7() {

          jpPanel7 = new JPanel(new GridBagLayout());
          jpPanel7.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(4, 30, 0, 0);

          JTextField jtfTipo = new JTextField("Nome do veículo");
          jtfTipo.setForeground(Color.GRAY);
          jtfTipo.setFont(new Font("Arial", 0, 15));
          jtfTipo.setPreferredSize(new Dimension(277, 33));
          jtfTipo.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfTipo.getText().equals("Nome do veículo")) {
                         jtfTipo.setText("");
                         jtfTipo.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfTipo.getText().isEmpty()) {
                         jtfTipo.setText("Nome do veículo");
                         jtfTipo.setForeground(Color.GRAY);
                    }
               }
          });
          jtfTipo.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfTipo.getText().isEmpty()) {
                         jtfTipo.setForeground(Color.GRAY);
                    } else {
                         jtfTipo.setForeground(Color.BLACK);
                    }
               }
          });

          layout.gridy = 0;
          jpPanel7.add(jtfTipo, layout);

     }

     private void painel8() {

          jpPanel8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 7));
          jpPanel8.setBackground(new Color(0, 0, 0, 0));

          JLabel jlAno = new JLabel("       Data em que foi feita*");
          jlAno.setForeground(Color.black);
          jlAno.setFont(new Font("Arial", 1, 11));

          JLabel jlDEspaco = new JLabel("");
          jlDEspaco.setForeground(Color.white);
          jlDEspaco.setFont(new Font("Arial", 0, 11));

          JLabel jlDKm = new JLabel("Km em que foi feita*");
          jlDKm.setForeground(Color.black);
          jlDKm.setFont(new Font("Arial", 1, 11));

          jpPanel8.add(jlAno, 0);
          jpPanel8.add(jlDEspaco, 1);
          jpPanel8.add(jlDKm, 2);
     }

     private void painel9() {

          jpPanel9 = new JPanel(new GridBagLayout());
          jpPanel9.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 30, 8, 0);

          MaskFormatter mascaraData = null;

          try {
               mascaraData = new MaskFormatter("##/##/##");
          } catch (ParseException excp) {
               System.err.println("Erro na formatação: " + excp.getMessage());
               System.exit(-1);
          }

          JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);

          jFormattedTextData.setText("DD/MM/AAAA");
          jFormattedTextData.setForeground(Color.GRAY);
          jFormattedTextData.setFont(new Font("Arial", 0, 15));
          jFormattedTextData.setPreferredSize(new Dimension(120, 32));
          jFormattedTextData.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jFormattedTextData.getText().equals("DD/MM/AA")) {
                         jFormattedTextData.setText("DD/MM/AA");
                         jFormattedTextData.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(FocusEvent e) {
                    if (jFormattedTextData.getText().isEmpty()) {
                         jFormattedTextData.setText("DD/MM/AA");
                         jFormattedTextData.setForeground(Color.GRAY);
                    }
               }
          });
          jFormattedTextData.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jFormattedTextData.getText().isEmpty()) {
                         jFormattedTextData.setForeground(Color.GRAY);
                    } else {

                         jFormattedTextData.setForeground(Color.BLACK);
                    }
               }
          });

          JTextField jtfKm = new JTextField("Km");
          jtfKm.setForeground(Color.GRAY);
          jtfKm.setFont(new Font("Arial", 0, 15));
          jtfKm.setPreferredSize(new Dimension(125, 32));
          jtfKm.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfKm.getText().equals("Km")) {
                         jtfKm.setText("");
                         jtfKm.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfKm.getText().isEmpty()) {
                         jtfKm.setText("Km");
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
          jpPanel9.add(jFormattedTextData, layout);

          layout.gridx = 1;
          jpPanel9.add(jtfKm, layout);
     }

     private void painel10() {

          jpPanel10 = new JPanel(new GridBagLayout());
          jpPanel10.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 30, 7, 0);

          JLabel jlOBS = new JLabel("Digite uma observação");
          jlOBS.setForeground(Color.black);
          jlOBS.setFont(new Font("Arial", 1, 11));

          JTextArea jtaOBS = new JTextArea("OBS:");
          jtaOBS.setForeground(Color.GRAY);
          jtaOBS.setBorder(BorderFactory.createLineBorder(Color.GRAY));
          jtaOBS.setFont(new Font("Arial", 0, 15));
          jtaOBS.setPreferredSize(new Dimension(277, 115));
          jtaOBS.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtaOBS.getText().equals("OBS:")) {
                         jtaOBS.setText("");
                         jtaOBS.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtaOBS.getText().isEmpty()) {
                         jtaOBS.setText("OBS:");
                         jtaOBS.setForeground(Color.GRAY);
                    }
               }
          });
          jtaOBS.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtaOBS.getText().isEmpty()) {
                         jtaOBS.setForeground(Color.GRAY);
                    } else {
                         jtaOBS.setForeground(Color.BLACK);
                    }
               }
          });

          JTextField jtfEspaco = new JTextField();
          jtfEspaco.setForeground(Color.black);
          jtfEspaco.setFont(new Font("Arial", 0, 19));
          jtfEspaco.setPreferredSize(new Dimension(0, 0));

          jlCriarCadastrar = new JLabel(new ImageIcon("src/main/java/Images/botao-criar-cadastrar.png"));
          jlCriarCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlCriarCadastrar.addMouseListener(this);

          layout.gridy = 0;
          jpPanel10.add(jlOBS, layout);

          layout.gridy = 1;
          jpPanel10.add(jtaOBS, layout);

          layout.gridy = 2;
          jpPanel10.add(jtfEspaco, layout);

          layout.gridy = 3;
          jpPanel10.add(jlCriarCadastrar, layout);

     }

     private void painel11() {

          jpPanel11 = new JPanel(new GridBagLayout());
          jpPanel11.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(13, 30, 2, 0);

          JLabel jlRevisao = new JLabel("  Cadastre uma nova revisão");
          jlRevisao.setForeground(Color.black);
          jlRevisao.setFont(new Font("Arial", 1, 14));

          JLabel jlTipo = new JLabel("Tipo de manutenção*");
          jlTipo.setForeground(Color.black);
          jlTipo.setFont(new Font("Arial", 1, 11));

          layout.gridy = 0;
          jpPanel11.add(jlRevisao, layout);

          layout.gridy = 1;
          jpPanel11.add(jlTipo, layout);
     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlVoltar) {

               new TelaMenu(cliente);
          }
          if (e.getSource() == jlAtualizarKm) {

               // verifica a km com a anterior e
               // exibe mensagem de km alterado
          }
          if (e.getSource() == jlAtualizarPlaca) {

               // verifica placa
               // exibir uma mensagens de confirmação
          }
          if (e.getSource() == jlCriarCadastrar) {

               // conferir os dados e criar revisao
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
