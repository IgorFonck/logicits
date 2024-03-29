/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author igorfonseca
 */
public class AtividadeDAO {
    
    /**
      * Adiciona uma atividade ao BD.
      * @param atividade a atividade a ser gravada no BD
      * @throws SQLException 
      */
     public void adicionar(Atividade atividade) throws SQLException {
        String sql = "INSERT INTO atividade (premissas,conclusao) VALUES (?,?)";
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setString(1, atividade.getPremissas());
            stmt.setString(2, atividade.getConclusao());
            if (!stmt.execute()) { //executa o INSERT
                System.out.println("Adicionou o atividade ao banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em adicionar! Erro detectado: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao adicionar atividade ao Banco de Dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
     
   /**
     * Altera um registro de Atividade no BD.
     * @param atividade a atividade a ser alterada no BD
     * @throws SQLException 
     */
    public void alterar(Atividade atividade) throws SQLException {
        String sql = "UPDATE atividade SET premissas=?,conclusao=? WHERE cod_atividade=?";

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setString(1, atividade.getPremissas());
            stmt.setString(2, atividade.getConclusao());
            stmt.setInt(3, atividade.getCod());
            if (!stmt.execute()) { 
                //executa o UPDATE
                System.out.println("Alterou a atividade (" + atividade.getCod()+ ") no banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em alterar! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Apaga um registro de Atividade do BD.
     * @param atividade a atividade a ser deletada
     * @throws SQLException 
     */
    public void excluir(Atividade atividade) throws SQLException {
        String sql = "DELETE FROM atividade WHERE cod_atividade = " + atividade.getCod();

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            if (stmt.executeUpdate() == 1) { 
                //executa o DELETE
                System.out.println("Exluiu a atividade do banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em excluir! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Retorna todas as atividades cadastradas.
     * @return <code>List<Atividade></code> a lista de todos os objetos Atividade
     * @throws SQLException 
     */
    public List<Atividade> listarPorConceito(int codConceito) throws SQLException {
        String sql = "SELECT atividade.*, solucao.dificuldade FROM atividade, complexidade, solucao "
                + "WHERE atividade.cod_atividade = complexidade.fk_atividade_cod_atividade "
                + "AND complexidade.fk_conceito_cod_conceito = ? "
                + "AND atividade.cod_atividade = solucao.fk_atividade_cod_atividade "
                + "ORDER BY solucao.dificuldade";
        List<Atividade> lista = new ArrayList<>();

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, codConceito);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {   //move o cursor para a próxima linha do ResultSet
                Atividade atividade = new Atividade();
                atividade.setCod(rset.getInt("cod_atividade"));
                atividade.setPremissas(rset.getString("premissas"));
                atividade.setConclusao(rset.getString("conclusao"));
                lista.add(atividade);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em listar! Erro detectado: " + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Retorna todas as atividades cadastradas.
     * @return <code>List<Atividade></code> a lista de todos os objetos Atividade
     * @throws SQLException 
     */
    public List<Atividade> listar() throws SQLException {
        String sql = "SELECT * FROM atividade ORDER BY cod_atividade";
        List<Atividade> lista = new ArrayList<>();

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {   //move o cursor para a próxima linha do ResultSet
                Atividade atividade = new Atividade();
                atividade.setCod(rset.getInt("cod_atividade"));
                atividade.setPremissas(rset.getString("premissas"));
                atividade.setConclusao(rset.getString("conclusao"));
                lista.add(atividade);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em listar! Erro detectado: " + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Retorna uma Atividade de acordo com o ID pesquisado.
     * @param id o ID a ser pesquisado
     * @return Atividade
     */
    public Atividade consultar(Integer id) {
        String sql = "SELECT * FROM atividade WHERE cod_atividade = ?";
        Atividade atividade = new Atividade();
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {
                atividade.setCod(rset.getInt("cod_atividade"));
                atividade.setPremissas(rset.getString("premissas"));
                atividade.setConclusao(rset.getString("conclusao"));
                return atividade;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            System.out.println("SQLException em consultar! Erro detectado: " + ex.getMessage());
        }
        return null;
    }
    
    /**
     * Retorna uma Atividade de acordo com o ID pesquisado.
     * @param idAtiv
     * @return Atividade
     */
    public Object[] getConceitos(Integer idAtiv) {
        String sql = "SELECT * FROM complexidade WHERE fk_atividade_cod_atividade = ?";
        List<Object> conceitos = new ArrayList<>();
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, idAtiv);
            ResultSet rset = stmt.executeQuery();
            
            while (rset.next()) {
                Object obj = rset.getInt("fk_conceito_cod_conceito");
                conceitos.add(obj);
            }
            return conceitos.toArray();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            System.out.println("SQLException em consultar! Erro detectado: " + ex.getMessage());
        }
        return null;
    }
    
}
