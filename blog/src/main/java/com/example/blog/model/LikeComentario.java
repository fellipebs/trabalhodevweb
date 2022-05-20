package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LikeComentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idLikeComentario;

    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_comentario", nullable = false)
    private Comentario comentario;

    public int getIdLike() {
        return idLikeComentario;
    }

    public void setIdLikeComentario(int idLikeComentario) {
        this.idLikeComentario = idLikeComentario;
    }

    // Tabelas estrangeiras
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

}
