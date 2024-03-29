package com.example.HelloServlet;

import java.io.Serializable;

public class Users implements Serializable {
    private int id;
    private String nome;
    private String email;
    private String password;

    public Users(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public Users(int id, String nome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (getId() != users.getId()) return false;
        if (getNome() != null ? !getNome().equals(users.getNome()) : users.getNome() != null) return false;
        if (getEmail() != null ? !getEmail().equals(users.getEmail()) : users.getEmail() != null) return false;
        return getPassword() != null ? getPassword().equals(users.getPassword()) : users.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
