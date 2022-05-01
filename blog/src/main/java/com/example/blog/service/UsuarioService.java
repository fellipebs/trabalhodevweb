package com.example.blog.service;

import com.example.blog.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> getUsuarioById(Integer id);

    List<Usuario> getAllUsuario();

    void deleteAllUsuario();

    void deleteUsuarioById(Integer id);

    void updateUsuarioById(Integer id, Usuario usuario);

    void updateUsuario(Usuario usuario);

    void insertUsuario(Usuario usuario);

}
