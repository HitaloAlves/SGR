
package model;

import connection.ConnectionFactory;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
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
public class Musica {
    
    private String nome;
    private String estiloMusical;
    private String nomeCantor;
    private String banda;
    private String album;
    private String nomeFileMusica;
    
    
    public List<ObjetoMusica> listarListasMusicas() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoMusica> listaObj = new ArrayList<>();

        try {
            
            String sql = "select M.id, M.nome, M.nomeCantor, M.banda, M.album, M.nomeFileMusica, EM.nome from Musicas M join EstiloMusicais EM on M.EstiloMusicais_id = EM.id where M.Locutores_Radio_id = ?";
            
            stmt = con.prepareStatement(sql);
            
//            stmt.setInt(1, Sessao.getIdUser());
            stmt.setInt(1, Sessao.getIdRadio());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoMusica listaMusica = new ObjetoMusica(); // Objeto Musica                
                
                listaMusica.setIdMusica(rs.getInt("M.id"));
                listaMusica.setNome(rs.getString("M.nome"));
                listaMusica.setNomeCantor(rs.getString("M.nomeCantor"));
                listaMusica.setBanda(rs.getString("M.banda"));
                listaMusica.setAlbum(rs.getString("M.album"));
                listaMusica.setNomeFileMusica(rs.getString("M.nomeFileMusica"));
                listaMusica.setEstiloMusical(rs.getString("EM.nome"));
                                
                listaObj.add(listaMusica);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaObj;

    }
    
    public void criarListaMusica(){
        
    }
    
    public void cadastrarMusica(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("INSERT INTO Musicas(nome, nomeCantor, banda, album, EstiloMusicais_id, nomeFileMusica, Locutores_id, Locutores_Radio_id ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, this.nome);
            stmt.setString(2, this.nomeCantor);
            stmt.setString(3, this.banda);
            stmt.setString(4, this.album);
            stmt.setInt(5, this.idEstiloMusical()); // Pegar id do Estilo pelo nome
            stmt.setString(6, this.nomeFileMusica ); 
            stmt.setInt(7, Sessao.getIdUser()); 
            stmt.setInt(8, Sessao.getIdRadio());            

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Músida adicionada com Sucesso");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Música" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    private int idEstiloMusical(){        
        int idM = 0;
        
        for(ObjetoEstiloMusical EM : Sessao.getDadosEstiloM()){
            if(EM.getNome().equals(this.estiloMusical)){
                idM = EM.getId();
                break;
            }
        }
        
        return idM;
    }
    
    public void buscarEstilosMusicais(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoEstiloMusical> estilosMusicais = new ArrayList<>();

        try {
            
            String sql = "select * from EstiloMusicais";
            
            stmt = con.prepareStatement(sql);

            
            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoEstiloMusical estiloM = new ObjetoEstiloMusical();
                
                //nome, nomeCantor, banda, album, EstiloMusicais_id
                estiloM.setId(rs.getInt("id"));
                estiloM.setNome(rs.getString("nome"));                
                                
                estilosMusicais.add(estiloM);
            }
            
            Sessao.setDadosEstiloM(estilosMusicais); // Adicionando Dados na Sessão

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar EM" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
          
    }
    
    public List<ObjetoMusica> buscarMusicasLista(int idLista){ // Buscar músicas da lista
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoMusica> listaObj = new ArrayList<>();

        try {
            
            String sql = "select distinct M.id, M.nome, M.nomeCantor, M.banda, M.album, M.nomeFileMusica, EM.nome from Musicas M join EstiloMusicais EM on M.EstiloMusicais_id = EM.id join ListasMusica LM on LM.Locutores_idLocutores = M.Locutores_id  join ListasMusica_Musicas LMM on LMM.ListasMusica_id = LM.id and LMM.Musicas_id = M.id where LM.id = ? and M.Locutores_id = ?";
            
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, idLista); // ID lista
            stmt.setInt(2, Sessao.getIdUser()); // ID locultor
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoMusica listaMusica = new ObjetoMusica(); // Objeto Musica                
                
                listaMusica.setIdMusica(rs.getInt("M.id"));
                listaMusica.setNome(rs.getString("M.nome"));
                listaMusica.setNomeCantor(rs.getString("M.nomeCantor"));
                listaMusica.setBanda(rs.getString("M.banda"));
                listaMusica.setAlbum(rs.getString("M.album"));
                listaMusica.setNomeFileMusica(rs.getString("M.nomeFileMusica"));
                listaMusica.setEstiloMusical(rs.getString("EM.nome"));
                                
                listaObj.add(listaMusica);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaObj;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNomeFileMusica() {
        return nomeFileMusica;
    }

    public void setNomeFileMusica(String nomeFileMusica) {
        this.nomeFileMusica = nomeFileMusica;
    }
    
    
    
    
        
}
