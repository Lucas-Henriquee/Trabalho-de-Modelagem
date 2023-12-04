import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Conect.Criptografia;

public class CriptografiaTest {
    @Test
    void testGenerate() {
        String t = Criptografia.generate("teste@gmail.com");
        Assertions.assertNotNull(t);
    }

    @Test
    void testSenha() {
        String t = Criptografia.senha("senha123");
        Assertions.assertNotNull(t);
    }
}
