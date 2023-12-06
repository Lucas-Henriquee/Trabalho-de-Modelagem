import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Checking.CheckUserData;

public class CheckUserDataTest {
    @Test
    void testCheckName() {
        Assertions.assertEquals(true, CheckUserData.checkName("Breno Costa"));
        Assertions.assertEquals(false, CheckUserData.checkName("breno"));
        Assertions.assertEquals(false, CheckUserData.checkName("BrenoCosta"));
        Assertions.assertEquals(true, CheckUserData.checkName("Breno da Silva"));
    }

    @Test
    void testCheckEmail() {
        Assertions.assertEquals(false, CheckUserData.checkEmail("breno"));
        Assertions.assertEquals(true, CheckUserData.checkEmail("breno_2010@gmail.com"));
        Assertions.assertEquals(true, CheckUserData.checkEmail("breno-montanha@gmail.com"));
        Assertions.assertEquals(true, CheckUserData.checkEmail("breno.montanha@estudante.ufjf.br"));
    }
}
