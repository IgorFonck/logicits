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
    
    private static final String banco = "jdbc:h2:./h2/bdlogicits";
    private static final String usuario = "sa";
    private static final String senha = "";
    private static Connection conn = null;

    public ConexaoDAO() {

    }

    /**
     * Retorna a conexão.
     * Cria a conexão, caso ela ainda não exista. Então, retorna a conexão.
     * @return a conexão
     */
    public static Connection getConexao() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(banco, usuario, senha);
                System.out.println("Conexão com o BD realizada com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Erro na conexão: " + ex.getMessage());
            }
        }
        return conn;
    }

    /**
     * Cria um PreparedStatement a partir do SQL informado.
     * @param sql a query
     * @return PreparedStatement
     */
    public static PreparedStatement getPreparedStatement(String sql) {
        if (conn == null) {
            conn = getConexao();
        }
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        return null;
    }
    
}
