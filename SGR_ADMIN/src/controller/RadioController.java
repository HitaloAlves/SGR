/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.ObjetoRadio;
import model.Radio;

/**
 *
 * @author leonardo
 */
public class RadioController extends Controller{
    
    private int idRadio;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String modulacao;
    private String frequencia;
    private String siteRadio;
    private String cep;
    private String complemento;
    private String cnpj;    
    
    public void validInput() {
        boolean check = true;

        if (this.nome.equals("")) {
            this.retornoMsg = "Preencha o campo Nome";
            check = false;
        } else if (this.telefone.equals("(  )      -      ")) {
            this.retornoMsg = "Preencha o campo Tefenone";
            check = false;
        } else if (this.cnpj.equals("  .   .   /    -  ")) {
            this.retornoMsg = "Preencha o campo CNPJ";
            check = false;
        } else if (this.cep.equals("  .   -   ")) {
            this.retornoMsg = "Preencha o campo CEP";
            check = false;
        } else if (this.frequencia.equals("")) {
            this.retornoMsg = "Preencha o campo Frequência";
            check = false;
        } else if (this.email.equals("")) {
            this.retornoMsg = "Preencha o campo E-mail";
            check = false;
        } else if (this.senha.equals("")) {
            this.retornoMsg = "Preencha o campo Senha";
            check = false;
        }

        this.valid = check;
    }
    
    public void cadastrarRadio(){
        
        boolean check = false;
        
        this.validInput(); // Validar campos
        
        if(this.valid){
            Radio criarR = new Radio();
            
            // replaceAll("[^0-9]", "") Deixar somente números

            criarR.setNome(this.nome);
            criarR.setTelefone(this.telefone.replaceAll("[^0-9]", ""));
            criarR.setEmail(this.email);    
            criarR.setModulacao(this.modulacao);
            
            // Transformar valor em formato número americano
            String formatNumeroFre = this.frequencia.replaceAll("\\.", "");
            criarR.setFrequencia(Double.parseDouble(formatNumeroFre.replace(',', '.')));
            
            criarR.setSiteRadio(this.siteRadio);
            criarR.setCep(Integer.parseInt(this.cep.replaceAll("[^0-9]", "")));
            criarR.setComplemento(this.complemento);
            criarR.setCnpj(this.cnpj.replaceAll("[^0-9]", ""));
            criarR.setEmail(this.email);
            criarR.setSenha(this.senha);
            
            if(criarR.getCriarRadio()){
                
                check = true;
                
            }
            
           this.valid = check;
        }            
        
    }
    
    public void alterarRadio() {
        
        this.validInput(); // Validar campos
        
        if(this.valid){
            Radio alterarR = new Radio();
            
            // replaceAll("[^0-9]", "") Deixar somente números

            alterarR.setNome(this.nome);
            alterarR.setTelefone(this.telefone.replaceAll("[^0-9]", ""));
            alterarR.setEmail(this.email);    
            alterarR.setModulacao(this.modulacao);
            
            // Transformar valor em formato número americano
            String formatNumeroFre = this.frequencia.replaceAll("\\.", "");
            alterarR.setFrequencia(Double.parseDouble(formatNumeroFre.replace(',', '.')));
            
            alterarR.setSiteRadio(this.siteRadio);
            alterarR.setCep(Integer.parseInt(this.cep.replaceAll("[^0-9]", "")));
            alterarR.setComplemento(this.complemento);
            alterarR.setCnpj(this.cnpj.replaceAll("[^0-9]", ""));
            alterarR.setEmail(this.email);
            alterarR.setSenha(this.senha);
            
            alterarR.setIdRadio(this.idRadio);
            
            
            alterarR.getAlterarRadio();            
            
            this.valid = true;
        }  
    }
    
    public void bloquearRadio(){
        Radio radio = new Radio();  
        
        radio.setIdRadio(this.idRadio);

        radio.getBloquearRadio();
    }
    
    public void desbloquearRadio(){
        Radio radio = new Radio();  
        
        radio.setIdRadio(this.idRadio);

        radio.getDesbloquearRadio();
    }

    public List<ObjetoRadio> searchRadio(String search){
        
        Radio radio = new Radio();

        return radio.searchRadio(search);        
    }
    
    public List<ObjetoRadio> listasRadios(){
        
        Radio radio = new Radio();

        return radio.listasRadios();      
    }
    
    

    public int getIdRadio() {
        return idRadio;
    }

    public void setIdRadio(int idRadio) {
        this.idRadio = idRadio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getModulacao() {
        return modulacao;
    }

    public void setModulacao(String modulacao) {
        this.modulacao = modulacao;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getSiteRadio() {
        return siteRadio;
    }

    public void setSiteRadio(String siteRadio) {
        this.siteRadio = siteRadio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }    
        
}
