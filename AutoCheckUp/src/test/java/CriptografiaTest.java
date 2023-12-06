import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Conect.Criptografia;

public class CriptografiaTest {
    @Test
    void testGenerate() {
        long t = Criptografia.email("teste@gmail.com");
        Assertions.assertEquals(637296, t);
    }

    @Test
    void testSenha() {
        String t = Criptografia.senha("senha123");
        Assertions.assertEquals("55A5E9E78207B4DF8699D60886FA070079463547B095D1A05BC719BB4E6CD251", t);
    }
}
