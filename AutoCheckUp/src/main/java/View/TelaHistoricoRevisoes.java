package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;

import Obj.Cliente;
import Obj.Servico;
import Obj.Veiculo;

public class TelaHistoricoRevisoes implements MouseListener {
     private JPanel jpPlano;
     private JPanel jpPanel1;
     private JPanel jpPanel2;
     private JPanel jpPanel3;
     private JPanel jpPanel4;
     private JPanel jpPanel5;
     private JPanel jpPanel6;
     private JPanel jpPanel7;

     private JLabel jlVoltar;
     private JLabel jlExportar;
     private JLabel jlCompartilhar;

     private Cliente cliente;

     public TelaHistoricoRevisoes(Cliente cliente, Veiculo veiculo) {
          this.cliente = cliente;
          inicializa(cliente, veiculo);
     }

     private void inicializa(Cliente cliente, Veiculo veiculo) {

          jpPlano = new JPanel(new GridBagLayout());
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(0, 0, 0, 0);

          painel1();

          painel2();

          painel3();

          painel4();

          painel5();

          painel6(veiculo);

          painel7();

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

          JLabel jlHistorico = new JLabel("Histórico de Revisões");
          jlHistorico.setForeground(Color.black);
          jlHistorico.setFont(new Font("Arial", 0, 20));

          layout.gridy = 0;
          jpPanel2.add(jlHistorico, layout);

     }

     private void painel3() {

          jpPanel3 = new JPanel(new GridBagLayout());
          jpPanel3.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(8, 30, 0, 0);

          JLabel jlEspaco = new JLabel("aaaaaaaaaaaaaaaaaaa");
          jlEspaco.setForeground(new Color(0, 0, 0, 0));
          jlEspaco.setFont(new Font("Arial", 0, 14));

          JLabel jlDNome = new JLabel("Nome do veículo");
          jlDNome.setForeground(Color.black);
          jlDNome.setFont(new Font("Arial", 1, 11));

          JTextField jtfNome = new JTextField();
          jtfNome.setForeground(Color.BLACK);
          jtfNome.setFont(new Font("Arial", 0, 15));
          jtfNome.setPreferredSize(new Dimension(277, 32));

          JTextField jtfEspaco = new JTextField();
          jtfEspaco.setForeground(Color.black);
          jtfEspaco.setFont(new Font("Arial", 0, 15));
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

          jpPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 8));
          jpPanel4.setBackground(new Color(0, 0, 0, 0));

          JLabel jlDAno = new JLabel("      Km atual");
          jlDAno.setForeground(Color.black);
          jlDAno.setFont(new Font("Arial", 1, 11));

          JLabel jlDEspaco = new JLabel("");
          jlDEspaco.setForeground(Color.white);
          jlDEspaco.setFont(new Font("Arial", 0, 11));

          JLabel jlDKm = new JLabel("               Placa");
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

          JTextField jtfKm = new JTextField();
          jtfKm.setForeground(Color.black);
          jtfKm.setFont(new Font("Arial", 0, 15));
          jtfKm.setPreferredSize(new Dimension(120, 32));

          JTextField jtfPlaca = new JTextField();
          jtfPlaca.setForeground(Color.black);
          jtfPlaca.setFont(new Font("Arial", 0, 15));
          jtfPlaca.setPreferredSize(new Dimension(125, 32));

          layout.gridx = 0;
          jpPanel5.add(jtfKm, layout);

          layout.gridx = 1;
          jpPanel5.add(jtfPlaca, layout);

     }

     private void painel6(Veiculo veiculo) {

          jpPanel6 = new JPanel(new GridBagLayout());
          jpPanel6.setBackground(new Color(0, 0, 0, 0));
          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.WEST;
          layout.insets = new Insets(8, 30, 15, 0);

          String[] colunas = { "Data", "Km", "Intervalo(mês)", "Intervalo(km)" };

          // ArrayList<Object[]> dados =

          DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
               @Override
               public boolean isCellEditable(int row, int column) {
                    return false;
               }
          };

          JTable tabela = new JTable(tableModel);
          Font fonte = tabela.getFont().deriveFont(14f);
          tabela.setFont(fonte);
          tabela.setRowHeight(tabela.getRowHeight() + 10 + 10);

          TableColumnModel columnModel = tabela.getColumnModel();

          TableColumn coluna1 = columnModel.getColumn(0);
          coluna1.setPreferredWidth(45);

          TableColumn coluna2 = columnModel.getColumn(1);
          coluna2.setPreferredWidth(45);

          TableColumn coluna3 = columnModel.getColumn(2);
          coluna3.setPreferredWidth(98);

          TableColumn coluna4 = columnModel.getColumn(3);
          coluna4.setPreferredWidth(89);

          JTableHeader cabecalho = tabela.getTableHeader();
          cabecalho.setFont(new Font("Arial", 1, 11));

          DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
          cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          tabela.setDefaultRenderer(Object.class, cellRenderer);

          JScrollPane scrollPane = new JScrollPane(tabela);
          scrollPane.setPreferredSize(new java.awt.Dimension(277, 244));

          if (veiculo != null) {
               if (veiculo.getServicos() != null) {
                    for (Servico servico : veiculo.getServicos()) {
                         Object[] linha = servico.toObjectArray();
                         tableModel.addRow(linha);
                    }
               }
          }

          layout.gridy = 0;
          jpPanel6.add(scrollPane, layout);

     }

     private void painel7() {

          jpPanel7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 14));
          jpPanel7.setBackground(new Color(0, 0, 0, 0));

          jlExportar = new JLabel(new ImageIcon("src/main/java/Images/botao-exportarPDF.png"));
          jlExportar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlExportar.addMouseListener(this);

          jlCompartilhar = new JLabel(new ImageIcon("src/main/java/Images/botao-compartilhar.png"));
          jlCompartilhar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jlCompartilhar.addMouseListener(this);

          JLabel jlDEspaco = new JLabel("");
          jlDEspaco.setForeground(Color.white);
          jlDEspaco.setFont(new Font("Arial", 0, 2));

          jpPanel7.add(jlDEspaco, 0);

          jpPanel7.add(jlExportar, 1);

          jpPanel7.add(jlCompartilhar, 2);

     }

     @Override
     public void mouseClicked(MouseEvent e) {
          if (e.getSource() == jlVoltar) {
               new TelaMenu(cliente);
          }

          if (e.getSource() == jlExportar) {
               // exportar um pdf
          }

          if (e.getSource() == jlCompartilhar) {
               // compartilhar pdf por e-mail
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
