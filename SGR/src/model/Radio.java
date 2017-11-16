package model;

import objetos.ObjetoRadio;
import sessao.Sessao;
import connection.ConnectionFactory;
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

    private String nome;
    private String telefone;
    private String email;
    private double modulacao;
    private double frequencia;
    private String siteRadio;
    private int cep;
    private int complemento;
    private int cnpj;

    public void consultarRadioSessao() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        ObjetoRadio radio = new ObjetoRadio();

        try {

            stmt = con.prepareStatement("SELECT * FROM Radios WHERE id = ?");

            stmt.setInt(1, Sessao.getIdUser());

            rs = stmt.executeQuery();

            while (rs.next()) {

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

                Sessao.setDadosRadio(radio);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro pegar dados Radio" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    public void consultarRadio() {

    }

    private void alterarRadio() {

    }

    private void criarRadio() {

    }

    private void excluirRadio() {

    }

    private void bloquearRadio() {

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

    public double getModulacao() {
        return modulacao;
    }

    public void setModulacao(double modulacao) {
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

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

}
