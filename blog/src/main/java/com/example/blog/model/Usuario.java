package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    

    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String biografia;

    public Usuario(int id_usuario, String nome_usuario, String email_usuario, String senha_usuario, String foto_usuario, String biografia_usuario, PerfilAcesso perfilAcesso){
        this.idUsuario = id_usuario;
        this.nome = nome_usuario;
        this.email = email_usuario;
        this.senha = senha_usuario;
        this.foto = foto_usuario;
        this.biografia = biografia_usuario;
        this.perfilAcesso = perfilAcesso;
    }

    public Usuario(){
        // precisa de dois construtores para rodar a população do DB
    }

    @OneToOne
    @JoinColumn(name = "id_perfil_acesso", nullable = false)
    private PerfilAcesso perfilAcesso;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    // Tabelas estrangeiras
    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

}
