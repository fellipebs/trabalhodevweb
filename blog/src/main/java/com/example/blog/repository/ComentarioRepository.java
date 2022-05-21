package com.example.blog.repository;

import java.util.List;

import com.example.blog.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ComentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    
    @Query(value = "SELECT * FROM COMENTARIO WHERE id_post = ?1", nativeQuery = true)
    List<Comentario> getAllComentariosByPostId(int id);    
    
}
