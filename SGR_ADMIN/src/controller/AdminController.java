/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Admin;
import sessao.Sessao;

/**
 *
 * @author leonardo
 */
public class AdminController extends Controller {

    private String senha;

    public void alterarSenha() {
        if (!this.senha.equals(Sessao.getTadosUser().getSenha())) {
            Admin admin = new Admin();
            admin.setSenha(this.senha);
            admin.getAlterarSenhaUserAdmin();
            
            this.valid = true;
        } else {
            this.valid = false;
            this.retornoMsg = "Senha não foi alterada";
        }

    }

    public void verifInput() {
        if (!this.senha.equals("")) {
            this.valid = true;
        } else {
            this.valid = false;
            this.retornoMsg = "Digite sua senha";
        }
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
