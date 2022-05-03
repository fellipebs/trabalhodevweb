package com.example.blog.service;

import com.example.blog.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService{
    Optional<Categoria> getCategoriaById(Integer id);
    List<Categoria> getAllCategoria();
    void deleteAllCategoria();
    void deleteCategoriaById(Integer id);
    void updateCategoriaById(Integer id, Categoria categoria);
    void updateCategoria(Categoria categoria);
    void insertCategoria(Categoria categoria);
}
