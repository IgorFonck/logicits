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
public class AvaliacaoDAO {
    
    /**
      * Adiciona uma avaliacao ao BD.
      * @param avaliacao a avaliacao a ser gravada no BD
      * @throws SQLException 
      */
     public void adicionar(Avaliacao avaliacao) throws SQLException {
        String sql = "INSERT INTO avaliacao (nota,fg_concluido,fk_estudante_cod_estudante,fk_atividade_cod_atividade) VALUES (?,true,1,?)";
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setDouble(1, avaliacao.getNota());
            stmt.setInt(2, avaliacao.getAtividade().getCod());
            if (!stmt.execute()) { //executa o INSERT
                System.out.println("Adicionou o avaliacao ao banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em adicionar! Erro detectado: " + ex.getMessage());
        }
    }
     
   /**
     * Altera um registro de Avaliacao no BD.
     * @param avaliacao a avaliacao a ser alterada no BD
     * @throws SQLException 
     */
    public void alterar(Avaliacao avaliacao) throws SQLException {
        String sql = "UPDATE avaliacao SET nota=? WHERE cod_avaliacao=?";

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setDouble(1, avaliacao.getNota());
            stmt.setInt(2, avaliacao.getCod());
            if (!stmt.execute()) { 
                //executa o UPDATE
                System.out.println("Alterou a avaliacao (" + avaliacao.getCod()+ ") no banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em alterar! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Apaga um registro de Avaliacao do BD.
     * @param avaliacao a avaliacao a ser deletada
     * @throws SQLException 
     */
    public void excluir(Avaliacao avaliacao) throws SQLException {
        String sql = "DELETE FROM avaliacao WHERE cod_avaliacao = " + avaliacao.getCod();

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            if (stmt.executeUpdate() == 1) { 
                //executa o DELETE
                System.out.println("Exluiu a avaliacao do banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em excluir! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Retorna todas as avaliacaos cadastradas.
     * @return <code>List\<Avaliacao\></code> a lista de todos os objetos Avaliacao
     * @throws SQLException 
     */
    public List<Avaliacao> listar() throws SQLException {
        String sql = "SELECT * FROM avaliacao ORDER BY fk_atividade_cod_atividade";
        List<Avaliacao> lista = new ArrayList<>();
        

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {   //move o cursor para a próxima linha do ResultSet
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setCod(rset.getInt("cod_avaliacao"));
                avaliacao.setNota(rset.getDouble("nota"));
                avaliacao.setConcluido(rset.getBoolean("fg_concluido"));
                avaliacao.setAtividade((new AtividadeDAO()).consultar(rset.getInt("fk_atividade_cod_atividade")));
                avaliacao.setPerfil((new PerfilDAO()).consultar(rset.getInt("fk_estudante_cod_estudante")));
                lista.add(avaliacao);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em listar! Erro detectado: " + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Retorna uma Avaliacao de acordo com o ID pesquisado.
     * @param id o ID a ser pesquisado
     * @return Avaliacao
     */
    public Avaliacao consultar(Integer id) {
        String sql = "SELECT * FROM avaliacao WHERE cod_avaliacao = ?";
        Avaliacao avaliacao = new Avaliacao();
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {
                avaliacao.setCod(rset.getInt("cod_avaliacao"));
                avaliacao.setNota(rset.getDouble("nota"));
                avaliacao.setConcluido(rset.getBoolean("fg_concluido"));
                avaliacao.setAtividade((new AtividadeDAO()).consultar(rset.getInt("fk_atividade_cod_atividade")));
                avaliacao.setPerfil((new PerfilDAO()).consultar(rset.getInt("fk_estudante_cod_estudante")));
                return avaliacao;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            System.out.println("SQLException em consultar! Erro detectado: " + ex.getMessage());
        }
        return null;
    }
    
}
