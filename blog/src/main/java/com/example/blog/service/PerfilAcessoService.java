package com.example.blog.service;

import com.example.blog.model.PerfilAcesso;
import java.util.List;
import java.util.Optional;

public interface PerfilAcessoService {
    Optional<PerfilAcesso> getPerfilAcessoById(Integer id);
    List<PerfilAcesso> getAllPerfilAcesso();
    void deleteAllPerfilAcesso();
    void deletePerfilAcessoById(Integer id);
    void updatePerfilAcessoById(Integer id, PerfilAcesso PerfilAcesso);
    void updatePerfilAcesso(PerfilAcesso PerfilAcesso);
    void insertPerfilAcesso(PerfilAcesso PerfilAcesso);
}
