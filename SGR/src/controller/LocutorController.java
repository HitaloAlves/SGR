/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Locutor;
import sessao.Sessao;

/**
 *
 * @author leonardo
 */
public class LocutorController extends Controller {

    private String senha;

    public void alterarSenha() {
        if (!this.senha.equals(Sessao.getDadosUser().getSenha())) {
            Locutor locutor = new Locutor();
            locutor.setSenha(this.senha);
            
            locutor.alterarSenhaLocutor();
            
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
