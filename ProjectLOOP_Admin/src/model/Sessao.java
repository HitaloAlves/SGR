/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author leonardo
 */
public final class Sessao {
    
    private static int idUser;
    
    private static ObjetoPessoa tadosUser;

    public static ObjetoPessoa getTadosUser() {
        return tadosUser;
    }

    public static void setTadosUser(ObjetoPessoa tadosUser) {
        Sessao.tadosUser = tadosUser;
    }

    
    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Sessao.idUser = idUser;
        Sessao.buscarDadosAdmin();       
    }
    
    private static void buscarDadosAdmin(){
        Admin admDados = new Admin();
        admDados.consultarAdminSessao();
    }
    
    public static void atualizarDadosUser(){
        Sessao.buscarDadosAdmin();
    }
    
}
