package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import Moldes.JDialogPane;
import Obj.*;

public class TelaMenu implements MouseListener {

     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;
     private JPanel jpPanel4;

     private JLabel jlAcoes;
     private JLabel jlMenu;

     private JMenuItem jmItemSair;
     private JMenuItem jmItemLogoff;

     private JTable tabela;

     private Cliente cliente;

     public TelaMenu(Cliente cliente) {
          this.cliente = cliente;
          inicializa(cliente);
     }

     private void inicializa(Cliente cliente) {

          jpPlano = new JPanel(new GridBagLayout());
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 0, 0, 0);

          painel1();

          painel2();

          painel3(cliente);

          painel4();

          layout.gridy = 0;
          jpPlano.add(jpPanel1, layout);

          layout.gridy = 1;
          jpPlano.add(jpPanel2, layout);

          layout.gridy = 2;
          jpPlano.add(jpPanel3, layout);

          layout.gridy = 3;
          jpPlano.add(jpPanel4, layout);

          new TelaFundo(jpPlano);

     }

     private void painel1() {

          jpPanel1 = new JPanel(new GridBagLayout());
          jpPanel1.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(73, 30, 0, 155);

          jlMenu = new JLabel(new ImageIcon("src/main/java/Images/menu.png"));
          jlMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlMenu.addMouseListener(this);

          JMenuBar jmbUsuario = new JMenuBar();
          JMenu jmUsuario = new JMenu();

          jmUsuario.setIcon(new ImageIcon("src/main/java/Images/usuario.png"));
          jmbUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jmbUsuario.setBackground(Color.white);

          jmItemLogoff = new JMenuItem();
          jmItemLogoff.setText("LogOff");
          jmItemLogoff.setBackground(Color.white);
          jmItemLogoff.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jmItemLogoff.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    try {
                         if (cliente.getOnline()) {

                         } else {
                              Stream.save(cliente, "src/main/java/files/clientInfos.sav");
                         }
                    } catch (Exception exception) {

                    }
                    new TelaLogin();
               }
          });

          jmItemSair = new JMenuItem();
          jmItemSair.setText("Sair");
          jmItemSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jmItemSair.setBackground(Color.white);
          jmItemSair.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    Tela.visor.dispose();
                    try {
                         Stream.save(cliente, "src/main/java/files/clientInfos.sav");
                    } catch (Exception exception) {

                    }
                    Runtime.getRuntime().exit(0);
               }
          });

          jmUsuario.add(jmItemLogoff);
          jmUsuario.add(jmItemSair);

          jmbUsuario.add(jmUsuario);

          layout.gridx = 0;
          jpPanel1.add(jlMenu, layout);

          layout.gridx = 1;
          jpPanel1.add(jmbUsuario, layout);

     }

     private void painel2() {

          jpPanel2 = new JPanel(new GridBagLayout());
          jpPanel2.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(40, 30, 0, 0);

          JLabel jlAuto = new JLabel(" Auto CheckUp");
          jlAuto.setForeground(Color.black);
          jlAuto.setFont(new Font("Arial", 1, 34));

          JLabel jlMCarros = new JLabel("           Meus Carros");
          jlMCarros.setForeground(Color.black);
          jlMCarros.setFont(new Font("Arial", 0, 23));

          layout.gridy = 0;
          layout.gridx = 0;
          jpPanel2.add(jlAuto, layout);

          layout.gridy = 1;
          layout.gridx = 0;
          jpPanel2.add(jlMCarros, layout);

     }

     private void painel3(Cliente cliente) {

          jpPanel3 = new JPanel(new GridBagLayout());
          jpPanel3.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(15, 33, 0, 0);

          DefaultTableModel tableModel = new DefaultTableModel(0, 1) {
               @Override
               public boolean isCellEditable(int row, int column) {
                    return false;
               }
          };

          tabela = new JTable(tableModel);
          Font fonte = tabela.getFont()
                    .deriveFont(15f);
          tabela.setFont(fonte);
          tabela.setRowHeight(tabela.getRowHeight() + 10 + 10);

          tabela.setTableHeader(null);

          DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
          cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          tabela.setDefaultRenderer(Object.class, cellRenderer);

          JScrollPane scrollPane = new JScrollPane(tabela);
          scrollPane.setPreferredSize(new Dimension(277, 244));


          
          if (cliente.getOnline()) {

          } else {
               if (cliente.getVeiculos() != null) {
                    for (Veiculo veiculo : cliente.getVeiculos()) {
                         Object[] linha = veiculo.toObjectArray();
                         tableModel.addRow(linha);
                         tableModel.fireTableDataChanged();
                    }
               }
          }

          JLabel jlCarros = new JLabel(
                    "               Nenhum carro cadastrado");
          jlCarros.setForeground(Color.black);
          jlCarros.setFont(new Font("Arial", 0, 14));

          if (cliente.getVeiculos().size() != 0)
               jlCarros.setText(cliente.getVeiculos().size() + " carros cadastrados");
          else
               jlCarros.setText("Nenhum carro cadastrados");

          layout.gridy = 0;
          jpPanel3.add(scrollPane, layout);

          layout.gridy = 1;
          jpPanel3.add(jlCarros, layout);
          tabela.repaint();
          Tela.visor.revalidate();
          Tela.visor.pack();
     }

     private void painel4() {

          jpPanel4 = new JPanel(new GridBagLayout());
          jpPanel4.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(30, 111, 0, 0);

          jlAcoes = new JLabel(new ImageIcon("src/main/java/Images/botaoAcoes.png"));
          jlAcoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlAcoes.addMouseListener(this);

          layout.gridy = 0;
          jpPanel4.add(jlAcoes, layout);

     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlAcoes) {
               new TelaCadastroCarro(cliente);
          }
          if(e.getSource() == jlMenu){
               int linha = tabela.getSelectedRow();
               if(linha != -1){
                    Veiculo selecionado = cliente.getVeiculos().get(linha);
                    new JDialogPane(jpPlano, "Opcoes", cliente, selecionado);
               }
               new TelaMenu(cliente);
          }
     }

     @Override
     public void mousePressed(MouseEvent e) {
          if (e.getSource() == jlAcoes) {
               // faz nada
          }
     }

     @Override
     public void mouseReleased(MouseEvent e) {
          if (e.getSource() == jlAcoes) {
               // faz nada
          }
     }

     @Override
     public void mouseEntered(MouseEvent e) {
          if (e.getSource() == jlMenu) {
               // faz nada
          }
     }

     @Override
     public void mouseExited(MouseEvent e) {
          if (e.getSource() == jlAcoes) {
               // faz nada
          }
     }

}
