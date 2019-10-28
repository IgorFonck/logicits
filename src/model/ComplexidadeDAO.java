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

/**
 *
 * @author Igor
 */
public class ComplexidadeDAO {
    
    /**
      * Adiciona uma complexidade ao BD.
      * @param complexidade a complexidade a ser gravada no BD
      * @throws SQLException 
      */
     public void adicionar(Complexidade complexidade) throws SQLException {
        String sql = "INSERT INTO complexidade (fk_conceito_cod_conceito,fk_atividade_cod_atividade,valor) VALUES (?,?,?)";
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, complexidade.getCod_conceito());
            stmt.setInt(2, complexidade.getAtividade().getCod());
            stmt.setInt(3, complexidade.getValor());
            if (!stmt.execute()) { //executa o INSERT
                System.out.println("Adicionou o complexidade ao banco!");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em adicionar! Erro detectado: " + ex.getMessage());
        }
    }
    
    /**
     * Retorna todas as complexidades cadastradas.
     * @param codAtividade
     * @return <code>List\<Complexidade\></code> a lista de todos os objetos Complexidade
     * @throws SQLException 
     */
    public List<Complexidade> listarPorAtividade(int codAtividade) throws SQLException {
        String sql = "SELECT * FROM complexidade WHERE fk_atividade_cod_atividade = ?";
        List<Complexidade> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, codAtividade);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {   //move o cursor para a próxima linha do ResultSet
                Complexidade complexidade = new Complexidade();
                complexidade.setCod_complexidade(rset.getInt("cod_complexidade"));
                complexidade.setValor(rset.getInt("valor"));
                complexidade.setAtividade((new AtividadeDAO()).consultar(rset.getInt("fk_atividade_cod_atividade")));
                complexidade.setCod_conceito(rset.getInt("fk_conceito_cod_conceito"));
                lista.add(complexidade);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em listar! Erro detectado: " + ex.getMessage());
        }
        return lista;
    }
    
}
