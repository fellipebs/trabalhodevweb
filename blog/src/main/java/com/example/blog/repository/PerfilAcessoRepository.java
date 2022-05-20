package com.example.blog.repository;

import com.example.blog.model.PerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PerfilAcessoRepository")
public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Integer> {

}
