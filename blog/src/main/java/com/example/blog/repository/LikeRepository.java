package com.example.blog.repository;

import com.example.blog.model.LikeComentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("LikeRepository")
public interface LikeRepository extends JpaRepository<LikeComentario, Integer> {
}
