import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Obj.Revisao;

public class RevisaoTest {
    Revisao revisao = new Revisao(5000, 6);

    @Test
    public void testRevisao(){
        Assertions.assertEquals(5000, revisao.getIntervaloKm());
        Assertions.assertEquals(6, revisao.getIntervaloMeses());
    }

    @Test
    public void testAtualiza(){
        revisao.atualiza(6760, Calendar.getInstance());
        Assertions.assertEquals(6760, revisao.getKmUltimaRevisao());
    }

    @Test
    public void testDiffMeses(){

        Calendar data_1 = Calendar.getInstance();
        data_1.set(2020, 6, 13);

        Calendar data_2 = Calendar.getInstance();
        data_2.set(2022, 6, 13);

        int diffMeses = Revisao.calcDiffMeses(data_1, data_2);
        Assertions.assertEquals(24, diffMeses);

        data_1.set(2021, 12,14);
        Assertions.assertEquals(5, Revisao.calcDiffMeses(data_1, data_2));

        data_1.set(2021, 12,13);
        Assertions.assertEquals(6, Revisao.calcDiffMeses(data_1, data_2));
    }
}
