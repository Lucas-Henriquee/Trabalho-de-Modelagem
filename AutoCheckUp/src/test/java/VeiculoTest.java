
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Obj.*;

public class VeiculoTest {
    
    Veiculo veiculo = new Veiculo();
    
    @Test
    void testAddKm(){
        veiculo.attKm(20);
        Assertions.assertEquals(20,veiculo.getKm());
    }

    @Test
    void testRevisoes(){
        Revisao rev = new Revisao(0,0);
        veiculo.addRevisao(rev);

        if(veiculo.getRevisoes().indexOf(rev) == -1){
            Assertions.assertTrue(false);
            return;
        }

        veiculo.removeRevisao(rev);
        if(veiculo.getRevisoes().indexOf(rev) != -1){
            Assertions.assertTrue(false);
            return;
        }

         Assertions.assertTrue(true);
    }

    @Test
    void testServicos(){
        Servico serv = new Servico(0,Calendar.getInstance());
        veiculo.addServico(serv);
        if(veiculo.getServicos().indexOf(serv) == -1){
            Assertions.assertTrue(false);
            return;
        }

        veiculo.removeServico(serv);
        if(veiculo.getServicos().indexOf(serv) != -1){
            Assertions.assertTrue(false);
            return;
        }

         Assertions.assertTrue(true);
    }
}
