package View;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;

import Checking.CheckVehicleData;
import Obj.Cliente;
import Obj.Veiculo;

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

     private Cliente cliente;

     private JTextField jtfNome;
     private JTextField jtfAno;
     private JTextField jtfKm;
     private JFormattedTextField jFormattedTextData;
     private JTextField jtfP;
     private JTextArea jtaOBS;

     public TelaCadastroCarro(Cliente cliente) {
          this.cliente = cliente;
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

          JLabel jlLogin = new JLabel("Cadastro do veículo");
          jlLogin.setForeground(Color.black);
          jlLogin.setFont(new Font("Arial", 0, 20));

          JLabel jlEntre = new JLabel(" Entre com seus dados do seu veículo");
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
          jlEspaco.setFont(new Font("Arial", 0, 20));

          JLabel jlNome = new JLabel("Digite o nome*");
          jlNome.setForeground(Color.black);
          jlNome.setFont(new Font("Arial", 1, 11));

          jtfNome = new JTextField("Nome do veículo");
          jtfNome.setForeground(Color.GRAY);
          jtfNome.setFont(new Font("Arial", 0, 15));
          jtfNome.setPreferredSize(new Dimension(277, 33));
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

          layout.gridy = 0;
          jpPanel3.add(jlEspaco, layout);

          layout.gridy = 1;
          jpPanel3.add(jlNome, layout);

          layout.gridy = 2;
          jpPanel3.add(jtfNome, layout);
     }

     private void painel4() {

          jpPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 27, 8));
          jpPanel4.setBackground(new Color(0, 0, 0, 0));

          JLabel jlDAno = new JLabel(" Digite o ano*");
          jlDAno.setForeground(Color.black);
          jlDAno.setFont(new Font("Arial", 1, 11));

          JLabel jlDEspaco = new JLabel("");
          jlDEspaco.setForeground(Color.white);
          jlDEspaco.setFont(new Font("Arial", 0, 11));

          JLabel jlDKm = new JLabel("           Km atual*");
          jlDKm.setForeground(Color.black);
          jlDKm.setFont(new Font("Arial", 1, 11));

          jpPanel4.add(jlDAno, 0);
          jpPanel4.add(jlDEspaco, 1);
          jpPanel4.add(jlDKm, 2);

     }

     private void painel5() {

          jpPanel5 = new JPanel(new GridBagLayout());
          jpPanel5.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 30, 8, 0);

          jtfAno = new JTextField("Ano do veículo");
          jtfAno.setForeground(Color.GRAY);
          jtfAno.setFont(new Font("Arial", 0, 15));
          jtfAno.setPreferredSize(new Dimension(120, 32));
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

          jtfKm = new JTextField("Km atual");
          jtfKm.setForeground(Color.GRAY);
          jtfKm.setFont(new Font("Arial", 0, 15));
          jtfKm.setPreferredSize(new Dimension(125, 32));
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

          jpPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 18, 8));
          jpPanel6.setBackground(new Color(0, 0, 0, 0));

          JLabel jlDM = new JLabel("   Última manutenção");
          jlDM.setForeground(Color.black);
          jlDM.setFont(new Font("Arial", 1, 11));

          JLabel jlDP = new JLabel("       Digite a placa*");
          jlDP.setForeground(Color.black);
          jlDP.setFont(new Font("Arial", 1, 11));

          jpPanel6.add(jlDM, 0);
          jpPanel6.add(jlDP, 1);

     }

     private void painel7() {

          jpPanel7 = new JPanel(new GridBagLayout());
          jpPanel7.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 30, 8, 0);

          MaskFormatter mascaraData = null;

          try {
               mascaraData = new MaskFormatter("##/##/####");
          } catch (ParseException excp) {
               System.err.println("Erro na formatação: " + excp.getMessage());
               System.exit(-1);
          }

          jFormattedTextData = new JFormattedTextField(mascaraData);

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

          jtfP = new JTextField("Placa");
          jtfP.setForeground(Color.GRAY);
          jtfP.setFont(new Font("Arial", 0, 15));
          jtfP.setPreferredSize(new Dimension(125, 32));
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
          jpPanel7.add(jFormattedTextData, layout);

          layout.gridx = 1;
          jpPanel7.add(jtfP, layout);

     }

     private void painel8() {

          jpPanel8 = new JPanel(new GridBagLayout());
          jpPanel8.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(8, 30, 0, 0);

          JLabel jlOBS = new JLabel("Digite uma observação");
          jlOBS.setForeground(Color.black);
          jlOBS.setFont(new Font("Arial", 1, 11));

          jtaOBS = new JTextArea("OBS:");
          jtaOBS.setForeground(Color.GRAY);
          jtaOBS.setBorder(BorderFactory.createLineBorder(Color.GRAY));
          jtaOBS.setFont(new Font("Arial", 0, 15));
          jtaOBS.setPreferredSize(new Dimension(277, 122));
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

          layout.gridy = 0;
          jpPanel8.add(jlOBS, layout);

          layout.gridy = 1;
          jpPanel8.add(jtaOBS, layout);

          layout.gridy = 2;
          jpPanel8.add(jtfEspaco, layout);

     }

     private void painel9() {

          jpPanel9 = new JPanel(new GridBagLayout());
          jpPanel9.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(15, 98, 0, 0);

          jlCadastrarCarro = new JLabel(new ImageIcon("src/main/java/Images/botao-cadastrar-carro.png"));
          jlCadastrarCarro.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlCadastrarCarro.addMouseListener(this);

          layout.gridy = 0;
          jpPanel9.add(jlCadastrarCarro, layout);

     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               new TelaMenu(cliente);
          }

          if (e.getSource() == jlCadastrarCarro) {
               String nome = jtfNome.getText();
               String ano = jtfAno.getText();
               String km = jtfKm.getText();
               String data = jFormattedTextData.getText(); 
               String placa = jtfP.getText();
               String observacao = jtaOBS.getText();
               if(CheckVehicleData.CheckKm(km) && CheckVehicleData.CheckAno(ano) && CheckVehicleData.CheckManutencao(data, Integer.parseInt(ano)) && CheckVehicleData.CheckPlaca(placa));
                    Veiculo veiculo = new Veiculo(cliente, placa, nome, Integer.parseInt(ano), Integer.parseInt(km), observacao);
                    if(data != null){
                         veiculo.addAtualizacao(data);
                    }
                    if(cliente.getOnline()){
                         veiculo.save_in_db();
                    }
               new TelaMenu(cliente);
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