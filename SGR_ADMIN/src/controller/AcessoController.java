/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Acesso;

/**
 *
 * @author leonardo
 */

public class AcessoController extends Controller {

    private String email;
    private String senha;

    public void fazerLogin() {

        Acesso login = new Acesso(this.email, this.senha);

        if (login.getAcesso()) {
            this.valid = true;
        } else {
            this.valid = false;
            this.retornoMsg = login.getMessage();
        }

    }

    public void validCampos() {
        boolean check = true;

        if (this.email.equals("")) {
            this.retornoMsg = "Insira seu email de acesso";
            check = false;
        } else if (!this.isEmailValid()) {
            this.retornoMsg = "Email inválido";
            check = false;
        } else if (this.senha.equals("")) {
            this.retornoMsg = "Insira sua senha de acesso";
            check = false;
        }

        this.valid = check;
    }

    private boolean isEmailValid() {
        if ((this.email == null) || (this.email.trim().length() == 0)) {
            return false;
        }

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.email);
        return matcher.matches();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
