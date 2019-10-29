/*
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igorfonseca
 */
public class ConexaoDAO {
    
    private static final String BANCO = "jdbc:h2:./h2/bdlogicits";
    private static final String USUARIO = "sa";
    private static final String SENHA = "";
    private static Connection conn = null;

    public ConexaoDAO() {

    }

    /**
     * Retorna a conexão.
     * Cria a conexão, caso ela ainda não exista. Então, retorna a conexão.
     * @return a conexão
     * @throws java.sql.SQLException
     */
    public static Connection getConexao() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            System.out.println("Conexão com o BD realizada com sucesso!");
        }
        return conn;
    }

    /**
     * Cria um PreparedStatement a partir do SQL informado.
     * @param sql a query
     * @return PreparedStatement
     * @throws java.sql.SQLException
     */
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        if (conn == null) {
            conn = getConexao();
        }
        return conn.prepareStatement(sql);
    }
    
}
