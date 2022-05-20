package com.example.blog.service;

import com.example.blog.model.Like;
import java.util.List;
import java.util.Optional;

public interface LikeService {
    Optional<Like> getLikeById(Integer id);
    List<Like> getAllLike();
    void deleteLikeById(Integer id);
    void insertlike(Like Like);
}
