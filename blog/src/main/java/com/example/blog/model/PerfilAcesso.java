package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PerfilAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idPerfilAcesso;
    private String tipo;

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
