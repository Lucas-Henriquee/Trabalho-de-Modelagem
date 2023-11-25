package Conect;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class EmailTest {
    @Test
    void testEnvia() {
        try{
            Email.envia();
        } catch(RuntimeException e){
            fail(e.getMessage());
        }
    }
}
