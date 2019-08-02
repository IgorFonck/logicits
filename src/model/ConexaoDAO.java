/*
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author igorfonseca
 */
public class ConexaoDAO {
    
    private static final String banco = "jdbc:postgresql://localhost:5432/bdlogicits";
    private static final String driver = "org.postgresql.Driver";
    private static final String usuario = "postgres";
    private static final String senha = "admin";
    private static Connection con = null;

    public ConexaoDAO() {

    }

    /**
     * Retorna a conexão.
     * Cria a conexão, caso ela ainda não exista. Então, retorna a conexão.
     * @return a conexão
     */
    public static Connection getConexao() {
        if (con == null) {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(banco, usuario, senha);
                System.out.println("Conexão com o BD realizada com sucesso!");
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Erro na conexão: " + ex.getMessage());
            }
        }
        return con;
    }

    /**
     * Cria um PreparedStatement a partir do SQL informado.
     * @param sql a query
     * @return PreparedStatement
     */
    public static PreparedStatement getPreparedStatement(String sql) {
        if (con == null) {
            con = getConexao();
        }
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        return null;
    }
    
}
