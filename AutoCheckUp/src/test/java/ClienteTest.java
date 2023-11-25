import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Obj.Cliente;
import Obj.Veiculo;

public class ClienteTest {

    Cliente cliente = new Cliente("Fulano");
    
    @Test
    public void testCliente(){
        Assertions.assertEquals("Fulano", cliente.getNome());
        Assertions.assertEquals(3, cliente.getDiasIntervaloNotificacao());

        cliente.addVeiculo(new Veiculo());
        Assertions.assertEquals(1, cliente.getVeiculos().size());
    }
}
