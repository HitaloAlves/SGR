/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import javafx.scene.media.AudioClip;

/**
 *
 * @author leonardo
 */
public final class MediaPlay {

    private static ObjetoMusica musica;

    private static AudioClip clip;

    private static String AUDIO_URL;

    private static boolean playUse; // Play em uso 

    public static void playMusica() {
        clip.play(); // 2
        MediaPlay.playUse = true;
    }

    public static void pauseMusica() {
        clip.stop();
        MediaPlay.playUse = false;
    }

    public static void nextMusica() {

    }

    public static void backMusica() {

    }

    public static void volumeMusica(double volume) {
        clip.setVolume(volume);
    }

    public static void repetirMusica() {

    }

    public static ObjetoMusica getMusica() {
        return musica;
    }

    public static void setMusica(ObjetoMusica musica) {
        MediaPlay.musica = musica;

        File file = new File("musicas/" + MediaPlay.musica.getNomeFileMusica());

        MediaPlay.AUDIO_URL = file.toURI().toString(); // AudioClip precisa de uma URL ou File:// ou Htpp
        MediaPlay.estanciaAudioClip();
    }

    private static void estanciaAudioClip() {
        MediaPlay.clip = new AudioClip(AUDIO_URL);
    }

    public static boolean playUse() {
        return MediaPlay.playUse;
    }

}
