import org.junit.jupiter.api.Test;

import Conect.Email;
import Obj.Cliente;

public class EmailTest {

    Cliente a = new Cliente("Breno", "breno.montanha@estudante.ufjf.br", "teste123");
    @Test
    void testEnvia() {
        //Email.envia(a.getNome(), a.getEmail());
    }
}
