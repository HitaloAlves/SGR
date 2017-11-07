/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author leonardo
 */
public final class TocadorMusica {

    private static ObjetoMusica musica;

    private static MediaPlayer audioMusica;

    private static String AUDIO_URL;

    private static boolean playUse; // Play em uso 
    
    private static long clipTime;

    public static void playMusica() {
        TocadorMusica.audioMusica.play(); // 2
        TocadorMusica.playUse = true;
    }

    public static void pauseMusica() {
        TocadorMusica.audioMusica.pause();
    }
    
    public static void stopMusica(){
        audioMusica.stop();
        TocadorMusica.playUse = false;
    }

    public static void nextMusica() {

    }

    public static void backMusica() {

    }

    public static void volumeMusica(double volume) {
        TocadorMusica.audioMusica.setVolume(volume);
    }

    public static void repetirMusica() {
        TocadorMusica.audioMusica.getOnRepeat();
    }

    public static ObjetoMusica getMusica() {
        return TocadorMusica.musica; // Retornando Objeto 
    }

    public static void setMusica(ObjetoMusica musica) {
        TocadorMusica.musica = musica;

        File file = new File("musicas/" + TocadorMusica.musica.getNomeFileMusica());

        TocadorMusica.AUDIO_URL = file.toURI().toString(); // AudioClip precisa de uma URL ou File:// ou Htpp
        TocadorMusica.estanciaAudioClip();
    }

    private static void estanciaAudioClip() {
        
        JFXPanel fxPanel = new JFXPanel();
               
        Media hit = new Media(TocadorMusica.AUDIO_URL);
        
        TocadorMusica.audioMusica = new MediaPlayer(hit);
    }

    public static boolean playUse() {
        return TocadorMusica.playUse;
    }

}
