
package model;


import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Convidado extends Pessoa{
    
    private ProgramaRadio programa;
    
    private String obs; // Observações
    
    private void criarConvidado(Convidado c){
        
        Connection con = ConnectionFactory.getConnection();//Abre a conexão
        PreparedStatement stmt = null;// Faz a preparação do comando que será repassado para o BD
        
        try {
            stmt = con.prepareStatement("INSERT INTO Convidados (nome, telefone, email, cpf, sexo, obs) VALUES (?,?,?,?,?,?)"); // Comando repassado para o BD
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getTelefone());
            stmt.setString(3,c.getEmail());
            stmt.setString(4,c.getCpf());
            stmt.setString(5,c.getSexo());
            stmt.setString(6,c.getObs());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Convidado Cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro - Os dados não foram salvos ");//Exeção, se ocorrer alguma falha...
        }finally{
            ConnectionFactory.closeConnection(con, stmt);//fecha a conexão
        }
    }
    
    public List<Convidado> consultarConvidado(){
        
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Convidado> convidados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Convidados");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Convidado convidado= new Convidado();
                
                convidado.setId(rs.getInt("id"));
                convidado.setNome(rs.getString("nome"));
                convidado.setTelefone(rs.getString("telefone"));
                convidado.setEmail(rs.getString("email"));
                convidado.setCpf(rs.getString("cpf"));
                convidado.setSexo(rs.getString("sexo"));
                convidado.setObs(rs.getString("obs"));
                convidados.add(convidado);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A consulta falhou ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        
        return convidados;
        
    }
    
    public List<Convidado> consultaFiltradaConvidado(String desc){
        
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Convidado> convidados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Convidados WHERE nome  LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Convidado convidado= new Convidado();
                
                convidado.setId(rs.getInt("id"));
                convidado.setNome(rs.getString("nome"));
                convidado.setTelefone(rs.getString("telefone"));
                convidado.setEmail(rs.getString("email"));
                convidado.setCpf(rs.getString("cpf"));
                convidado.setSexo(rs.getString("sexo"));
                convidado.setObs(rs.getString("obs"));
                convidados.add(convidado);
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"A consulta falhou ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        
        return convidados;
        
    }
    
    private void alterarConvidado(Convidado c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Convidados SET nome = ? ,telefone = ? ,email = ? ,cpf = ? ,sexo = ? ,obs = ? WHERE id = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getTelefone());
            stmt.setString(3,c.getEmail());
            stmt.setString(4,c.getCpf());
            stmt.setString(5,c.getSexo());
            stmt.setString(6,c.getObs());
            stmt.setInt(7, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro - não foram feitas as alterações ");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
        
            
}