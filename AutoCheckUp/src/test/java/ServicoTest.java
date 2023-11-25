import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Obj.Revisao;
import Obj.Servico;

public class ServicoTest {
    
    Servico serv = new Servico(2000, null);

    @Test
    public void testServico(){
        Assertions.assertEquals(2000, serv.getQuilometragem());
    }

    @Test
    public void testAddRevisao(){
        Calendar date = Calendar.getInstance();
        date.set(2022, 6, 2);
        Revisao rev = new Revisao(5000, 6);
        serv.addRevisaoFeita(rev);
        Assertions.assertEquals(2000, rev.getKmUltimaRevisao());
        Assertions.assertEquals(0, date.compareTo(date));
    }
}
