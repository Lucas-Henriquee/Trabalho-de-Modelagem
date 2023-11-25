package Conect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CriptografiaTest {
    @Test
    void testGenerate() {
        String t = new Criptografia().generate("teste@gmail.com");
        System.out.println(t);
        Assertions.assertNotNull(t);
    }
}
