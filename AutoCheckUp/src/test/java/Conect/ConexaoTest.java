package Conect;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConexaoTest {
    @Test
    void testGetConnection() {
        Connection con = new Conexao().getConnection();
        Assertions.assertNotNull(con);

    }
}
