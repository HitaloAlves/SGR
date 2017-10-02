
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
    
    
    public List<ObjetoMusica> listarListasMusicas() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoMusica> listaObj = new ArrayList<>();

        try {
            
            String sql = "select M.id, M.nome, M.nomeCantor, M.banda, M.album, EM.nome from Musicas M join EstiloMusicais EM on M.EstiloMusicais_id = EM.id";
            
            stmt = con.prepareStatement(sql);
            
//            stmt.setInt(1, Sessao.getIdUser());
//            stmt.setInt(2, Sessao.getIdRadio());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoMusica listaMusica = new ObjetoMusica();
                
                //nome, nomeCantor, banda, album, EstiloMusicais_id
                listaMusica.setIdMusica(rs.getInt("M.id"));
                listaMusica.setNome(rs.getString("M.nome"));
                listaMusica.setNomeCantor(rs.getString("M.nomeCantor"));
                listaMusica.setBanda(rs.getString("M.banda"));
                listaMusica.setAlbum(rs.getString("M.album"));
                listaMusica.setEstiloMusical(rs.getString("EM.nome"));
                
                System.out.println(rs.getString("EM.nome"));
                
                listaObj.add(listaMusica);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaObj;

    }
    
    public void playMusica(String nome){
        URL url = getClass().getResource("../musicas/"+nome+".mp3");
        AudioClip audio =  Applet.newAudioClip(url);
        audio.play();
    }
    
    
    
    
    
    public void pauseMusica(){
        
    }
    
    public void nextMusica(){
        
    }
    
    public void backMusica(){
        
    }
    
    public void volumeMusica(){
        
    }
    
    public void repetirMusica(){
        
    }
    
    public void criarListaMusica(){
        
    }
    
    public void cadastrarMusica(){
        
    }
    
    public void listarMusicas(){
        
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
    
    
        
}
