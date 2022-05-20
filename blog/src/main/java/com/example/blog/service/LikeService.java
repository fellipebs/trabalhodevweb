package com.example.blog.service;

import com.example.blog.model.LikeComentario;
import java.util.List;
import java.util.Optional;

public interface LikeService {
    Optional<LikeComentario> getLikeById(Integer id);
    List<LikeComentario> getAllLike();
    void deleteLikeById(Integer id);
    void insertlike(LikeComentario Like);
}
