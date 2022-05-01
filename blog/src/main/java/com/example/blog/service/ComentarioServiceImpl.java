package com.example.blog.service;

import com.example.blog.model.Categoria;
import com.example.blog.model.Comentario;
import com.example.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ComentarioService")
public class ComentarioServiceImpl {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public Optional<Comentario> getComentarioById(Integer id){ return comentarioRepository.findById(id);}

    @Override
    public void deleteAllComentarioById(Integer id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public void updateComentarioById(Integer id, Comentario comentario) { comentarioRepository.save(comentario); }

    @Override
    public void updateComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void insertComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }
}
