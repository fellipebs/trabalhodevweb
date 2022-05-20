package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LikeComentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idLikeComentario;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_comentario", nullable = false)
    private Comentario comentario;    

    public int getIdLike() {
        return idLikeComentario;
    }

    public void setIdLikeComentario(int idLikeComentario) {
        this.idLikeComentario = idLikeComentario;
    }

    // Tabelas estrangeiras
    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

}
