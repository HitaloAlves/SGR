package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Locutor extends Pessoa{
    
    private Date dataNascimento;
    
    private boolean criarLocutor(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement("INSERT INTO Locutor(nome, telefone, email, cpf, sexo, dataNasc, senha, Radio_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getTelefone());
            stmt.setString(3, this.getEmail());
            stmt.setString(4, this.getCpf());
            stmt.setString(5, this.getSexo());
            stmt.setDate(6, (java.sql.Date) dataNascimento);
            stmt.setString(7, this.getSenha());
            stmt.setInt(8, Sessao.getIdUser());

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Locutor adicionado com Sucesso");
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Locutor" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return check;
        
    }
    
    public boolean getCriarLocutor(){
        return this.criarLocutor();
    }
    
    public void consultarLocutor(){
        
    }
    
    private void excluirLocutor(){
        
    }
    
    private void alterarLocutor(){
        
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
       
    
    
            
}
