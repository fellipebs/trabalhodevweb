package com.example.blog.controller;

import com.example.blog.model.Favoritos;
import com.example.blog.service.FavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FavoritosRestController {
    @Autowired
    FavoritosService favoritosService;

    @RequestMapping(value = "/favoritos", method = RequestMethod.GET)
    public List<Favoritos> get(){
        return favoritosService.getAllFavoritos();
    }

    @RequestMapping(value = "/favoritos/{id}", method = RequestMethod.GET)
    public Optional<Favoritos> getName(@PathVariable Integer id) {
        return favoritosService.getFavoritosById(id);
    }

    @RequestMapping(value = "/favoritos", method = RequestMethod.POST)
    public void post(@RequestBody Favoritos favoritos) { favoritosService.updateFavoritos(favoritos); }

    @RequestMapping(value = "/favoritos/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        favoritosService.getFavoritosById(id);
    }
}
