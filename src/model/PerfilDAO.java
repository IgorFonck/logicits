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
public class PerfilDAO {
    
    /**
      * Adiciona um perfil ao BD.
      * @param perfil o perfil a ser gravado no BD
      * @throws SQLException 
      */
     public void adicionar(Perfil perfil) throws SQLException {
        String sql = "INSERT INTO estudante (nome,idade,genero) VALUES (?,?,?)";
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setString(1, perfil.getNome());
            stmt.setInt(2, perfil.getIdade());
            stmt.setString(3, perfil.getGenero());
            if (!stmt.execute()) { //executa o INSERT
                System.out.println("Adicionou o perfil \""+ perfil.getNome() +"\" ao banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em adicionar! Erro detectado: " + ex.getMessage());
        }
    }
     
   /**
     * Altera um registro de Perfil no BD.
     * @param perfil o perfil a ser alterado no BD
     * @throws SQLException 
     */
    public void alterar(Perfil perfil) throws SQLException {
        String sql = "UPDATE estudante SET nome=?,idade=?,genero=? WHERE cod_estudante=?";

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setString(1, perfil.getNome());
            stmt.setInt(2, perfil.getIdade());
            stmt.setString(3, perfil.getGenero());
            stmt.setInt(4, perfil.getCod_estudante());
            if (!stmt.execute()) { 
                //executa o UPDATE
                System.out.println("Alterou o perfil (" + perfil.getCod_estudante()+ ") \"" + perfil.getNome()+ "\" no banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em alterar! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Apaga um registro de Perfil do BD.
     * @param perfil o perfil a ser deletado
     * @throws SQLException 
     */
    public void excluir(Perfil perfil) throws SQLException {
        String sql = "DELETE FROM estudante WHERE cod_estudante = " + perfil.getCod_estudante();

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            if (stmt.executeUpdate() == 1) { 
                //executa o DELETE
                System.out.println("Exluiu o perfil do banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em excluir! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Retorna todos os perfis cadastradas.
     * @param id
     * @return <code>List<Perfil></code> a lista de todos os objetos Perfil
     * @throws SQLException 
     */
    public List<Perfil> listar(Integer id) throws SQLException {
        String sql = "SELECT * FROM estudante ORDER BY nome_perfil";
        List<Perfil> lista = new ArrayList<>();

        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {   //move o cursor para a próxima linha do ResultSet
                Perfil perfil = new Perfil();
                perfil.setCod_estudante(rset.getInt("cod_estudante"));
                perfil.setNome(rset.getString("nome"));
                perfil.setIdade(rset.getInt("idade"));
                perfil.setGenero(rset.getString("genero"));
                lista.add(perfil);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em listar! Erro detectado: " + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * Retorna um Perfil de acordo com o ID pesquisado.
     * @param id o ID a ser pesquisado
     * @return Perfil
     */
    public Perfil consultar(Integer id) {
        String sql = "SELECT * FROM estudante WHERE cod_estudante = ?";
        Perfil perfil = new Perfil();
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {
                perfil.setCod_estudante(rset.getInt("cod_estudante"));
                perfil.setNome(rset.getString("nome"));
                perfil.setIdade(rset.getInt("idade"));
                perfil.setGenero(rset.getString("genero"));
                return perfil;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            System.out.println("SQLException em consultar! Erro detectado: " + ex.getMessage());
        }
        return null;
    }
    
}
