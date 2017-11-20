/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.locutor;

import controller.Controller;
import java.util.List;
import model.ListaMusica;
import objetos.ObjetoListaMusica;

/**
 *
 * @author leonardo
 */
public class PlayListaController extends Controller {

    private String nome;
    private int lista_id;
    private int musica_id;

    public void validInput() {
        boolean check = true;

        if (this.nome.equals("")) {
            this.retornoMsg = "Preencha o campo Nome";
            check = false;
        }

        this.valid = check;
    }

    public void cadPlayLista() {
        ListaMusica lmusica = new ListaMusica();
        lmusica.setNome(this.nome);
        lmusica.adicionarMusicaLista();
    }

    public void alterarListaMusica() {
        ListaMusica listaMA = new ListaMusica();
        listaMA.setLista_id(this.lista_id);
        listaMA.setNome(this.nome);

        listaMA.alterarListaMusica();
    }

    public void adicionarMusicaNaLista() {
        ListaMusica listaM = new ListaMusica();

        listaM.setLista_id(this.lista_id);
        listaM.setMusica_id(this.musica_id);

        listaM.adicionarMusicaNaLista();
    }
    
    public List<ObjetoListaMusica> listasPlayListas() {
        ListaMusica listaM = new ListaMusica();

        return listaM.listasListasMusicas();
    }
    
    public List<ObjetoListaMusica> consultarPlayLista(String search) {
        ListaMusica listaM = new ListaMusica();

        return listaM.consultarListaMusica(search);
    }
    
    public void excluirPlayLista() {
        ListaMusica listaM = new ListaMusica();
        listaM.setLista_id(this.lista_id);
        listaM.excluirListaMusica();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLista_id(int lista_id) {
        this.lista_id = lista_id;
    }

    public void setMusica_id(int musica_id) {
        this.musica_id = musica_id;
    }

}
