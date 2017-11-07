/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author leonardo
 */
public class Tests {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
            
            estanciaAudioClip();    
      
    }
    
    private static void estanciaAudioClip() {
        String file = new File("musicas/Iron_Maiden_Afraid_to_Shoot_Strangers.mp3").toURI().toString();
        
        new JFXPanel();
        
        Media hit = new Media(file);
        
        MediaPlayer  media = new MediaPlayer(hit);
        
        media.play();
        
    }
    
    
}
