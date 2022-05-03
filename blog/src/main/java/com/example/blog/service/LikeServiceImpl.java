package com.example.blog.service;

import com.example.blog.model.Like;
import com.example.blog.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("LikeService")
public class LikeServiceImpl implements LikeService{

    @Autowired
    LikeRepository likeRepository;

    @Override
    public Optional<Like> getLikeById(Integer id){ return likeRepository.findById(id);}

    @Override
    public List<Like> getAllLike() { return likeRepository.findAll();}

    @Override
    public void deleteLikeById(Integer id) { likeRepository.deleteAll(); }

    @Override
    public void insertlike(Like like) {
        likeRepository.save(like);
    }
}
