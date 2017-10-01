
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
public class Responsavel extends Pessoa{
    
     
    private Radio radio;
    private String cargos;
    private String senha;

    
    private void criarResponsavel(Responsavel r){
        
        Connection con = ConnectionFactory.getConnection();//Abre a conexão
        PreparedStatement stmt = null;// Faz a preparação do comando que será repassado para o BD
        
        try {
            stmt = con.prepareStatement("INSERT INTO Convidados (nome, telefone, email, cpf, sexo, cargos, senha) VALUES (?,?,?,?,?,?,?)"); // Comando repassado para o BD
            stmt.setString(1,r.getNome());
            stmt.setString(2,r.getTelefone());
            stmt.setString(3,r.getEmail());
            stmt.setString(4,r.getCpf());
            stmt.setString(5,r.getSexo());
            stmt.setString(6,r.getCargos());
            stmt.setString(7,r.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Responsavel Cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro - Os dados não foram salvos ");//Exeção, se ocorrer alguma falha...
        }finally{
            ConnectionFactory.closeConnection(con, stmt);//fecha a conexão
        }
    }
        
    
    public List<Responsavel> consultarResponsavel(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Responsavel> responsaveis = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Responsaveis");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Responsavel responsavel= new Responsavel();
                
                responsavel.setId(rs.getInt("id"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setTelefone(rs.getString("telefone"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setCpf(rs.getString("cpf"));
                responsavel.setSexo(rs.getString("sexo"));
                responsavel.setCargos(rs.getString("cargos"));
                responsavel.setSenha(rs.getString("senha"));
                responsaveis.add(responsavel);
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A consulta falhou ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        
        return responsaveis;
        
     }
    
    public List<Responsavel> consultaFiltradaResponsavel(String desc){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Responsavel> responsaveis = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Responsaveis WHERE nome  LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Responsavel responsavel= new Responsavel();
                
                responsavel.setId(rs.getInt("id"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setTelefone(rs.getString("telefone"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setCpf(rs.getString("cpf"));
                responsavel.setSexo(rs.getString("sexo"));
                responsavel.setCargos(rs.getString("cargos"));
                
                
                responsaveis.add(responsavel);
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A consulta falhou ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        
        return responsaveis;
        
    }
    
    private void alterarResponsavel(Responsavel r){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Convidados SET nome = ? ,telefone = ? ,email = ? ,cpf = ? ,sexo = ? ,cargos = ? WHERE id = ?");
            stmt.setString(1,r.getNome());
            stmt.setString(2,r.getTelefone());
            stmt.setString(3,r.getEmail());
            stmt.setString(4,r.getCpf());
            stmt.setString(5,r.getSexo());
            stmt.setString(6,r.getCargos());
            stmt.setInt(7, r.getId());
            stmt.setString(8,r.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro - não foram feitas as alterações ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private Radio getRadio() {
        return radio;
    }

    private void setRadio(Radio radio) {
        this.radio = radio;
    }

                
}