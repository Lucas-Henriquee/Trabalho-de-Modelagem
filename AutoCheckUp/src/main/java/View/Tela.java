package View;

import java.awt.*;
import javax.swing.*;

public class Tela {

     public static JFrame visor;

     public static final int HEIGHT = 700;
     public static final int WIDTH = 420;

     public Tela() {

          inicializa();
     }

     private void inicializa() {

          visor = new JFrame();
          visor.setSize(WIDTH, HEIGHT);
          visor.setLocationRelativeTo(null);
          visor.setUndecorated(true);
          visor.setOpacity(0.5f);
          visor.setBackground(new Color(0, 0, 0, 0));

          new TelaAtualizarVeiculo();
          //new TelaEntrada();

     }
}
