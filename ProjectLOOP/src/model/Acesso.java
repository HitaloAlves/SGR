/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private final int typeUser;
    private String tableAcesso;
    private String message;
    
    private int UserId;

    public Acesso(String email, String senha, int typeUser) {

        this.email = email;
        this.senha = senha;
        this.typeUser = typeUser;

        this.tableAcessoUser(this.typeUser);

        this.fazerLogin();

    }

    private void tableAcessoUser(int typeUser) {
        // Tipo 0: Admin, Tipo 1: Radio, Tipo 2: Locutor

        String table = "Admin";

        switch (typeUser) {
            case 1:
                table = "Radios";
                break;
            case 2:
                table = "Locutor";
                break;
        }

        this.tableAcesso = table;

    }

    private void fazerLogin() {
        if (verificarEmail()) {       
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            ResultSet rs = null;

                try {
                    
                    String sql = "SELECT id FROM "+this.tableAcesso+" WHERE email = ? and senha = ?";
                    
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, this.email);
                    stmt.setString(2, this.senha);

                    rs = stmt.executeQuery();

                    if (rs.next()) { // Se selecionar tupla, usuario logado
                        this.UserId = rs.getInt("id");
                    } else {
                        this.message = "Senha incorreta";
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Realizar Login" + ex);
                    this.message = "Erro ao Realizar Login";
                } finally {
                    ConnectionFactory.closeConnection(con, stmt, rs);
                }

        } else {
            this.message = "Email não está cadastrado";
        }
    }

    private boolean verificarEmail() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        boolean check = false;

        try {

            String sql = "SELECT id FROM " + this.tableAcesso + " WHERE email = ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);

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
        
    public int getUserId(){
        return this.UserId;
    }

    public String getMessage() {
        return this.message;
    }

}
