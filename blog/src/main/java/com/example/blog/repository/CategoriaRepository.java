package com.example.blog.repository;

import com.example.blog.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
