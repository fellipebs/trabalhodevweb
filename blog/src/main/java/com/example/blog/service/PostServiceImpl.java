package com.example.blog.service;


import com.example.blog.model.Favoritos;
import com.example.blog.model.Like;
import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PostService")
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Optional<Post> getPostById(Integer id){ return postRepository.findById(id);}

    @Override
    public List<Post> getAllPost() { return postRepository.findAll(); }

    @Override
    public void deleteAllPost() {
        postRepository.deleteAll();
    }

    @Override
    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePostById(Integer id, Post post) { postRepository.save(post); }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void insertPost(Post post) {
        postRepository.save(post);
    }


}
