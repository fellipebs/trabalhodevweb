package com.example.blog.controller;

import com.example.blog.model.Categoria;
import com.example.blog.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaRestController {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    public List<Categoria> get(){
        return categoriaService.getAllCategoria();
    }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
    public Optional<Categoria> getName(@PathVariable Integer id) {
        return categoriaService.getCategoriaById(id);
    }

    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public void post(@RequestBody Categoria categoria) { categoriaService.updateCategoria(categoria); }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        categoriaService.getCategoriaById(id);
    }

}
