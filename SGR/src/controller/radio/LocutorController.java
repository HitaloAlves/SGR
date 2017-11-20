/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.radio;

import controller.Controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Locutor;

/**
 *
 * @author leonardo
 */
public class LocutorController extends Controller {

    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String sexo;
    private String senha;
    private String dataNascimento;

    public void validInputs() {
        boolean check = true;

        if (this.nome.equals("")) {
            this.retornoMsg = "Preencha o campo Nome";
            check = false;
        } else if (this.telefone.equals("(  )      -      ")) {
            this.retornoMsg = "Preencha o campo Tefenone";
            check = false;
        } else if (this.email.equals("")) {
            this.retornoMsg = "Preencha o campo E-mail";
            check = false;
        } else if (this.cpf.equals("  .   -   ")) {
            this.retornoMsg = "Preencha o campo CPF";
            check = false;
        } else if (this.sexo.equals("Selecione")) {
            this.retornoMsg = "Selecione um sexo";
            check = false;
        } else if (this.senha.equals("")) {
            this.retornoMsg = "Preencha o campo Senha";
            check = false;
        } else if (this.dataNascimento.equals("  /  /    ")) {
            this.retornoMsg = "Preencha o campo Data de Nascimento";
            check = false;
        }

        this.valid = check;
    }

    public void criarLocutor() {
        Locutor criarL = new Locutor();

//            replaceAll("[^0-9]", "") Deixar somente números
        criarL.setNome(this.nome);

        // Transformando data 
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(this.dataNascimento, formato);

        criarL.setDataNascimento(java.sql.Date.valueOf(data)); // Convertendo data
        criarL.setCpf(this.cpf.replaceAll("[^0-9]", ""));
        criarL.setSexo(this.sexo);
        criarL.setTelefone(this.telefone.replaceAll("[^0-9]", ""));

        criarL.setEmail(this.email);
        criarL.setSenha(this.senha);
        
        criarL.criarLocutor();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
