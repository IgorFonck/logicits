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
public class SolucaoDAO {
    
    /**
     * Retorna todas as solucaos cadastradas.
     * @param codAtividade
     * @return <code>List\<Solucao\></code> a lista de todos os objetos Solucao
     * @throws SQLException 
     */
    public List<Solucao> listarPorAtividade(int codAtividade) throws SQLException {
        String sql = "SELECT * FROM solucao WHERE fk_atividade_cod_atividade = ?";
        List<Solucao> lista = new ArrayList<>();
        
        try (PreparedStatement stmt = ConexaoDAO.getPreparedStatement(sql)) {
            stmt.setInt(1, codAtividade);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {   //move o cursor para a próxima linha do ResultSet
                Solucao solucao = new Solucao();
                solucao.setCod_solucao(rset.getInt("cod_solucao"));
                solucao.setAtividade((new AtividadeDAO()).consultar(rset.getInt("fk_atividade_cod_atividade")));
                solucao.setDificuldade(rset.getInt("dificuldade"));
                solucao.setSequencia(rset.getString("sequencia"));
                lista.add(solucao);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException em listar! Erro detectado: " + ex.getMessage());
        }
        return lista;
    }
    
}
