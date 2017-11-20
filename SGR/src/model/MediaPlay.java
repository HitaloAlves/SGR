/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author leonardo
 */
public final class MediaPlay {
    
    private final File musicFile;
    private final MP3Musica musica;
    
    public MediaPlay(String pathFile){
        
        this.musicFile = new File(pathFile);        
        this.musica = new MP3Musica(this.musicFile);
    }
    
    public void playMusic(){
        try {
            this.musica.playMusic();
        } catch (JavaLayerException ex) {
            Logger.getLogger(MediaPlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopMusic(){
        try {
            this.musica.stopMusic();
        } catch (JavaLayerException ex) {
            Logger.getLogger(MediaPlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

	public static class MP3Musica extends Thread {           
                
 
		// OBJETO PARA O ARQUIVO MP3 A SER TOCADO
		private final File musica;
 
		// OBJETO PLAYER DA BIBLIOTECA JLAYER QUE TOCA O ARQUIVO MP3
		private Player player;
                
                
                public MP3Musica(File music){
                    this.musica = music;
                    
                    try {
				FileInputStream fis = new FileInputStream(musica);
				BufferedInputStream bis = new BufferedInputStream(fis); 
				this.player = new Player(bis); 				
 
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Problema ao tocar Musica" + musica);
				e.printStackTrace();
			}
                }
                
                public void playMusic() throws JavaLayerException{
                    this.player.play();
                }
                
                public void stopMusic() throws JavaLayerException{
                    this.player.close();
                }
 
	}

}
