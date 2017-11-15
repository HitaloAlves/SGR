/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import sessao.Sessao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Admin extends Pessoa {  
    
    
    public Admin(){
        
    }    
    
    public void consultarAdminSessao(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        ObjetoPessoa admin = new ObjetoPessoa();

        try {
            
            stmt = con.prepareStatement("SELECT * FROM Admin WHERE id = ?");
            
            stmt.setInt(1, Sessao.getIdUser());

            rs = stmt.executeQuery();

            while (rs.next()) {

                admin.setNome(rs.getString("nome"));
                admin.setTelefone(rs.getString("telefone"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));
                admin.setCpf(rs.getString("cpf"));
                admin.setSexo(rs.getString("sexo"));
                
                Sessao.setTadosUser(admin);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro pegar dados Admin" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
    }
    
    private void alterarSenhaUserAdmin(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Admin SET senha = ? WHERE id = ?");
            stmt.setString(1, this.getSenha());
            stmt.setInt(2, Sessao.getIdUser());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                Sessao.atualizarDadosUser(); // Atualizar dados Usuário
                JOptionPane.showMessageDialog(null, "Senha Alterada com Sucesso");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Senha" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void getAlterarSenhaUserAdmin() {
        this.alterarSenhaUserAdmin();
    }
   
    public void alterarAdmin() {
        
    }
        
}
