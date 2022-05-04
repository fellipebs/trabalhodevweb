package com.example.blog.repository;

import com.example.blog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UsuarioRepository")
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
}
