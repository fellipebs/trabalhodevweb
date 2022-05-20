package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCategoria;
    private String nome;

    public Categoria(int id_categoria, String nome_categoria){
        this.idCategoria = id_categoria;
        this.nome = nome_categoria;
    }

    public Categoria(){
        // precisa de dois construtores para rodar a população do DB
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
