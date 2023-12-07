package Moldes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import View.Tela;
import View.TelaAtualizarVeiculo;
import View.TelaHistoricoRevisoes;
import View.TelaHistoricoServicos;
import View.TelaLogin;

public class JDialogPane implements MouseListener {

     private JPanel jp;
     private JPanel jpPlano;
     private JPanel jpDialog;
     private JPanel jpEsqueci;
     private JPanel jpToken;
     private JPanel jpError;
     private JPanel jpNovaSenha;
     private JPanel jpConfirmacao;
     private JPanel jpOpcoes;

     private JDialog dialog;

     private JLabel jlVoltar;
     private JLabel jlEnviarEmail;
     private JLabel jlEnviarToken;
     private JLabel jlOK;
     private JLabel jlSalvarSenha;
     private JLabel jlAlterarVeiculo;
     private JLabel jlHistoricoServicos;
     private JLabel jlHistoricoRevisoes;
     private JLabel jlExcluir;

     public JDialogPane(JPanel jp, String tipo) {

          this.jp = jp;
          inicializa(jp, tipo);
     }

     private void inicializa(JPanel jp, String tipo) {

          dialog = new JDialog(Tela.visor, null, true);

          if (tipo != "Error" && tipo != "Confirmacao") {

               dialog.setSize(300, 210);
               Point panelLocation = jp.getLocationOnScreen();
               dialog.setLocation(((panelLocation.x + jp.getWidth() / 2) - dialog.getWidth() / 2 - 30),
                         ((panelLocation.y + jp.getHeight() / 2) - dialog.getHeight() / 2));
               dialog.setUndecorated(true);

               jpDialog = new JPanel();
               jpDialog.setLayout(new FlowLayout(FlowLayout.LEFT));
               jpDialog.setBackground(Color.white);
               Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
               jpDialog.setBorder(border);

               jPanelFundo();
               jpDialog.add(jpPlano);

               switch (tipo) {
                    case "EsqueciSenha":
                         jPanelEsqueci();
                         jpDialog.add(jpEsqueci);
                         break;
                    case "EsperarToken":
                         jPanelToken();
                         jpDialog.add(jpToken);
                         break;
                    case "SenhaNova":
                         jpNovaSenha();
                         jpDialog.add(jpNovaSenha);
                         break;
                    default:
                         jpOpcoes();
                         jpDialog.add(jpOpcoes);
                         break;
               }
          }

          else {

               dialog.setSize(300, 170);
               Point panelLocation = jp.getLocationOnScreen();
               dialog.setLocation(((panelLocation.x + jp.getWidth() / 2) - dialog.getWidth() / 2 - 30),
                         ((panelLocation.y + jp.getHeight() / 2) - dialog.getHeight() / 2));
               dialog.setUndecorated(true);

               jpDialog = new JPanel();
               jpDialog.setLayout(new FlowLayout(FlowLayout.LEFT));
               jpDialog.setBackground(Color.white);

               if (tipo == "Error") {

                    Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
                    jpDialog.setBorder(border);
                    jPanelError();
                    jpDialog.add(jpError);

               } else {
                    Border border1 = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green);
                    jpDialog.setBorder(border1);
                    jPanelConfirmacao();
                    jpDialog.add(jpConfirmacao);
               }
          }

