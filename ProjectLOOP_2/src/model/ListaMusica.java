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
public class ListaMusica {

    private String nome;
    private Musica musicas;
    private Locutor locutor;

    private void adicionarMusicaLista() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("INSERT INTO ListasMusica(nome, Locutores_idLocutores, Radios_idRadios) VALUES(?, ?, ?)");
            stmt.setString(1, this.nome);
            stmt.setInt(2, Sessao.getIdUser());
            stmt.setInt(3, Sessao.getIdRadio());            

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Lista criada com Sucesso");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Locutor" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    public void getAdicionarMusicaLista(){
        this.adicionarMusicaLista();
    }
    
    public List<ObjetoListaMusica> listasListasMusicas() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoListaMusica> listaObj = new ArrayList<>();

        try {
            
            stmt = con.prepareStatement("SELECT * FROM ListasMusica WHERE Locutores_idLocutores = ? and Radios_idRadios = ?");
            
            stmt.setInt(1, Sessao.getIdUser());
            stmt.setInt(2, Sessao.getIdRadio());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoListaMusica listaMusica = new ObjetoListaMusica();

                listaMusica.setIdLista(rs.getInt("id"));
                listaMusica.setNome(rs.getString("nome"));
                
                listaObj.add(listaMusica);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaObj;

    }
   

    private void excluirListaMusica() {

    }

    private void alterarListaMusica() {

    }

    public void consultarListaMusica() {

    }

    public void agendarListaMusica() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
