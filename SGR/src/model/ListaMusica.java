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
    private int lista_id;
    private int musica_id;

    private void adicionarMusicaLista() { /// Criar Lista

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
    
    
    public void getAdicionarMusicaLista(){ // Retorno de Criar Musica
        this.adicionarMusicaLista();
    }
    
    public List<ObjetoListaMusica> listasListasMusicas() { // Listar Todas as listas da Rádio e Locultor 

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
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE ListasMusica SET nome = ? WHERE id = ? and Locutores_idLocutores = ?");
            stmt.setString(1, nome);            
            stmt.setInt(2, this.lista_id);
            stmt.setInt(3, Sessao.getIdUser());

            int rowsUpdated = stmt.executeUpdate();;
            if (rowsUpdated > 0) {
                
                JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar LM" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }


    }
    
    public void getAlterarListaMusica(){
        this.alterarListaMusica();
    }
   
    
    public List<ObjetoListaMusica> consultarListaMusica(String search) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<ObjetoListaMusica> listaObj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM ListasMusica WHERE Locutores_idLocutores = ? and Radios_idRadios = ? and nome LIKE ?";
            stmt = con.prepareStatement(sql);            
            stmt.setInt(1, Sessao.getIdUser());
            stmt.setInt(2, Sessao.getIdRadio());
            stmt.setString(3, "%" + search + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ObjetoListaMusica listaMusica = new ObjetoListaMusica();

                listaMusica.setIdLista(rs.getInt("id"));
                listaMusica.setNome(rs.getString("nome"));
                
                listaObj.add(listaMusica);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar LM" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaObj;
    }

    public void agendarListaMusica() {

    }
    
    private void adicionarMusicaNaLista(){ // Adicionar musicas nas listas 
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("INSERT INTO ListasMusica_Musicas(ListasMusica_id, Musicas_id) VALUES(?, ?)");
            stmt.setInt(1, this.lista_id); 
            stmt.setInt(2, this.musica_id);            

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Música adicionada com Sucesso");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar ML" + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void getAdicionarMusicaNaLista(){        
        this.adicionarMusicaNaLista();        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLista_id() {
        return lista_id;
    }

    public void setLista_id(int lista_id) {
        this.lista_id = lista_id;
    }

    public int getMusica_id() {
        return musica_id;
    }

    public void setMusica_id(int musica_id) {
        this.musica_id = musica_id;
    }
    
    

}
