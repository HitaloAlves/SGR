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
public class Acesso {
    
    private final String email;
    private final String senha;
    private final int typeUser;
    private String tableAcesso;
    private String message;
    
    public Acesso(String email, String senha, int typeUser){
        
        this.email = email;
        this.senha = senha;
        this.typeUser = typeUser;
        
        this.tableAcessoUser(this.typeUser);
        
        this.verificarEmail();
        
    }
    
    private void tableAcessoUser(int typeUser){
        // Tipo 0: Admin, Tipo 1: Radio, Tipo 2: Locutor
        
        String table = "Admin";
        
        switch (typeUser){
            case 1:
                table = "Radio";
                 break;
            case 2:
                table = "Locutor";
                break;
        }
        
        this.tableAcesso = table;
        
    }
    
    private void verificarTypeUser(){
        
    }
    
    private void verificarEmail(){        
        
        if("leo".equals(this.email)){
            this.verificarSenha();
        } else {
            this.message = "Email não está cadastrado";
        }
        
    }
    
    private void verificarSenha(){
        if("123".equals(this.senha)){
            this.fazerLogin();
        } else {
            this.message = "Senha incorreta";
        }
    }
    
    private void fazerLogin(){
        
        this.message = "Tipo: " + this.tableAcesso;
        
    }  
    
    public String getMessage(){
        return this.message;
    }
    
}
