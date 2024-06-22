package com.mycompany.models;

/**
 *
 * @author joaop
 */
public class EmployeeM {

    private int id;
    private String nomeUsuario;
    private String senha;
    private String nome;
    private String email;
    private int sexoId;
    private String papel;
    private String sexoNome;
    private int idFuncionarioLogado;

    // Construtores, getters e setters
    public EmployeeM() {
    }

    public EmployeeM(int id, String nomeUsuario, String senha, String nome, String email, int sexoId, String papel, String sexoNome) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.sexoId = sexoId;
        this.papel = papel;
        this.sexoNome = sexoNome;
    }

    public EmployeeM(String nomeUsuario, String senha, String nome, String email, int sexoId, String papel, String sexoNome) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.sexoId = sexoId;
        this.papel = papel;
        this.sexoNome = sexoNome;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexoId() {
        return sexoId;
    }

    public void setSexoId(int sexoId) {
        this.sexoId = sexoId;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getSexoNome() {
        return sexoNome;
    }

    public void setSexoNome(String sexoNome) {
        this.sexoNome = sexoNome;
    }

    // Métodos para o ID do funcionário logado
    public int getIdFuncionarioLogado() {
        return idFuncionarioLogado;
    }

    public void setIdFuncionarioLogado(int idFuncionarioLogado) {
        this.idFuncionarioLogado = idFuncionarioLogado;
    }
}
