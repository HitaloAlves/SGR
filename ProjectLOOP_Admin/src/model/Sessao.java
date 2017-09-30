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

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Sessao.idUser = idUser;
    }
    
}
