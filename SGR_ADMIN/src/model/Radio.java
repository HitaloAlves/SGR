package model;

import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Radio {

    private int idRadio;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String modulacao;
    private double frequencia;
    private String siteRadio;
    private int cep;
    private String complemento;
    private String cnpj;

    public List<ObjetoRadio> listasRadios() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoRadio> radioObj = new ArrayList<>();

        try {
                stmt = con.prepareStatement("SELECT * FROM Radios R LEFT JOIN RadiosBloqueados RB ON R.id = RB.Radio_id");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoRadio radio = new ObjetoRadio();

                radio.setId(rs.getInt("id"));
                radio.setNome(rs.getString("nome"));
                radio.setTelefone(rs.getString("telefone"));
                radio.setEmail(rs.getString("email"));
                radio.setSenha(rs.getString("senha"));
                radio.setModulacao(rs.getString("modulacao"));
                radio.setFrequencia(rs.getDouble("frequencia"));
                radio.setSiteRadio(rs.getString("site"));
                radio.setCep(rs.getInt("cep"));
                radio.setComplemento(rs.getString("complemento"));
                radio.setCnpj(rs.getString("cnpj"));
                
                
                if(rs.getInt("Radio_id") == rs.getInt("id")){
                    radio.setRadioBloqueada(true);
                }else {
                    radio.setRadioBloqueada(false);
                }

                radioObj.add(radio);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return radioObj;

    }

    public List<ObjetoRadio> searchRadio(String search) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoRadio> radioObj = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Radios R LEFT JOIN RadiosBloqueados RB ON R.id = RB.Radio_id WHERE R.nome LIKE ?");
            stmt.setString(1, "%" + search + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoRadio radio = new ObjetoRadio();

                radio.setId(rs.getInt("id"));
                radio.setNome(rs.getString("nome"));
                radio.setTelefone(rs.getString("telefone"));
                radio.setEmail(rs.getString("email"));
                radio.setSenha(rs.getString("senha"));
                radio.setModulacao(rs.getString("modulacao"));
                radio.setFrequencia(rs.getDouble("frequencia"));
                radio.setSiteRadio(rs.getString("site"));
                radio.setCep(rs.getInt("cep"));
                radio.setComplemento(rs.getString("complemento"));
                radio.setCnpj(rs.getString("cnpj"));
                
                if(rs.getInt("Radio_id") == rs.getInt("id")){
                    radio.setRadioBloqueada(true);
                }else {
                    radio.setRadioBloqueada(false);
                }

                radioObj.add(radio);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return radioObj;
    }

    private void alterarRadio() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Radios SET nome = ? , telefone = ?, email = ?, modulacao = ?, frequencia = ?, site = ?, cep = ?, complemento = ?, cnpj = ?, senha = ? WHERE id = ?");
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);
            stmt.setString(4, modulacao);
            stmt.setDouble(5, frequencia);
            stmt.setString(6, siteRadio);
            stmt.setInt(7, cep);
            stmt.setString(8, complemento);
            stmt.setString(9, cnpj);
            stmt.setString(10, senha);
            stmt.setInt(11, idRadio);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void getAlterarRadio() {
        this.alterarRadio();
    }

    private boolean criarRadio() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement("INSERT INTO Radios(nome, telefone, email, modulacao, frequencia, site, cep, complemento, cnpj, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);
            stmt.setString(4, modulacao);
            stmt.setDouble(5, frequencia);
            stmt.setString(6, siteRadio);
            stmt.setInt(7, cep);
            stmt.setString(8, complemento);
            stmt.setString(9, cnpj);
            stmt.setString(10, senha);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Radio Criado com Sucesso");
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return check;

    }

    public boolean getCriarRadio() {
        return criarRadio();
    }

    private void bloquearRadio() {        
        
        if(!this.verifRadioBlock()){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("INSERT INTO RadiosBloqueados(Radio_id) VALUES(?)");
                stmt.setInt(1, this.idRadio);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Rádio bloqueado com Sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível bloquear Rádio");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Bloquear Rádio" + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Rádio já Bloqueda");
        }
        

    }
    
    private boolean verifRadioBlock(){
         boolean check = false;
         
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;


        try {
            stmt = con.prepareStatement("SELECT * FROM RadiosBloqueados WHERE Radio_id=?");
            stmt.setInt(1, this.idRadio);

            rs = stmt.executeQuery();

            while (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
         
         return check;
    }
   
    public void getBloquearRadio() {
        this.bloquearRadio();
    }
    
    private void desbloquearRadio() {
        
        if(this.verifRadioBlock()){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement("DELETE FROM RadiosBloqueados WHERE Radio_id = ?");
                stmt.setInt(1, this.idRadio);

                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Rádio desbloqueado com Sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível desbloquear Rádio");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro Desbloqquear Rádio" + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }            
        } else {
            JOptionPane.showMessageDialog(null, "Rádio não está Bloqueda");
        }       
        
    }
    
    public void getDesbloquearRadio() {
        this.desbloquearRadio();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getModulacao() {
        return modulacao;
    }

    public void setModulacao(String modulacao) {
        this.modulacao = modulacao;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public String getSiteRadio() {
        return siteRadio;
    }

    public void setSiteRadio(String siteRadio) {
        this.siteRadio = siteRadio;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setIdRadio(int idRadio) {
        this.idRadio = idRadio;
    }

}
