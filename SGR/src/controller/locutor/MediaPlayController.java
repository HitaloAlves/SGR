/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.locutor;

import controller.Controller;
import java.io.File;
import javax.swing.JOptionPane;
import model.MediaPlay;
import objetos.ObjetoMusica;

/**
 *
 * @author leonardo
 */
public class MediaPlayController extends Controller{

    private ObjetoMusica music;
    private MediaPlay mediaPlay;

    public MediaPlayController(ObjetoMusica music) {   
        String pathMusic = "musicas/" + music.getNomeFileMusica();
        if (validFile(pathMusic)) {
            this.music = music;            
            this.mediaPlay = new MediaPlay(pathMusic);
        }
    }

    public void play() {
        this.mediaPlay.playMusic();
    }
    
    public void stop() {
        this.mediaPlay.stopMusic();
    }

    private boolean validFile(String path) {
        boolean check = false;
        
        File file = new File(path);

        if (file.exists()) {
            check = true;
        } else {            
            JOptionPane.showMessageDialog(null, "File Música: " + music.getNome() + " não encontrada");
        }
        
        return check;
    }

    public ObjetoMusica getMusic() {
        return music;
    }

}
