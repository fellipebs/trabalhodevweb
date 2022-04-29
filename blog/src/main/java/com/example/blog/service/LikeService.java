package com.example.blog.service;

import com.example.blog.model.Like;
import java.util.List;
import java.util.Optional;

public interface LikeService {
    Optional<Like> getFavoritosById(Integer id);
    List<Like> getAllFavoritos();
    void deleteFavoritosById(Integer id);
    void insertFavoritos(Like Like);
}
