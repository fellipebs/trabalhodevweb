package com.example.blog.service;

import com.example.blog.model.PerfilAcesso;
import com.example.blog.repository.PerfilAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PerfilAcessoService")
public class PerfilAcessoServiceImpl implements PerfilAcessoService{

    @Autowired
    PerfilAcessoRepository perfilRepository;

    @Override
    public Optional<PerfilAcesso> getPerfilAcessoById(Integer id){ return perfilRepository.findById(id);}

    @Override
    public List<PerfilAcesso> getAllPerfilAcesso() { return perfilRepository.findAll(); }

    @Override
    public void deleteAllPerfilAcesso() {
        perfilRepository.deleteAll();
    }

    @Override
    public void deletePerfilAcessoById(Integer id) {
        perfilRepository.deleteById(id);
    }

    @Override
    public void updatePerfilAcessoById(Integer id, PerfilAcesso perfilAcesso) { perfilRepository.save(perfilAcesso); }

    @Override
    public void updatePerfilAcesso(PerfilAcesso perfilAcesso) {
        perfilRepository.save(perfilAcesso);
    }

    @Override
    public void insertPerfilAcesso(PerfilAcesso perfilAcesso) {
        perfilRepository.save(perfilAcesso);
    }


}
