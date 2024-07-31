/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

/**
 *
 * @author joaop
 */
public class UsersM { //clientes

    private int id;
    private String nome;
    private String cpf;
    private int sexoId;
    private String endereco;
    private String cep;
    private String telefone;
    private String email;
    private String sexoNome;

    public UsersM() {
    }

    public UsersM(int id, String nome, String cpf, int sexoId, String endereco, String cep, String telefone, String email, String sexoNome) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexoId = sexoId;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.sexoNome = sexoNome;
    }
    
    
        public UsersM( String nome, String cpf, int sexoId, String endereco, String cep, String telefone, String email, String sexoNome) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexoId = sexoId;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.sexoNome = sexoNome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexoId(int sexoId) {
        this.sexoId = sexoId;
    }

    public void setSexoNome(String sexoNome) {
        this.sexoNome = sexoNome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getSexoId() {
        return sexoId;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSexoNome() {
        return sexoNome;
    }
}
