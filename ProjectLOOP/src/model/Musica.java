/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author leonardo
 */
public class Musica {
    
    private String nome;
    private String estiloMusical;
    private String nomeCantor;
    private String banda;
    private String album;
    
    public void playMusica(String nome){
        URL url = getClass().getResource("../musicas/"+nome+".mp3");
        AudioClip audio =  Applet.newAudioClip(url);
        audio.play();
    }
    
    
    public void pauseMusica(){
        
    }
    
    public void nextMusica(){
        
    }
    
    public void backMusica(){
        
    }
    
    public void autMusica(){
        
    }
    
    public void repetirMusica(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    
        
}
