
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Obj.Cliente;
import Obj.Revisao;
import Obj.Stream;
import Obj.Veiculo;

public class StreamTest {

    private final String PATH = "src/main/java/files/testStream.sav";
    private final String PLACA = "ABC-1234";


    @Test
    public void testStream(){
        Cliente cliente = new Cliente("fulano");
        Veiculo veiculo = new Veiculo(cliente, PLACA,"Gol", 1239,122,"");
        veiculo.setPlaca(PLACA);

        Revisao rev = new Revisao(5000, 6);
        rev.setDescricao("Troca de oleo e filtros");

        veiculo.addRevisao(rev);

        try{
            Stream.save(veiculo, PATH);
        }catch(Exception e){
            System.out.println(e.getMessage());
            Assertions.fail();
        }

        try{

            Veiculo load;
            load = (Veiculo)Stream.load(PATH);
            Assertions.assertTrue((load.getPlaca().equals(PLACA)));
            
            Revisao revLoad = load.getRevisoes().get(0);
            Assertions.assertEquals("Troca de oleo e filtros", revLoad.getDescricao());
            Assertions.assertEquals(5000, revLoad.getIntervaloKm());
            Assertions.assertEquals(6, revLoad.getIntervaloMeses());

        }catch(Exception e){
            System.out.println(e.getMessage());
            Assertions.fail();
        }

        Assertions.assertTrue(true);
    }
}
