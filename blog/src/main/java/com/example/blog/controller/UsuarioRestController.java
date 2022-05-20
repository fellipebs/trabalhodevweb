package com.example.blog.controller;

import com.example.blog.model.Usuario;
import com.example.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> get(){
        return usuarioService.getAllUsuario();
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Optional<Usuario> getName(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public void post(@RequestBody Usuario usuario) { usuarioService.updateUsuario(usuario); }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        usuarioService.getUsuarioById(id);
    }

}
