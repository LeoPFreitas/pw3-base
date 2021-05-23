package com.example.empresa.entity;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String username;
    private String password;

    public Usuario(int id, String nome, String email, String cpf, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.username = username;
        this.password = password;
    }

    public Usuario(String nome, String email, String cpf, String username, String password) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
