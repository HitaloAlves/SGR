package model;

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
public class Acesso {

    private final String email;
    private final String senha;
    private String tableAcesso;
    private String message;

    private boolean acesso;

    public Acesso(String email, String senha, int typeUser) {
        this.email = email;
        this.senha = senha;

        this.tableAcessoUser(typeUser); // setar Nome Tabela

        this.fazerLogin();
    }

    private void tableAcessoUser(int typeUser) {
        // Tipo 1: Radio, Tipo 2: Locutor

        switch (typeUser) {
            case 1:
                this.tableAcesso = "Radios";
                break;
            case 2:
                this.tableAcesso = "Locutores";
                break;
        }

    }

    private void fazerLogin() {
        if (verificarEmail()) {

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            ResultSet rs = null;

            String sqlLocutor = "SELECT L.id, L.Radio_id, RB.Radio_id FROM " + this.tableAcesso + " L LEFT JOIN RadiosBloqueados RB ON RB.Radio_id = L.Radio_id WHERE L.email = ? and L.senha = ?";
            String sqlRadio = "SELECT R.id, RB.Radio_id FROM " + this.tableAcesso + " R LEFT JOIN RadiosBloqueados RB ON RB.Radio_id = R.id WHERE R.email = ? and R.senha = ?";

            try {

                String sql = "Radios".equals(this.tableAcesso) ? sqlRadio : sqlLocutor; // Selecionar sql adequando ao acesso;

                stmt = con.prepareStatement(sql);
                stmt.setString(1, this.email);
                stmt.setString(2, this.senha);

                rs = stmt.executeQuery();

                if (rs.next()) { // Se selecionar tupla, usuario logado

                    if ("Radios".equals(this.tableAcesso)) { // Verficação para Radio
                        if (this.verficarBloqueio(rs.getInt("RB.Radio_id"), rs.getInt("R.id"))) {
                            this.message = "Sua conta foi Bloqueada, entre em conta com SRG";
                            this.acesso = false;
                        } else {
                            Sessao.setIdUser(rs.getInt("id")); // Sessao id                           
                            Sessao.setNomeTableUser(this.tableAcesso);
                            this.acesso = true;
                        }
                    } else { // Verificação para o Locutor
                        if (this.verficarBloqueio(rs.getInt("RB.Radio_id"), rs.getInt("L.Radio_id"))) {
                            this.message = "Sua conta foi Bloqueada, entre em conta com SRG";
                            this.acesso = false;
                        } else {
                            Sessao.setIdUser(rs.getInt("id")); // Sessao id
                            Sessao.setIdRadio(rs.getInt("L.Radio_id"));
                            Sessao.setNomeTableUser(this.tableAcesso);
                            this.acesso = true;
                        }
                    }

                } else {
                    this.message = "Senha incorreta";
                    this.acesso = false;
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Realizar Login" + ex);
                this.message = "Erro ao Realizar Login";
                this.acesso = false;
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }

        } else {
            this.message = "Email não está cadastrado";
            this.acesso = false;
        }
    }

    private boolean verficarBloqueio(int id_bloqueio, int id_user) {

        boolean check = false;

        if (id_user == id_bloqueio) {
            check = true;
        }

        return check;
    }

    private boolean verificarEmail() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        boolean check = false;

        try {

            String sql = "SELECT id FROM " + this.tableAcesso + " WHERE email = ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, this.email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Realizar Login" + ex);
            this.message = "Erro ao Realizar Login";
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public String getMessage() {
        return this.message;
    }

    public boolean getAcesso() {
        return this.acesso;
    }

}
