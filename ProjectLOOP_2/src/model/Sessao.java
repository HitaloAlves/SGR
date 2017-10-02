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
    
    private static int idRadio;

    private static String nomeTableUser;

    private static ObjetoLocutor dadosUser;

    private static ObjetoRadio dadosRadio;

    public static ObjetoLocutor getDadosUser() {
        return dadosUser;
    }

    public static void setDadosUser(ObjetoLocutor dadosUser) {
        Sessao.dadosUser = dadosUser;
    }

    public static ObjetoRadio getDadosRadio() {
        return dadosRadio;
    }

    public static void setDadosRadio(ObjetoRadio dadosRadio) {
        Sessao.dadosRadio = dadosRadio;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Sessao.idUser = idUser;        
    }

    public static int getIdRadio() {
        return idRadio;
    }

    public static void setIdRadio(int idRadio) {
        Sessao.idRadio = idRadio;
    }
    
    

    public static String getNomeTableUser() {
        return nomeTableUser;        
    }

    public static void setNomeTableUser(String nomeTableUser) {
        Sessao.nomeTableUser = nomeTableUser;
        Sessao.buscarDados();
    }

    private static void buscarDados() {

        if ("Radios".equals(Sessao.nomeTableUser)) {
            Radio radio = new Radio();
            radio.consultarRadioSessao();
        } else {
            Locutor locutor = new Locutor();
            locutor.consultarLocutorSessao();
        }

    }

    public static void atualizarDados() {
        Sessao.buscarDados();
    }

}
