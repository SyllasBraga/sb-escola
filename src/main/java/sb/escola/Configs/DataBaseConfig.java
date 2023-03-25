package sb.escola.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {

    private final static String USERNAME = "root";
    private final static String SENHA = "12345";
    private final static String URL = "jdbc:mysql://localhost:3306/sb_escola";

    public Connection connectDatase(){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, SENHA);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
