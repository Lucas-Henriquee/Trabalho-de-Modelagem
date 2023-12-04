import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Conect.Conexao;

public class ConexaoTest {

    @Test
    void testGetConnection() {
        Connection c = Conexao.getConnection();
        Assertions.assertNotNull(c);
    }
}
