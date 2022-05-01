package com.example.blog.repository;

import com.example.blog.model.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FavoritosService")
public interface FavoritosRepository extends JpaRepository<Favoritos, Integer> {
}