          dialog.add(jpDialog);
          dialog.setVisible(true);

     }

     private void jPanelFundo() {

          jpPlano = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
          jpPlano.setBackground(new Color(0, 0, 0, 0));

          jpPlano.setPreferredSize(new Dimension(50, 40));

          jlVoltar = new JLabel(new ImageIcon("src/main/java/Images/botao-voltar.png"));
          jlVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlVoltar.addMouseListener(this);

          jpPlano.add(jlVoltar);

     }

     private void jPanelEsqueci() {

          jpEsqueci = new JPanel(new GridBagLayout());
          jpEsqueci.setBackground(new Color(0, 0, 0, 0));

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(15, 17, 0, 25);

          JLabel jlEsqueci = new JLabel("Digite seu email para enviar um token");
          jlEsqueci.setForeground(Color.black);
          jlEsqueci.setFont(new Font("Arial", 1, 12));

          JTextField jtfEmail = new JTextField(" ");
          jtfEmail.setForeground(Color.BLACK);
          jtfEmail.setFont(new Font("Arial", 0, 15));
          jtfEmail.setPreferredSize(new Dimension(210, 33));

          jlEnviarEmail = new JLabel(new ImageIcon("src/main/java/Images/botao-enviar.png"));
          jlEnviarEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlEnviarEmail.addMouseListener(this);

          layout.gridy = 0;
          jpEsqueci.add(jlEsqueci, layout);

          layout.gridy = 1;
          jpEsqueci.add(jtfEmail, layout);

          layout.gridy = 2;
          jpEsqueci.add(jlEnviarEmail, layout);

     }

     private void jPanelToken() {

          jpToken = new JPanel(new GridBagLayout());
          jpToken.setBackground(new Color(0, 0, 0, 0));

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(15, 17, 0, 25);

          JLabel jlEsqueci = new JLabel("Digite o token enviado ao seu e-mail");
          jlEsqueci.setForeground(Color.black);
          jlEsqueci.setFont(new Font("Arial", 1, 12));

          JTextField jtfEmail = new JTextField(" ");
          jtfEmail.setForeground(Color.BLACK);
          jtfEmail.setFont(new Font("Arial", 0, 15));
          jtfEmail.setPreferredSize(new Dimension(210, 33));

          jlEnviarToken = new JLabel(new ImageIcon("src/main/java/Images/botao-enviar.png"));
          jlEnviarToken.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlEnviarToken.addMouseListener(this);

          layout.gridy = 0;
          jpToken.add(jlEsqueci, layout);

          layout.gridy = 1;
          jpToken.add(jtfEmail, layout);

          layout.gridy = 2;
          jpToken.add(jlEnviarToken, layout);

     }

     private void jPanelError() {

          jpError = new JPanel(new GridBagLayout());
          jpError.setBackground(new Color(0, 0, 0, 0));

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(15, 15, 0, 0);

          JPanel jpErrorPlano = new JPanel(new GridBagLayout());
          jpErrorPlano.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout1 = new GridBagConstraints();
          layout1.anchor = GridBagConstraints.WEST;
          layout1.insets = new Insets(15, 0, 12, 0);

          JLabel jlError = new JLabel(new ImageIcon("src/main/java/Images/error.png"));

          JLabel jlErrorEncontrado = new JLabel("ERRO ENCONTRADO!");
          jlErrorEncontrado.setForeground(Color.RED);
          jlErrorEncontrado.setFont(new Font("Arial", 1, 15));

          layout1.gridx = 0;
          jpErrorPlano.add(jlError, layout1);

          layout1.gridx = 1;
          jpErrorPlano.add(jlErrorEncontrado, layout1);

          JLabel jlCorrigir = new JLabel("Por favor confira os dados inseridos");
          jlCorrigir.setForeground(Color.black);
          jlCorrigir.setFont(new Font("Arial", 1, 12));

          jlOK = new JLabel(new ImageIcon("src/main/java/Images/botao-ok.png"));
          jlOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlOK.addMouseListener(this);

          layout.gridy = 0;
          jpError.add(jpErrorPlano, layout);

          layout.gridy = 1;
          jpError.add(jlCorrigir, layout);

          layout.gridy = 2;
          jpError.add(jlOK, layout);

     }

     private void jpNovaSenha() {

          jpNovaSenha = new JPanel(new GridBagLayout());
          jpNovaSenha.setBackground(new Color(0, 0, 0, 0));

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(5, 17, 0, 25);

          JLabel jlNovaSenha = new JLabel("Digite uma nova senha para acessar");
          jlNovaSenha.setForeground(Color.black);
          jlNovaSenha.setFont(new Font("Arial", 1, 12));

          JTextField jtfSenha1 = new JTextField("Senha");
          jtfSenha1.setForeground(Color.gray);
          jtfSenha1.setFont(new Font("Arial", 0, 15));
          jtfSenha1.setPreferredSize(new Dimension(210, 33));
          jtfSenha1.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfSenha1.getText().equals("Senha")) {
                         jtfSenha1.setText("");
                         jtfSenha1.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfSenha1.getText().isEmpty()) {
                         jtfSenha1.setText("Senha");
                         jtfSenha1.setForeground(Color.GRAY);
                    }
               }
          });
          jtfSenha1.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfSenha1.getText().isEmpty()) {
                         jtfSenha1.setForeground(Color.GRAY);
                    } else {
                         jtfSenha1.setForeground(Color.BLACK);
                    }
               }
          });

          JLabel jlConfirmacao = new JLabel("Digite novamente para confirmar");
          jlConfirmacao.setForeground(Color.black);
          jlConfirmacao.setFont(new Font("Arial", 1, 12));

          JTextField jtfSenha2 = new JTextField("Senha");
          jtfSenha2.setForeground(Color.gray);
          jtfSenha2.setFont(new Font("Arial", 0, 15));
          jtfSenha2.setPreferredSize(new Dimension(210, 33));
          jtfSenha2.addFocusListener(new FocusListener() {
               @Override
               public void focusGained(FocusEvent e) {
                    if (jtfSenha2.getText().equals("Senha")) {
                         jtfSenha2.setText("");
                         jtfSenha2.setForeground(Color.GRAY);
                    }
               }

               @Override
               public void focusLost(java.awt.event.FocusEvent e) {
                    if (jtfSenha2.getText().isEmpty()) {
                         jtfSenha2.setText("Senha");
                         jtfSenha2.setForeground(Color.GRAY);
                    }
               }
          });
          jtfSenha2.getDocument().addDocumentListener(new DocumentListener() {
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
                    if (jtfSenha2.getText().isEmpty()) {
                         jtfSenha2.setForeground(Color.GRAY);
                    } else {
                         jtfSenha2.setForeground(Color.BLACK);
                    }
               }
          });

          jlSalvarSenha = new JLabel(new ImageIcon("src/main/java/Images/botao-salvar.png"));
          jlSalvarSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlSalvarSenha.addMouseListener(this);

          layout.gridy = 0;
          jpNovaSenha.add(jlNovaSenha, layout);

          layout.gridy = 1;
          jpNovaSenha.add(jtfSenha1, layout);

          layout.gridy = 2;
          jpNovaSenha.add(jlConfirmacao, layout);

          layout.gridy = 3;
          jpNovaSenha.add(jtfSenha2, layout);

          layout.gridy = 4;
          jpNovaSenha.add(jlSalvarSenha, layout);

     }

     private void jPanelConfirmacao() {

          jpConfirmacao = new JPanel(new GridBagLayout());
          jpConfirmacao.setBackground(new Color(0, 0, 0, 0));

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(15, 20, 0, 0);

          JPanel jpConfirmacaoPlano = new JPanel(new GridBagLayout());
          jpConfirmacaoPlano.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout1 = new GridBagConstraints();
          layout1.anchor = GridBagConstraints.WEST;
          layout1.insets = new Insets(15, 15, 12, 0);

          JLabel jlError = new JLabel(new ImageIcon("src/main/java/Images/check.png"));

          JLabel jlErrorEncontrado = new JLabel("Ação realizada!");
          jlErrorEncontrado.setForeground(Color.green);
          jlErrorEncontrado.setFont(new Font("Arial", 1, 15));

          layout1.gridx = 0;
          jpConfirmacaoPlano.add(jlError, layout1);

          layout1.gridx = 1;
          jpConfirmacaoPlano.add(jlErrorEncontrado, layout1);

          JLabel jlAcao = new JLabel("Ação realizada com sucesso");
          jlAcao.setForeground(Color.black);
          jlAcao.setFont(new Font("Arial", 1, 12));

          jlOK = new JLabel(new ImageIcon("src/main/java/Images/botao-ok.png"));
          jlOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlOK.addMouseListener(this);

          layout.gridy = 0;
          jpConfirmacao.add(jpConfirmacaoPlano, layout);

          layout.gridy = 1;
          jpConfirmacao.add(jlAcao, layout);

          layout.gridy = 2;
          jpConfirmacao.add(jlOK, layout);
     }

     private void jpOpcoes() {

          jpOpcoes = new JPanel(new GridBagLayout());
          jpOpcoes.setBackground(new Color(0, 0, 0, 0));

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(15, 17, 0, 25);

          JLabel jlOpcoes = new JLabel("Selecione uma das opcões abaixo");
          jlOpcoes.setForeground(Color.black);
          jlOpcoes.setFont(new Font("Arial", 1, 15));

          JPanel jpOpcoes1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
          jpOpcoes1.setBackground(new Color(0, 0, 0, 0));

          jlAlterarVeiculo = new JLabel("Alterar veículo");
          jlAlterarVeiculo.setForeground(Color.black);
          jlAlterarVeiculo.setFont(new Font("Arial", 1, 12));
          jlAlterarVeiculo.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlAlterarVeiculo.addMouseListener(this);

          jlExcluir = new JLabel("Excluir veículo");
          jlExcluir.setForeground(Color.black);
          jlExcluir.setFont(new Font("Arial", 1, 12));
          jlExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlExcluir.addMouseListener(this);

          jpOpcoes1.add(jlAlterarVeiculo);
          jpOpcoes1.add(jlExcluir);

          JPanel jpOpcoes2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
          jpOpcoes2.setBackground(new Color(0, 0, 0, 0));

          jlHistoricoRevisoes = new JLabel("Histórico de revisões");
          jlHistoricoRevisoes.setForeground(Color.black);
          jlHistoricoRevisoes.setFont(new Font("Arial", 1, 12));
          jlHistoricoRevisoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlHistoricoRevisoes.addMouseListener(this);

          jlHistoricoServicos = new JLabel("Histórico de serviços");
          jlHistoricoServicos.setForeground(Color.black);
          jlHistoricoServicos.setFont(new Font("Arial", 1, 12));
          jlHistoricoServicos.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlHistoricoServicos.addMouseListener(this);

          jpOpcoes2.add(jlHistoricoRevisoes);
          jpOpcoes2.add(jlHistoricoServicos);

          layout.gridy = 0;
          jpOpcoes.add(jlOpcoes, layout);

          layout.gridy = 1;
          jpOpcoes.add(jpOpcoes1, layout);

          layout.gridy = 2;
          jpOpcoes.add(jpOpcoes2, layout);
     }

     @Override
     public void mouseClicked(MouseEvent e) {

          if (e.getSource() == jlVoltar) {

               dialog.dispose();

          }

          if (e.getSource() == jlEnviarEmail) {

               dialog.dispose();
               // pegar o email no jtfEmail
               // enviar o token para o e-mail
               new JDialogPane(jp, "EsperarToken");
          }

          if (e.getSource() == jlEnviarToken) {

               dialog.dispose();
               new JDialogPane(jp, "SenhaNova");
               /*
                * if(token correto){
                * dialog.dispose();
                * new JDialogPane(jp, "NovaSenha");
                * }
                * else{
                * 
                * new JDialogPane(jp, "Error");
                * }
                */
          }

          if (e.getSource() == jlOK) {

               dialog.dispose();
          }

          if (e.getSource() == jlSalvarSenha) {
               // salva a senha no banco de dados
               new TelaLogin();
               dialog.dispose();
          }

          if (e.getSource() == jlAlterarVeiculo) {
               new TelaAtualizarVeiculo(null);
          }

          if (e.getSource() == jlExcluir) {
               // excluir o veiculo
          }

          if (e.getSource() == jlHistoricoRevisoes) {
               new TelaHistoricoRevisoes(null, null);
          }
          if (e.getSource() == jlHistoricoServicos) {
               new TelaHistoricoServicos(null, null);
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
          // faz nada
     }
}
