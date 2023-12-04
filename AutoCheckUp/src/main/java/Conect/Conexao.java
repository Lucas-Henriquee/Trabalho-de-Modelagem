package Conect;

import java.sql.*;
public class Conexao {

    public static Connection getConnection(){
        try {
            String dbName = "autocheckup";
            String userName = "postgres";
            String password = "Te$tE#23*";
            String hostname = "autocheckup.cibyr9kw3zjg.sa-east-1.rds.amazonaws.com";
            String port = "5432";
            String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            Connection con = DriverManager.getConnection(jdbcUrl);
            return con;
            }
            catch (SQLException e) {}
            return null;
    }

}
