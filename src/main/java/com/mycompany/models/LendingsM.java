package com.mycompany.models;

import java.time.LocalDateTime;

public class LendingsM {

    private int id;
    private int funcionarioId;
    private int clienteId;
    private int itemId;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private int devolvido;
    private String nomeFuncionario;
    private String nomeCliente;
    private String nomeItem;

    public LendingsM() {
    }

    public LendingsM(int id, int funcionarioId, int usuarioId,
            int itemId, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao,
            int devolvido, String nomeFuncionario, String nomeCliente, String nomeItem) {
        
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.clienteId = usuarioId;
        this.itemId = itemId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeCliente = nomeCliente;
        this.nomeItem = nomeItem;
    }

    public LendingsM(int funcionarioId, int usuarioId,
            int itemId, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao,
            int devolvido, String nomeFuncionario, String nomeCliente, String nomeItem) {

        this.funcionarioId = funcionarioId;
        this.clienteId = usuarioId;
        this.itemId = itemId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeCliente = nomeCliente;
        this.nomeItem = nomeItem;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int usuarioId) {
        this.clienteId = usuarioId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(int devolvido) {
        this.devolvido = devolvido;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
}
