/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Musica;
import objetos.ObjetoMusica;
import view.locutor.TelaMusica;

/**
 *
 * @author leonardo
 */
public class MusicaController extends Controller{
    
    private int id_musica;
    private String nome;
    private String estiloMusical;
    private String nomeCantor;
    private String banda;
    private String album;
    private String nomeFileMusica;
    
    private File fileMusica; // Musica a ser enviada
    private File caminho; // Onde vai ser Salva    
    
    
    public void validInputs(){
        boolean check = true;

        if (this.nomeFileMusica.equals("")) {
            this.retornoMsg = "Selecione uma música para adicionar";
            check = false;
        } else if (this.nome.equals("")) {
            this.retornoMsg = "Preencha o campo Nome Música";
            check = false;
        } else if (this.nomeCantor.equals("")) {
            this.retornoMsg = "Preencha o campo Cantor";
            check = false;
        } else if (this.banda.equals("")) {
            this.retornoMsg = "Preencha o campo Banda";
            check = false;
        } else if (this.album.equals("")) {
            this.retornoMsg = "Preencha o campo Álbum";
            check = false;
        } else if (this.estiloMusical.equals("Selecione")) {
            this.retornoMsg = "Selecione um estilo Muscical";
            check = false;
        }
        
        this.valid = check;
    }
    
    public void enviarMusicaPasta() {

        boolean check = false;

        this.nomeFileMusica = converte(this.nome) + "_" + converte(this.nomeCantor) + ".mp3";

        this.caminho = new File("musicas/" + nomeFileMusica); // Caminho para a música

        try {
            
            MusicaController.copyFile(new File(fileMusica.getPath()), this.caminho);

            check = true;

        } catch (IOException ex) {            
            Logger.getLogger(TelaMusica.class.getName()).log(Level.SEVERE, null, ex);
            this.retornoMsg = "Não foi possível enviar música";
        }

        this.valid = check;
    }
    
    private String converte(String text) {
        return text.replaceAll("[ãâàáä]", "a")
                .replaceAll("[êèéë]", "e")
                .replaceAll("[îìíï]", "i")
                .replaceAll("[õôòóö]", "o")
                .replaceAll("[ûúùü]", "u")
                .replaceAll("[ÃÂÀÁÄ]", "A")
                .replaceAll("[ÊÈÉË]", "E")
                .replaceAll("[ÎÌÍÏ]", "I")
                .replaceAll("[ÕÔÒÓÖ]", "O")
                .replaceAll("[ÛÙÚÜ]", "U")
                .replace('ç', 'c')
                .replace('Ç', 'C')
                .replace('ñ', 'n')
                .replace('Ñ', 'N')
                .replace(' ', '_')
                .replaceAll("!", "_")
                .replaceAll("\\[\\´\\`\\?!\\@\\#\\$\\%\\¨\\*", "_")
                .replaceAll("\\(\\)\\=\\{\\}\\[\\]\\~\\^\\]", "_")
                .replaceAll("[\\.\\;\\-\\_\\+\\'\\ª\\º\\:\\;\\/]", "_");
    }
    
    public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists()) {
            destination.delete();
        }
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }
    
    public void cadMusica(){
        Musica music = new Musica();

        music.setNome(this.nome);
        music.setBanda(this.banda);
        music.setNomeCantor(this.nomeCantor);
        music.setAlbum(this.album);
        music.setEstiloMusical(this.estiloMusical);
        music.setNomeFileMusica(this.nomeFileMusica);

        music.cadastrarMusica();
    }
    
    public void alterarMusica(){
        Musica music = new Musica();

        music.setNome(this.nome);
        music.setBanda(this.banda);
        music.setNomeCantor(this.nomeCantor);
        music.setAlbum(this.album);
        music.setEstiloMusical(this.estiloMusical);
        music.setId_musica(this.id_musica);

        music.alterarMusica();
    }
    
    public List<ObjetoMusica> listarListasMusicas() {
        Musica music = new Musica();

        return music.listarListasMusicas();
    }
    
    public List<ObjetoMusica> consultarMusicas(String serach) {
        Musica music = new Musica();

        return music.consultarMusica(serach);
    }

    public void setId_musica(int id_musica) {
        this.id_musica = id_musica;
    }    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setNomeFileMusica(String nomeFileMusica) {
        this.nomeFileMusica = nomeFileMusica;
    }

    public void setFileMusica(File fileMusica) {
        this.fileMusica = fileMusica;
    }
        
    
    
}
