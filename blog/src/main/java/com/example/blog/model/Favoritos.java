package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idFavoritos;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_post", nullable=false)
    private Post post;

    public int getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(int idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    // Tabelas estrangeiras
    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Post getPost(){
        return post;
    }

    public void setPost(Post post){
        this.post = post;
    }

}
