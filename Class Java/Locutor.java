package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author leonardo
 */
public class Locutor extends Pessoa{
    
    private String senha;
    
    private void criarLocutor(Locutor l){
        
        Connection con = ConnectionFactory.getConnection();//Abre a conexão
        PreparedStatement stmt = null;// Faz a preparação do comando que será repassado para o BD
        
        try {
            stmt = con.prepareStatement("INSERT INTO Locutores (nome, telefone, email, cpf, sexo, senha) VALUES (?,?,?,?,?,?)"); // Comando repassado para o BD
            stmt.setString(1,l.getNome());
            stmt.setString(2,l.getTelefone());
            stmt.setString(3,l.getEmail());
            stmt.setString(4,l.getCpf());
            stmt.setString(5,l.getSexo());
            stmt.setString(6,l.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Locutor Cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro - Os dados não foram salvos ");//Exeção, se ocorrer alguma falha...
        }finally{
            ConnectionFactory.closeConnection(con, stmt);//fecha a conexão
        }
    }
        
    
    public List<Locutor> consultarLocutor(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Locutor> locutores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Locutores");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Locutor locutor= new Locutor();
                
                locutor.setId(rs.getInt("id"));
                locutor.setNome(rs.getString("nome"));
                locutor.setTelefone(rs.getString("telefone"));
                locutor.setEmail(rs.getString("email"));
                locutor.setCpf(rs.getString("cpf"));
                locutor.setSexo(rs.getString("sexo"));
                locutores.add(locutor);
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A consulta falhou ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        
        return locutores;
        
     }
    
    public List<Locutor> consultaFiltradaLocutor(String desc){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Locutor> locutores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Locutores WHERE nome  LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Locutor locutor= new Locutor();
                
                locutor.setId(rs.getInt("id"));
                locutor.setNome(rs.getString("nome"));
                locutor.setTelefone(rs.getString("telefone"));
                locutor.setEmail(rs.getString("email"));
                locutor.setCpf(rs.getString("cpf"));
                locutor.setSexo(rs.getString("sexo"));
                locutores.add(locutor);
                
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A consulta falhou ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        
        return locutores;
        
    }
    
    private void alterarLocutor(Locutor l){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Locutores SET nome = ? ,telefone = ? ,email = ? ,cpf = ? ,sexo = ? , senha = ? WHERE id = ?");
            stmt.setString(1,l.getNome());
            stmt.setString(2,l.getTelefone());
            stmt.setString(3,l.getEmail());
            stmt.setString(4,l.getCpf());
            stmt.setString(5,l.getSexo());
            stmt.setInt(6, l.getId());
            stmt.setString(7,l.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro - não foram feitas as alterações ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

                 
}