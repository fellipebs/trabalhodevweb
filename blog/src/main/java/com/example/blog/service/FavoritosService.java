package com.example.blog.service;

import com.example.blog.model.Favoritos;

import java.util.List;
import java.util.Optional;

public interface FavoritosService {
    Optional<Favoritos> getFavoritosById(Integer id);
    List<Favoritos> getAllFavoritos();
    void deleteAllFavoritos();
    void deleteFavoritosById(Integer id);
    void updateFavoritosById(Integer id, Favoritos favoritos);
    void updateFavoritos(Favoritos favoritos);
    void insertFavoritos(Favoritos favoritos);
}
