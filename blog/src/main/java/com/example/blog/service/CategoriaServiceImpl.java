package com.example.blog.service;

import com.example.blog.model.Categoria;
import com.example.blog.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CategoriaService")
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Optional<Categoria> getCategoriaById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> getAllCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public void deleteAllCategoria() {
        categoriaRepository.deleteAll();
    }

    @Override
    public void deleteCategoriaById(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void updateCategoriaById(Integer id, Categoria categoria) { categoriaRepository.save(categoria); }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void insertCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

}
