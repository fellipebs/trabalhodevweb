package com.example.blog.service;

import com.example.blog.model.Comentario;

import java.util.List;
import java.util.Optional;

public interface ComentarioService {
    Optional<Comentario> getComentarioById(Integer id);
    List<Comentario> getAllComentarioByPostId(Integer id);
    List<Comentario> getAllComentario();
    void deleteComentarioById(Integer id);
    void updateComentarioById(Integer id, Comentario comentario);
    void updateComentario(Comentario comentario);
    void insertComentario(Comentario comentario);
}
