package com.example.blog.controller;

import com.example.blog.model.Comentario;
import com.example.blog.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComentarioRestController {
    @Autowired
    ComentarioService comentarioService;

    @RequestMapping(value = "/comentario", method = RequestMethod.GET)
    public List<Comentario> get(){
        return comentarioService.getAllComentario();
    }

    @RequestMapping(value = "/comentario/{id}", method = RequestMethod.GET)
    public Optional<Comentario> getName(@PathVariable Integer id) {
        return comentarioService.getComentarioById(id);
    }

    @RequestMapping(value = "/comentario", method = RequestMethod.POST)
    public void post(@RequestBody Comentario comentario) { comentarioService.updateComentario(comentario); }

    @RequestMapping(value = "/comentario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        comentarioService.getComentarioById(id);
    }


}
