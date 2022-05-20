package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PerfilAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idPerfilAcesso;
    private String tipo;  
    
    public PerfilAcesso(int id_perfil, String tipo_perfil){
        this.idPerfilAcesso = id_perfil;
        this.tipo = tipo_perfil;
    }

    public PerfilAcesso(){
        // precisa de dois construtores para rodar a população do DB
    }

    public int getIdPerfilAcesso() {
        return idPerfilAcesso;
    }

    public void setIdPerfilAcesso(int idPerfilAcesso) {
        this.idPerfilAcesso = idPerfilAcesso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
