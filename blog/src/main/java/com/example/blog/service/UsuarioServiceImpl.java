package com.example.blog.service;

import com.example.blog.model.Post;
import com.example.blog.model.Usuario;
import com.example.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UsuarioService")
public class UsuarioServiceImpl {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Optional<Post> getUsuarioById(Integer id){ return usuarioRepository.findById(id);}

    @Override
    public void deleteAllUsuario() {
        usuarioRepository.deleteAll();
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void updateUsuarioById(Integer id, Usuario usuario) { usuarioRepository.save(usuario); }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
