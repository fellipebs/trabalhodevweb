package com.example.blog.repository;

import com.example.blog.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ComentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
