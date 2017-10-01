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
    private static String nomeTableUser;
    
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
        Sessao.buscarDadosUser();       
    }

    public static String getNomeTableUser() {
        return nomeTableUser;
    }

    public static void setNomeTableUser(String nomeTableUser) {
        Sessao.nomeTableUser = nomeTableUser;
    }
    
    private static void buscarDadosUser(){
        
    }
    
    public static void atualizarDadosUser(){
        Sessao.buscarDadosUser();
    }
    
}
