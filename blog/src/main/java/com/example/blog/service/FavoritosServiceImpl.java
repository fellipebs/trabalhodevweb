package com.example.blog.service;


import com.example.blog.model.Comentario;
import com.example.blog.model.Favoritos;
import com.example.blog.repository.ComentarioRepository;
import com.example.blog.repository.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("FavoritosService")
public class FavoritosServiceImpl {
    @Autowired
    FavoritosRepository favoritosRepository;

    @Override
    public Optional<Favoritos> getFavoritosById(Integer id){ return favoritosRepository.findById(id);}

    @Override
    public void deleteAllFavoritos() {
        favoritosRepository.deleteAll();
    }

    @Override
    public void deleteAllFavoritosById(Integer id) {
        favoritosRepository.deleteById(id);
    }

    @Override
    public void updateFavoritosById(Integer id, Favoritos favoritos) { favoritosRepository.save(favoritos); }

    @Override
    public void updateFavoritos(Favoritos favoritos) {
        favoritosRepository.save(favoritos);
    }

    @Override
    public void insertFavoritos(Favoritos favoritos) {
        favoritosRepository.save(favoritos);
    }
}
